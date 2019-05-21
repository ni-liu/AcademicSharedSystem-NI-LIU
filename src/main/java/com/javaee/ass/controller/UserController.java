package com.javaee.ass.controller;

import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.AdminService;
import com.javaee.ass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final AdminService adminService;

    @Autowired
    public UserController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }

    /**
     * 显示用户基本信息
     * @param request Web上下文
     * @return 跳转界面
     */
    @RequestMapping(value = "/info")
    public String showUserInfoFrom(HttpServletRequest request) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null) {
            return "";
        } else {
            return "login";
        }

    }

    /**
     * 更加自己的昵称
     * @param newNickName 新的昵称
     * @param request Web上下文
     * @return 跳转页面
     */
    @RequestMapping(value = "/uNN" , method = RequestMethod.POST)
    public String updateNewNickName(@RequestParam("newNickName") String newNickName ,
                                    HttpServletRequest request) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");

        if (userDO != null) {
            userService.updateNickName(userDO.getPkId() , newNickName);
            return "";
        } else {
            return "login";
        }
    }


    /**
     * 更改自己的密码
     * @param request Web上下文
     * @param old 原先的密码Raw
     * @param newFirst 修改后的第一次输入的密码Raw
     * @param newSecond 第二次修改的密码Raw
     * @return 跳转界面
     */
    @RequestMapping(value = "/pwd" , method = RequestMethod.POST)
    public String changePwd(HttpServletRequest request , @RequestParam("old") String old ,
                            @RequestParam("newFirst") String newFirst  , @RequestParam("newSecond") String newSecond) {

        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(old , userDO.getPassword())) {
                if (newFirst.equals(newSecond)) {
                    adminService.updatePassword(userDO.getPkId() , encoder.encode(newFirst));
                    return "redirect:/user/info";
                } else {
                    return "redirect:/user/info";
                }
            } else {
                return "redirect:/user/info";
            }
        } else {
            return "login";
        }
    }
}
