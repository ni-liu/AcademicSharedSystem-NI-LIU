package com.javaee.ass;

import com.javaee.ass.config.RootConfig;
import com.javaee.ass.service.StudentService;
import com.javaee.ass.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(RootConfig.class);
        StudentService studentService = ac.getBean(StudentService.class);
        System.out.println(studentService.searchByPkId("1609010001").toString());
        System.out.println();
        UserService userService = ac.getBean(UserService.class);
        System.out.println(userService.searchByPkId("1010010001").toString());
    }
}
