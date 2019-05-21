package com.javaee.ass.controller;

import com.javaee.ass.entity.blog.BlogDO;
import com.javaee.ass.service.BlogService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
@RequestMapping("/listBlog")
public class ListBlogController extends HttpServlet {
    private final BlogService blogService;

    public ListBlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/list/{pageNow}", method = RequestMethod.GET)
    public String listBlog(@PathVariable("pageNow") int pageNow , Model model){
        try{
            List<BlogDO> list = blogService.ListAllBlog(pageNow);
            model.addAttribute("listBlog",list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "blog";
    }
}
