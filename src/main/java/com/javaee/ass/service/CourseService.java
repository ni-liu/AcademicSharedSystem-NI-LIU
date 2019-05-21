package com.javaee.ass.service;

import com.javaee.ass.dao.CourseDAO;
import com.javaee.ass.entity.course.CourseDO;
import com.javaee.ass.entity.enums.FileTypeEnum;
import com.javaee.ass.utils.FinalVariablesUtils;
import com.javaee.ass.utils.OSSOperationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CourseService {

    private final CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    /**
     * 查询所有课程 用分页查找
     * @param pageNow 第几页
     * @return 返回结果集
     */
    public List<CourseDO> listAllByPageNow(int pageNow) {
        List<CourseDO> list = null;
        try {
            list = courseDAO.listAll(pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 通过主键查找课程信息
     * @param pkId 课程主键
     * @return 课程实体
     */
    public CourseDO searchByPkId(String pkId) {
        return courseDAO.searchByPkId(pkId);
    }

    /**
     * 插入一条课程记录 保证课程信息完整性(课程图片和课程大纲)
     * @param course 课程记录
     * @return 插入成功返回true 否则放回false
     */
    public boolean insert(CourseDO course , File picFile , File courseOutline) {
        boolean hasInserted = false;
        if (course.getCoursePic() == null) {
            course.setCoursePic(FinalVariablesUtils.DEFAULT_COURSE_PIC_OSS_URL);
        } else {
            // 图片上传OSS 并获取URL
            course.setCoursePic(OSSOperationUtils.uploadCourseGeneralFile(
                    FileTypeEnum.COURSE_PIC ,
                    picFile ,
                    course.getCourseId()
            ));
        }
        if (course.getCourseOutlineDownload() == null) {
            course.setCourseOutlineDownload(FinalVariablesUtils.DEFAULT_COURSE_OUTLINE_OSS_URL);
        } else {
            // 教学大纲上传OSS 并获取URL
            course.setCourseOutlineDownload(OSSOperationUtils.uploadCourseGeneralFile(
                    FileTypeEnum.COURSE_OUTLINES ,
                    courseOutline ,
                    course.getCourseId()
            ));
        }
        try {
            hasInserted = courseDAO.insert(
                    course.getCourseId(),
                    course.getCourseName(),
                    course.getTeacherId(),
                    course.getMajorId(),
                    course.getCoursePic(),
                    course.getCourseOutlineDownload(),
                    (short) 1,
                    course.getCourseInfo()
            );
            System.err.println("添加成功");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 根据专业号查找相关的课程信息 分页查找
     * @param majorId 专业号
     * @param pageNow 第几页
     * @return 结果集
     */
    public List<CourseDO> listRelevantCourseByMajorId(String majorId , int pageNow) {
        List<CourseDO> list = null;
        try {
            list = courseDAO.listCoursesByMajorId(majorId , pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 根据老师工号查询相关课程信息 分页查找
     * @param teacherId 教师工号
     * @param pageNow 第几页
     * @return 结果集
     */
    public List<CourseDO> listRelevantCourseByTeacherId(String teacherId , int pageNow) {
        List<CourseDO> list = null;
        try {
            list = courseDAO.listCoursesByTeacherId(teacherId , pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 列举精品课程 分页查找
     * @param pageNow 第几页
     * @return 结果集
     */
    public List<CourseDO> listAgreedCourses(int pageNow) {
        List<CourseDO> list= null;
        try {
            list = courseDAO.listAgreedCourses(pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
