package com.javaee.ass.dao;

import com.javaee.ass.entity.role.AdminDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AdminDAO extends GeneralDAO<AdminDO> {

    @Override
    AdminDO searchByPkId(String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    /**
     * 管理员添加管理员角色和教师角色
     * @param name 添加角色姓名
     * @return 调用成功返回true 否则返回false
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("pkId") String pkId , @Param("password") String password ,
                   @Param("role") short role , @Param("nickname") String nickname ,
                   @Param("name") String name);
}
