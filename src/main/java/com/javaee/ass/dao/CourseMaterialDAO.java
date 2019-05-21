package com.javaee.ass.dao;

import com.javaee.ass.entity.course.CourseMaterialDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseMaterialDAO extends GeneralDAO<CourseMaterialDO> {

    @Override
    CourseMaterialDO searchByPkId(String pkId);

    @Override
    boolean deleteByPkId(String pkId);

    /**
     * 添加课程资料
     * @param type 模拟试卷 or 实验报告
     * @param courseId 课程号
     * @param fileName 名称
     * @param download 下载地址
     * @return 成功返回true 否则false
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insert(@Param("type") String type, @Param("courseId") String courseId,
                   @Param("fileName") String fileName, @Param("download") String download);


    /**
     * 查询课程的实验
     * @param courseId 课程号
     * @return 结果集
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<CourseMaterialDO> listCourseExps(@Param("courseId") String courseId, @Param("pageNow") int pageNow,
                                          @Param("pageSize") int pageSize);

    List<CourseMaterialDO> listCoursePaperTests(@Param("courseId") String courseId, @Param("pageNow") int pageNow,
                                                @Param("pageSize") int pageSize);

}
