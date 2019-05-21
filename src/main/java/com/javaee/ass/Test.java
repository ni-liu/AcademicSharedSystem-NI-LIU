package com.javaee.ass;

import com.javaee.ass.config.RootConfig;
import com.javaee.ass.service.SelectCourseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;


public class Test {
    public static void main(String[] args) {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(RootConfig.class);
//        SelectCourseService selectCourseService = ac.getBean(SelectCourseService.class);
//        System.out.println(selectCourseService.getAvgScoreByCourseId("4019294010"));
        System.out.println(UUID.randomUUID().toString());
    }

//    public static void main(String[] args) {
//        OSSOperationUtils.uploadCourseGeneralFile(FileTypeEnum.COURSE_OUTLINES ,
//                new File("C:\\Users\\倪诚栋\\Documents\\Tencent Files\\1057546042\\FileRecv\\倪诚栋 优良学风先进个人.xlsx") ,
//                "2039210394");
//    }

}
