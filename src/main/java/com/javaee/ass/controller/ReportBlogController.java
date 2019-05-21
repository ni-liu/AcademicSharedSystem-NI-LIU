package com.javaee.ass.controller;

import com.javaee.ass.entity.blog.BlogReportDO;
import com.javaee.ass.entity.enums.ReportedBlogReasonEnum;
import com.javaee.ass.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/reportBlog")
public class ReportBlogController extends HttpServlet {
    private final BlogService blogService;

    public ReportBlogController(BlogService blogService) {
        this.blogService = blogService;
    }
    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public String reportBlog(@RequestParam("blogId") String blogId, @RequestParam("userId") String userId,
                             @RequestParam("reason") int reason, Model model){
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//设置日期格式
        Date sysTime = new Date();
        BlogReportDO blogReportDO = new BlogReportDO();
        blogReportDO.setUserId(userId);blogReportDO.setBlogId(blogId);
        blogReportDO.setReason(ReportedBlogReasonEnum.getReason(reason));
        System.out.println(ReportedBlogReasonEnum.getReason(reason));
        try{
            blogService.insertBlogReport(blogReportDO,df.format(sysTime));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/showBlogContent/show/"+blogId;
    }
}
