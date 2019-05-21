package com.javaee.ass.controller;

import com.javaee.ass.entity.params.StudentBasicParam;
import com.javaee.ass.entity.role.StudentDO;
import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.AdminService;
import com.javaee.ass.utils.FinalVariablesUtils;
import com.javaee.ass.utils.OSSOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理学生信息
     * @param pageNow 第几页
     * @param type 类型 all - 显示所有学生 / 专业号 - 根据专业号管理学生
     * @param model 传值
     * @return 跳转界面
     */
    @RequestMapping(value = "/manage/{type}/{pageNow}")
    public String listSortedStudents(@PathVariable("pageNow") String pageNow , @PathVariable("type") String type ,
                                 Model model , HttpServletRequest request) {
        List<StudentBasicParam> list = null;
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null && userDO.getRole().getRoleId() == 3) {
            if ("all".equals(type)) {
                list = adminService
                        .listAllStudents(Integer.parseInt(pageNow), FinalVariablesUtils.COURSE_PAGE_SIZE);
            } else {
                list = adminService
                        .listSameMajorStudents(type , Integer.parseInt(pageNow), FinalVariablesUtils.COURSE_PAGE_SIZE);
            }
            model.addAttribute("stuList" , list);
            return "stuManagement";
        } else {
            request.getSession().removeAttribute("loginUser");
            return "login";
        }

    }

    /**
     * 批量导入学生信息
     * @param mvcFile Excel文件
     * @param request Web上下文请求
     * @return 跳转界面
     */
    @RequestMapping(value = "/patch" , method = RequestMethod.POST)
    public String patchImportStudents(@RequestParam("filePatch") MultipartFile mvcFile ,
                                      HttpServletRequest request) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null && userDO.getRole().getRoleId() == 3) {
            List<StudentDO> patchImportList =
                    OSSOperationUtils.patchPreparedStuData(
                            OSSOperationUtils.transferMultipartFileType(mvcFile)
                    );
            adminService.patchStudentsInsert(patchImportList);
            return "redirect:/admin/manage/all/1";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/reset" ,  method = RequestMethod.POST)
    public String resetPwd(@RequestParam("pkId") String pkId , HttpServletRequest request) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");

        if (userDO != null && userDO.getRole().getRoleId() == 3) {
            adminService.updatePassword(pkId , new BCryptPasswordEncoder().encode(pkId));
            return "redirect:/admin/manage/all/1";
        } else {
            return "login";
        }
    }
}
