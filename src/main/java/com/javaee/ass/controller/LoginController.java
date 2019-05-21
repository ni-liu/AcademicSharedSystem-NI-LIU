package com.javaee.ass.controller;

import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request,
                        @RequestParam("userId") String userId ,
                        @RequestParam("pwd") String pwd) {
        String url = null;
        System.out.println(userId + " " + pwd);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserDO user = userService.searchByPkId(userId);
        if (encoder.matches(pwd , user.getPassword())) {
            System.out.println("登录成功");
            request.getSession().setAttribute("loginUser" , user); // 添加到Session
            url = "redirect:/course/all/1";
        } else {
            System.out.println("登录失败");
            url = "login";
        }
        return url;
    }

    @RequestMapping("/login-out")
    public String loginOut(HttpServletRequest request) {
        if (request.getSession().getAttribute("loginUser") != null) {
            request.getSession().removeAttribute("loginUser");
        }
        return "login";
    }
}
