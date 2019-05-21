package com.javaee.ass.service;

import com.javaee.ass.dao.CourseUploadExpDAO;
import com.javaee.ass.entity.course.CourseUploadExpDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;

@Service
public class CourseUploadExpService {

    private final CourseUploadExpDAO courseUploadExpDAO;

    @Autowired
    public CourseUploadExpService(CourseUploadExpDAO courseUploadExpDAO) {
        this.courseUploadExpDAO = courseUploadExpDAO;
    }

    /**
     * 插入一条学生上传某门实验的一条记录
     * @param courseUploadExpDO 实验记录实体
     * @return 插入成功返回true 否则返回false
     */
    public boolean insert(CourseUploadExpDO courseUploadExpDO) {
        boolean hasInserted = false;
        try {
            courseUploadExpDAO.insert(
                    courseUploadExpDO.getStuId() ,
                    courseUploadExpDO.getExpId() ,
                    (short) 0 ,
                    courseUploadExpDO.getUpload() ,
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(System.currentTimeMillis())
            );
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 根据主键查询某一条实验上传记录
     * @param pkId 主键
     * @return 有则返回实体 否则返回空
     */
    public CourseUploadExpDO searchByPkId(int pkId) {
        return courseUploadExpDAO.searchByPkId(pkId);
    }

}
