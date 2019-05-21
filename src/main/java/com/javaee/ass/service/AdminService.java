package com.javaee.ass.service;

import com.javaee.ass.dao.AdminDAO;
import com.javaee.ass.entity.params.StudentBasicParam;
import com.javaee.ass.entity.role.StudentDO;
import com.javaee.ass.entity.role.UserDO;
import com.javaee.ass.utils.FinalVariablesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    private final AdminDAO adminDAO;
    private final StudentService studentService;

    @Autowired
    public AdminService(AdminDAO adminDAO, StudentService studentService) {
        this.adminDAO = adminDAO;
        this.studentService = studentService;
    }
    /**
     * 插入管理员
     * @param user 用户实体
     * @param name 管理员昵称
     * @return 插入成功返回true 否则返回false
     */
    public boolean insert(UserDO user , String name) {
        boolean hasInserted = false;
        try {
            adminDAO.insert(
                    user.getPkId(),
                    user.getPassword(),
                    (short) user.getRole().getRoleId(),
                    user.getNickName(),
                    name
            );
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    public boolean patchStudentsInsert(List<StudentDO> patchList) {
        boolean hasAllInserted = false;
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        try {
            patchList.forEach(
                    line -> {
                        UserDO userDO = new UserDO();
                        userDO.setPkId(line.getPkId());
                        userDO.setPassword(encoder.encode(line.getPassword()));
                        userDO.setRole(line.getRole());
                        userDO.setNickName(line.getNickName());
                        studentService.insert(
                                userDO ,
                                line.getName() ,
                                line.getMajorId()
                        );
                    }
            );
            hasAllInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasAllInserted;
    }

    /**
     * 重置密码 / 修改密码
     * @param pkId 主键号
     * @param newPwd 新的密码 已加密
     * @return 更新成功true 否则返回false
     */
    public boolean updatePassword(String pkId , String newPwd) {
        boolean hasUpdated = false;
        try {
            adminDAO.updatePassword(pkId , newPwd);
            hasUpdated = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasUpdated;
    }


    /**
     * 列举所有学生
     * @param pageNow 第几页
     * @param pageSize 分页大小
     * @return 查找成功返回true 否则返回false
     */
    public List<StudentBasicParam> listAllStudents(int pageNow , int pageSize) {
        List<StudentBasicParam> list = null;
        try {
            list = adminDAO.listAllStus(pageNow , pageSize);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;

    }

    /**
     * 根据专业列举相关学生
     * @param majorId 专业号
     * @param pageNow 第几页
     * @param pageSize 分页大小
     * @return 查找成功返回true 否则返回false
     */
    public List<StudentBasicParam> listSameMajorStudents(String majorId , int pageNow , int pageSize) {
        List<StudentBasicParam> list = null;
        try {
            list = adminDAO.listStusByMajorId(majorId , pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
