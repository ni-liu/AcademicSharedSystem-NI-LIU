package com.javaee.ass.dao;

import com.javaee.ass.entity.course.MajorDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MajorDAO extends GeneralDAO<MajorDO> {

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    MajorDO searchByPkId(@Param("pkId") String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("pkId") String pkId , @Param("majorName") String majorName);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<MajorDO> listAll();

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<MajorDO> searchByKeyWords(@Param("keyWord") String keyWord);
}
