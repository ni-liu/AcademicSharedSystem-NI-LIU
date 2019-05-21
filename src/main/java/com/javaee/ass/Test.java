package com.javaee.ass;

import com.javaee.ass.config.RootConfig;
import com.javaee.ass.service.BlogService;
import com.javaee.ass.service.StudentService;
import com.javaee.ass.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        System.out.println(RootConfig.class);
        ApplicationContext ac = new AnnotationConfigApplicationContext(RootConfig.class);//检测spring的总配置文件


//        StudentService studentService = ac.getBean(StudentService.class);//spring 注解 不需要new
//        System.out.println(studentService.searchByPkId("1609010001").toString());
//
//        UserService userService = ac.getBean(UserService.class);
//        System.out.println(userService.searchByPkId("1010010001").toString());

        BlogService blogService = ac.getBean(BlogService.class);
        System.out.println(blogService.SelectBlogById("103"));
//        System.out.println(blogService.listBlogByUserNickname("画",1));
//        blogService.insertBlog("1010010001","j2EE的环境配置","12345678",
//                "2019-5-1",2);
//        System.out.println(blogService.searchByBlogTitle("oracle").toString());
//        blogService.deleteByPkId("43");
//        System.out.println(blogService.searchOwnBlog("1010010001"));
//        System.out.println(blogService.searchByUserNickname("画").toString());

//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
//        Date sysTime = new Date();
//        System.out.println(df.format(sysTime));
    }
}
