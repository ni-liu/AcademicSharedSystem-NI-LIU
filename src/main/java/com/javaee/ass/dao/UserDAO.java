package com.javaee.ass.dao;

import com.javaee.ass.entity.role.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDAO extends GeneralDAO<UserDO> {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    UserDO searchByPkId(@Param("pkId") String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    String searchNicknameByPkId(@Param("pkId") String pkId);

    @Override
    boolean deleteByPkId(String pkId);
}
