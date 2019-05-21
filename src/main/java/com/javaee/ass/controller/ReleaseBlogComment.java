package com.javaee.ass.controller;

import com.javaee.ass.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/releaseBlogComment")
public class ReleaseBlogComment extends HttpServlet {
    private final BlogService blogService;

    public ReleaseBlogComment(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/release", method = RequestMethod.GET)
    public String releaseBlogComment(@Param("comment") String comment,
                                     @Param("userId") String userId,
                                     @Param("blogId") String blogId,
                                     @Param("blogTitle")String blogTitle,
                                     Model model){
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//设置日期格式
        Date sysTime = new Date();
        try{
            blogService.insertBlogComment(userId,blogId,comment,df.format(sysTime));
            model.addAttribute("blogTitle",blogTitle);
            model.addAttribute("blogId", blogId);
            model.addAttribute("userId",userId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/blogComment/show/1";
    }
}
