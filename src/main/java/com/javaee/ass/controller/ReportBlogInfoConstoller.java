package com.javaee.ass.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/showReportBlog")
public class ReportBlogInfoConstoller {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String  showReportBlog(@RequestParam("blogTitle") String blogTitle, @RequestParam("blogId") String blogId,
                                  @RequestParam("userId") String userId, @RequestParam("nickName") String nickName, Model model){
        model.addAttribute("blogTitle",blogTitle);
        model.addAttribute("blogId",blogId);
        model.addAttribute("userId",userId);
        model.addAttribute("nickName",nickName);
        return "blogReport";
    }
}
