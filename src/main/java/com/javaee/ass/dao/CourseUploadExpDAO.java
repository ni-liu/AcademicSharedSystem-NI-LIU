package com.javaee.ass.dao;

import com.javaee.ass.entity.course.CourseUploadExpDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseUploadExpDAO extends GeneralDAO<CourseUploadExpDO> {

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    CourseUploadExpDO searchByPkId(@Param("pkId") int pkId);

    @Override
    boolean deleteByPkId(String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("stuId") String stuId, @Param("expId") int expId,
                   @Param("score") short score, @Param("upload") String upload,
                   @Param("uploadTime") String uploadTime);

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    List<CourseUploadExpDO> listExpDOByExpId(@Param("expId") int expId, @Param("pageNow") int pageNow,
                                             @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    boolean updateScoreByPkId(@Param("pkId") int pkId, @Param("newScore") short newScore);

}