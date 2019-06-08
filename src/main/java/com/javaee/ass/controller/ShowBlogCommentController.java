package com.javaee.ass.controller;

import com.javaee.ass.entity.blog.BlogCommentDO;
import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.BlogService;
import com.javaee.ass.utils.FinalVariablesUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("/blogComment")
public class ShowBlogCommentController extends HttpServlet {
    private final BlogService blogService;

    public ShowBlogCommentController(BlogService blogService) {
        this.blogService = blogService;
    }

    @RequestMapping(value = "/show/{pageNow}", method = RequestMethod.GET)
    public String showBlogComment(HttpServletRequest request, @Param("blogTitle") String blogTitle,
                                  @Param("blogId") String blogId, @Param("userId") String userId,
                                  @PathVariable("pageNow")int pageNow,Model model
                                  ){
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null) {
            try {
                List<BlogCommentDO> list = blogService.SelectBlogCommentByBlogId(blogId, pageNow, FinalVariablesUtils.BLOG_COMMENT_PAGE_SIZE);
                model.addAttribute("listComment", list);
                model.addAttribute("blogTitle", blogTitle);
                model.addAttribute("userId", userId);
                model.addAttribute("blogId", blogId);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return "blogComment";
        }else {
            return "login";
        }
    }
}
