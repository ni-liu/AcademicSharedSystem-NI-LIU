package com.javaee.ass.controller;

import com.javaee.ass.dao.BlogDAO;
import com.javaee.ass.entity.blog.BlogDO;
import com.javaee.ass.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@Controller
@RequestMapping("/showBlogContent")
public class ShowBlogContent extends HttpServlet {
    private final BlogService blogService;

    public ShowBlogContent(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/show/{BlogId}", method = RequestMethod.GET)
    public String showBlogContent(@PathVariable("BlogId") String blogId, Model model){
        try{
            BlogDO blogDO = blogService.SelectBlogById(blogId);
            model.addAttribute("BlogInfo",blogDO);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "blogContent";
    }
}
