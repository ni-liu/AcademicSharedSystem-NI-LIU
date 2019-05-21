package com.javaee.ass.dao;

import com.javaee.ass.entity.role.StudentDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentDAO extends GeneralDAO<StudentDO> {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    StudentDO searchByPkId(@Param("pkId") String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    /**
     * 使用存储过程在用户表(ASS_USER)和学生表(ASS_STUDENT)中添加数据
     * @param name 学生姓名
     * @param majorId 学生专业号
     * @return 调用成功返回true 否则返回false
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("pkId") String pkId, @Param("password") String password,
                   @Param("role") short role, @Param("nickname") String nickname,
                   @Param("name") String name, @Param("majorId") String majorId);


}
