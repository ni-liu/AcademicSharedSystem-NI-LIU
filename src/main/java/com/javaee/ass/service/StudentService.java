package com.javaee.ass.service;

import com.javaee.ass.dao.StudentDAO;
import com.javaee.ass.entity.role.StudentDO;
import com.javaee.ass.entity.role.UserDO;
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

    /**
     * 插入学生 通过存储过程 PRO_USER_ROLE_CASCADE
     * @param userDO 用户实体 PS: role必须是2(学生)
     * @param name 学生姓名
     * @param majorId 专业号
     * @return 调用成功放回true 否则饭后false
     */
    public boolean insert(UserDO userDO , String name , String majorId) {
        boolean hasInserted = false;
        try {
            if (searchByPkId(userDO.getPkId()) == null) {
                studentDAO.insert(
                        userDO.getPkId(),
                        userDO.getPassword(),
                        (short) userDO.getRole().getRoleId(),
                        userDO.getNickName(),
                        name,
                        majorId);
            }
            hasInserted = true;
            System.err.println("添加成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

}
