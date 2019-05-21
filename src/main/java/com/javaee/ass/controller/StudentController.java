package com.javaee.ass.controller;

import com.javaee.ass.entity.course.SelectCourseDO;
import com.javaee.ass.entity.params.CourseBasicParam;
import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.service.CourseService;
import com.javaee.ass.service.SelectCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/stu")
public class StudentController {
    private final CourseService courseService;
    private final SelectCourseService selectCourseService;

    public StudentController(CourseService courseService, SelectCourseService selectCourseService) {
        this.courseService = courseService;
        this.selectCourseService = selectCourseService;
    }

    @RequestMapping("/{func}/{pageNow}")
    public String courseSelectedIndex(HttpServletRequest request , Model model , @PathVariable("func") String func ,
                                      @PathVariable("pageNow") String pageNow) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");
        if (userDO != null && userDO.getRole().getRoleId() == 2) {
            List<CourseBasicParam> list = selectCourseService.listSelectedCoursesByStuId(userDO.getPkId() , Integer.parseInt(pageNow));
            list.forEach(
                    line -> System.err.println(line.toString())
            );
            if ("selected".equals(func)) {
                model.addAttribute("courses", list);
                model.addAttribute("func", "selected");
                return "courseList";
            }
            model.addAttribute("courses", list);
            return "scoreCourse";

        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/courseSelect" , method = RequestMethod.POST)
    public String courseSelect(HttpServletRequest request , @RequestParam("courseId") String courseId ,
                               @RequestParam("teacherId") String teacherId) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");

        if (userDO != null && userDO.getRole().getRoleId() == 2) {
            SelectCourseDO selectCourseDO = new SelectCourseDO();
            selectCourseDO.setStuId(userDO.getPkId());
            selectCourseDO.setCourseId(courseId);
            selectCourseService.insert(selectCourseDO);
            return "redirect:/course/" + courseId + "?teacherId=" + teacherId;
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/markScore" , method = RequestMethod.POST)
    public String markSelectedCourses(HttpServletRequest request) {
        UserDO userDO = (UserDO) request.getSession().getAttribute("loginUser");

        if (userDO != null && userDO.getRole().getRoleId() == 2) {
            String[] scores = request.getParameterValues("scores");
            for (String score : scores) {
                System.out.println(score);
            }
            return "";
        } else {
            return "login";
        }
    }

}
