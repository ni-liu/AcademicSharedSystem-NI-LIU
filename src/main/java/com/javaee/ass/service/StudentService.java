package com.javaee.ass.service;

import com.javaee.ass.dao.StudentDAO;
import com.javaee.ass.entity.role.StudentDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentService {
    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentDO searchByPkId(String pkId) {
        return studentDAO.searchByPkId(pkId);
    }

}
