package com.javaee.ass.controller;

import com.javaee.ass.entity.course.CourseDO;
import com.javaee.ass.entity.enums.AgreedEnum;
import com.javaee.ass.service.CourseService;
import com.javaee.ass.utils.OSSOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public String addCourseInfo(@RequestParam("courseName") String courseName ,
                                @RequestParam("courseId") String courseId ,
                                @RequestParam("majorId") String majorId ,
                                @RequestParam("coursePic") MultipartFile filePic ,
                                @RequestParam("courseOutlineDownload") MultipartFile fileOutline) {
        System.out.println(courseName + courseId + majorId);
        System.out.println(fileOutline.getOriginalFilename());
        CourseDO courseDO = new CourseDO();
        courseDO.setCourseName(courseName); courseDO.setCourseId(courseId);
        courseDO.setHasAgreed(AgreedEnum.AGREED_NO); courseDO.setTeacherId("0506010001");
        courseDO.setCourseInfo("无");
        try {
            // 表单mvc提交课程 默认没有图片 将文件格式进行转化
            courseService.insert(courseDO , null , OSSOperationUtils.transferMultipartFileType(fileOutline));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
