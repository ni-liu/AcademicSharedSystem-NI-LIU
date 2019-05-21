package com.javaee.ass.dao;

import com.javaee.ass.entity.course.SelectCourseDO;
import com.javaee.ass.entity.params.CourseBasicParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SelectCourseDAO extends GeneralDAO<SelectCourseDO> {

    @Override
    SelectCourseDO searchByPkId(String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("stuId") String stuId, @Param("courseId") String courseId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insertScore(@Param("pkId") int pkId, @Param("score") short score);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insertSchedule(@Param("pkId") int pkId, @Param("schedule") String content);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    double searchAvgScoreByCourseId(@Param("courseId") String courseId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseBasicParam> listSelectedCourseByStuId(@Param("stuId") String stuId, @Param("pageNow") int pageNow,
                                                     @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    int ifSelected(@Param("stuId") String stuId, @Param("courseId") String courseId);
}
