package com.javaee.ass.controller;

import com.javaee.ass.entity.blog.BlogDO;
import com.javaee.ass.entity.enums.BlogAuthorityEnum;
import com.javaee.ass.entity.enums.FileTypeEnum;
import com.javaee.ass.service.BlogService;
import com.javaee.ass.utils.OSSOperationUtils;
import com.javaee.ass.utils.Txt2PDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServlet;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/releaseBlog")
public class ReleaseBlogController extends HttpServlet {
    private final BlogService blogService;

    @Autowired
    public ReleaseBlogController(BlogService blogService) {
        this.blogService = blogService;
    }


    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addBlogInfo(@RequestParam("userId") String userId, @RequestParam("blogTitle") String blogTitle,
                              @RequestParam("blogContent") String blogContent, @RequestParam("authority") int  authority,
                              @RequestParam("blogAttachmentDownload") MultipartFile blogAttachment){
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//设置日期格式
        Date sysTime = new Date();
        //System.out.println(userId + blogTitle + blogContent + BlogAuthorityEnum.getAuthority(authority) + blogAttachment.getOriginalFilename());
        BlogDO blogDO = new BlogDO();
        blogDO.setUserId(userId);
        blogDO.setBlogTitle(blogTitle);
        blogDO.setAuthority(BlogAuthorityEnum.getAuthority(authority));
        String filePath = "D:\\learning\\JavaEE\\Design\\code\\AcademicSharedSystem\\src\\main\\java\\com\\javaee\\ass\\txt\\blogContent.txt";
        FileWriter fileWriter = null;
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.write(blogContent.getBytes("UTF-8"));
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String Path = "D:\\learning\\JavaEE\\Design\\code\\AcademicSharedSystem\\src\\main\\java\\com\\javaee\\ass\\txt\\";
        String txtPath = Path + "blogContent.txt";
        String pdfPath = Path + "blogContent_txt.pdf";
        try {
            Txt2PDF.text2pdf(txtPath, pdfPath);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        blogDO.setBlogContent(OSSOperationUtils.uploadBlogGeneralFile(
                FileTypeEnum.BLOG_CONTENT,
                new File(pdfPath),
                blogDO.getUserId(),
                df.format(sysTime)
        ));
        //System.out.println("正文成功");
        blogDO.setBlogAttachment(OSSOperationUtils.uploadBlogGeneralFile(
                FileTypeEnum.BLOG_ATTACHMENT,
                OSSOperationUtils.transferMultipartFileType(blogAttachment),
                blogDO.getUserId(),
                df.format(sysTime))
        );
        // system.out.println("附件成功");
        try{
            blogService.insertBlog(blogDO, df.format(sysTime));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/listBlog/list/1";
    }
}
