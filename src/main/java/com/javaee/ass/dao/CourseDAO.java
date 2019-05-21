package com.javaee.ass.dao;

import com.javaee.ass.entity.course.CourseDO;
import com.javaee.ass.entity.params.CourseBasicParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseDAO extends GeneralDAO<CourseDO>{

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    CourseDO searchByPkId(@Param("pkId") String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("courseId") String courseId, @Param("courseName") String courseName,
                   @Param("teacherId") String teacherID, @Param("majorId") String majorId,
                   @Param("coursePic") String coursePic, @Param("courseOutlineDownload") String courseOutlineDownload,
                   @Param("hasAgreed") short hasAgreed, @Param("courseInfo") String courseInfo);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseBasicParam> listCoursesByMajorId(@Param("majorId") String majorId,
                                                @Param("pageNow") int pageNow,
                                                @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseBasicParam> listCoursesByTeacherId(@Param("teacherId") String teacherId,
                                                  @Param("pageNow") int pageNow,
                                                  @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseBasicParam> listAgreedCourses(@Param("pageNow") int pageNow, @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseBasicParam> listAll(@Param("pageNow") int pageNow, @Param("pageSize") int pageSize);
}
