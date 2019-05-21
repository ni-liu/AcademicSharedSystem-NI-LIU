package com.javaee.ass.controller;

import com.javaee.ass.entity.course.CourseDO;
import com.javaee.ass.entity.course.CourseMaterialDO;
import com.javaee.ass.entity.course.CourseUploadExpDO;
import com.javaee.ass.entity.course.MajorDO;
import com.javaee.ass.entity.enums.AgreedEnum;
import com.javaee.ass.entity.enums.FileTypeEnum;
import com.javaee.ass.entity.params.CourseBasicParam;
import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.*;
import com.javaee.ass.utils.FinalVariablesUtils;
import com.javaee.ass.utils.OSSOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;
    private final MajorService majorService;
    private final CourseMaterialService courseMaterialService;
    private final SelectCourseService selectCourseService;
    private final CourseUploadExpService courseUploadExpService;

    @Autowired
    public CourseController(CourseService courseService,
                            MajorService majorService,
                            CourseMaterialService courseMaterialService,
                            SelectCourseService selectCourseService,
                            CourseUploadExpService courseUploadExpService) {
        this.courseService = courseService;
        this.majorService = majorService;
        this.courseMaterialService = courseMaterialService;
        this.selectCourseService = selectCourseService;
        this.courseUploadExpService = courseUploadExpService;
    }

    /**
     * 显示课程
     * @param model request
     * @param pageNow 第一页
     * @return 课程展示页
     */
    @RequestMapping(value = "/{type}/{pageNow}")
    public String courseIndexList(Model model,
                              @PathVariable("type") String type ,
                              @PathVariable("pageNow") String pageNow) {
        List<CourseBasicParam> list =  null;
        switch (type) {
            case "all" : { // 全部课程
                list = courseService.listAllByPageNow(Integer.parseInt(pageNow));
                break;
            }
            case "excl" : { // 精品
                list = courseService.listAgreedCourses(Integer.parseInt(pageNow));
                break;
            }
        }
        Objects.requireNonNull(list).forEach(
                line -> System.out.println(line.toString())
        );
        model.addAttribute("courses" , list);
        model.addAttribute("type" , type);
        return "courseList";
    }


    @RequestMapping(value = "/release")
    public String findForwardToAddCoursePage(HttpServletRequest request , Model model) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null && userDO.getRole().getRoleId() == 1) {
            List<MajorDO> majorList = majorService.listAll();
            model.addAttribute("allMajor" , majorList);
            return "releaseCourse";
        } else {
            return "login";
        }
    }

    /**
     * 添加课程
     * @param request 请求
     * @param courseName 课程名
     * @param courseId 课程号
     * @param majorId 开设专业
     * @param filePic 图片
     * @param fileOutline 大纲
     * @return 跳转界面
     */
    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addCourseInfo(HttpServletRequest request ,
                                @RequestParam("courseName") String courseName ,
                                @RequestParam("courseId") String courseId ,
                                @RequestParam("majorId") String majorId ,
                                @RequestParam("coursePic") MultipartFile filePic ,
                                @RequestParam("courseOutlineDownload") MultipartFile fileOutline) {
        UserDO user = (UserDO) request.getSession().getAttribute("loginUser");
        if (user != null) { // 是否在登录状态
            if (user.getRole().getRoleId() == 1) { // 是否是教师角色
                System.out.println("课程名：" + courseName + " 课号：" + courseId + " 开设专业：" + majorId);
                CourseDO courseDO = new CourseDO();
                courseDO.setCourseName(courseName); courseDO.setCourseId(courseId);
                courseDO.setMajorId(majorId);
                courseDO.setHasAgreed(AgreedEnum.AGREED_NO); courseDO.setTeacherId(user.getPkId());
                courseDO.setCourseInfo("无");
                try {

                    // 表单mvc提交课程  将图片、文件格式进行转化
                    courseService.insert(courseDO ,
                            OSSOperationUtils.transferMultipartFileType(filePic) ,
                            OSSOperationUtils.transferMultipartFileType(fileOutline));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                return "redirect:/course/" + courseId + "?teacherId=" + user.getPkId();
            }
            request.removeAttribute("loginUser");
            return "login";
        } else {
            return "login";
        }
    }

    /**
     * 查看具体的某一门课程
     * @param courseId 课程号
     * @return 跳转页面
     */
    @RequestMapping(value = "/{courseId}" , method = RequestMethod.GET)
    public String showConcreteCourse(@PathVariable("courseId") String courseId ,
                                     Model model ,
                                     @RequestParam("teacherId") String teacherId ,
                                     HttpServletRequest request) {
        try {
            CourseDO whichCourse = courseService.searchByPkId(courseId);
            String majorName = majorService.searchByPkId(whichCourse.getMajorId()).getMajorName();

            UserDO loginUserDO = (UserDO) request.getSession().getAttribute("loginUser");
            boolean flag = false; // 默认没选
            // 角色为学生 是否选了该门课
            if (loginUserDO != null && loginUserDO.getRole().getRoleId() == 2) {
                if (selectCourseService.ifSelected(loginUserDO.getPkId() , courseId) > 0) {
                    flag = true;
                }
            }
            // 只能显示1页 所以实验、模拟试卷在8份以内 Orz
            List<CourseMaterialDO> courseExpsList =
                    courseMaterialService.listCourseMaterials(
                            FileTypeEnum.COURSE_EXPS ,
                            courseId ,
                            1 ,
                            FinalVariablesUtils.COURSE_PAGE_SIZE
                    );
            List<CourseMaterialDO> coursePaperTestsList =
                    courseMaterialService.listCourseMaterials(
                            FileTypeEnum.COURSE_TEST_PAPERS ,
                            courseId ,
                            1 ,
                            FinalVariablesUtils.COURSE_PAGE_SIZE
                    );

            System.out.println(whichCourse.toString() + "\n" + majorName);
            model.addAttribute("whichCourse" , whichCourse);
            model.addAttribute("majorName" , majorName);
            model.addAttribute("teacherName" , teacherId);
            model.addAttribute("expsList" , courseExpsList);
            model.addAttribute("paperTestsList", coursePaperTestsList);
            model.addAttribute("ifSelected" , flag); // 是否选了课 选了 true 否则 false
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "courseInfo";
    }

    /**
     * 添加课程资料
     * @param courseId 课程号
     * @param object 资料类别
     * @param fileName 资料名称
     * @param mvcFile 文件
     * @param request 请求
     * @return 返回值跳转页面
     */
    @RequestMapping(value = "/{courseId}/{object}" , method = RequestMethod.POST)
    public String addCourseMaterial(@PathVariable("courseId") String courseId ,
                                    @PathVariable("object") String object ,
                                    @RequestParam("fileName") String fileName ,
                                    @RequestParam("fileUpload") MultipartFile mvcFile ,
                                    HttpServletRequest request) {
        UserDO loginUser = (UserDO) request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            if (loginUser.getRole().getRoleId() == 1) { // teacher
                CourseMaterialDO courseMaterialDO = new CourseMaterialDO();
                courseMaterialDO.setCourseId(courseId);
                courseMaterialDO.setFileName(fileName);
                if ("exp".equals(object)) { // 上传实验
                    courseMaterialDO.setDownload(
                            OSSOperationUtils.uploadCourseFile(
                                    FileTypeEnum.COURSE_EXPS ,
                                    OSSOperationUtils.transferMultipartFileType(mvcFile) ,
                                    courseId));
                    System.out.println(courseMaterialDO.toString());
                    courseMaterialService.insert(FinalVariablesUtils.TABLE_COURSE_EXPS , courseMaterialDO);
                } else if ("testPaper".equals(object)) { // 上传模拟试卷
                    courseMaterialDO.setDownload(
                            OSSOperationUtils.uploadCourseFile(
                                    FileTypeEnum.COURSE_TEST_PAPERS ,
                                    OSSOperationUtils.transferMultipartFileType(mvcFile) ,
                                    courseId));
                    System.out.println(courseMaterialDO.toString());
                    courseMaterialService.insert(FinalVariablesUtils.TABLE_COURSE_TESTPAPER , courseMaterialDO);
                }
                System.out.println("课程资料上传成功----->");
                return  "redirect:/course/" + courseId + "?teacherId=" + loginUser.getPkId();
            }
        }
        System.out.println("不是teacher角色");
        return "login";
    }

    /**
     * 学生上传实验报告
     * @param request Web上下文
     * @return 跳转页面
     */
    @RequestMapping(value = "/stuUpload" , method = RequestMethod.POST)
    public String uploadExpsByStu(HttpServletRequest request , @RequestParam("expId") String expId ,
                                  @RequestParam("upload") MultipartFile mvcFile ,
                                  @RequestParam("courseId") String courseId ,
                                  @RequestParam("teacherId") String teacherId) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO.getRole().getRoleId() == 2) {
            CourseUploadExpDO courseUploadExpDO = new CourseUploadExpDO();
            courseUploadExpDO.setExpId(Integer.parseInt(expId));
            courseUploadExpDO.setStuId(userDO.getPkId());
            courseUploadExpDO.setUpload(
                    OSSOperationUtils.uploadStuExpFiles(
                            OSSOperationUtils.transferMultipartFileType(mvcFile) ,
                            Integer.parseInt(expId),
                            courseId ,
                            userDO.getPkId()
                    )
            );
            System.err.println(userDO.getPkId() + "学生上传了" + expId + "的实验报告 " + courseUploadExpDO.getUpload());
            courseUploadExpService.insert(courseUploadExpDO);
            return "redirect:/course/" + courseId + "?teacherId=" + teacherId;
        }
        request.getSession().removeAttribute("loginUser");
        return "login";
    }



}
