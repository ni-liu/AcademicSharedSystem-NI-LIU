package com.javaee.ass.controller;


import com.javaee.ass.entity.blog.BlogDO;
import com.javaee.ass.service.BlogService;
import com.javaee.ass.utils.FinalVariablesUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import java.util.List;

@Controller
@RequestMapping("/queryBlog")
public class QueryBlogByInfoController extends HttpServlet {
    private final BlogService blogService;

    public QueryBlogByInfoController(BlogService blogService) {
        this.blogService = blogService;
    }
    @RequestMapping(value = "/query/{pageNow}", method = RequestMethod.GET)
    public String queryBlogByInfo(@Param("blogInfo") String blogInfo,
                                    @PathVariable("pageNow") int pageNow,
                                  Model model){
//        System.out.println(blogInfo);
//        System.out.println(pageNow);
        try{
            List<BlogDO> list = blogService.SelectBlogByInfo(blogInfo, pageNow, FinalVariablesUtils.COURSE_PAGE_SIZE);
//            System.out.println(list.get(0).getLaunchTime());
            model.addAttribute("listBlog",list);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "blog";
    }
}
