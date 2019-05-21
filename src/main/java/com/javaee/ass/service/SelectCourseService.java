package com.javaee.ass.service;

import com.javaee.ass.dao.SelectCourseDAO;
import com.javaee.ass.entity.course.SelectCourseDO;
import com.javaee.ass.entity.enums.ScoreEnum;
import com.javaee.ass.entity.params.CourseBasicParam;
import com.javaee.ass.utils.FinalVariablesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectCourseService {
    private final SelectCourseDAO selectCourseDAO;

    @Autowired
    public SelectCourseService(SelectCourseDAO selectCourseDAO) {
        this.selectCourseDAO = selectCourseDAO;
    }

    /**
     * 插入一条选课记录
     * @param selectCourseDO 选课
     * @return 成功返回true 否则返回false
     */
    public boolean insert(SelectCourseDO selectCourseDO) {
        boolean hasInserted = false;
        try {
            selectCourseDAO.insert(
                    selectCourseDO.getStuId() ,
                    selectCourseDO.getCourseId()
            );
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 学生为选的课打分 只能打分以此（数据库层检查是否已添加数据）
     * @param pkId 选课主键
     * @param score 枚举类 分数
     * @return 插入成功返回true 否则返回false
     */
    public boolean insertScore(int pkId , ScoreEnum score) {
        boolean hasInserted = false;
        try {
            selectCourseDAO.insertScore(pkId , (short) score.getScore());
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 学生为课程添加学习计划小结 可更新
     * @param pkId 选课主键
     * @param content 新的内容
     * @return 插入成功返回true 否则返回false
     */
    public boolean insertSchedule(int pkId , String content) {
        boolean hasInserted = false;
        try {
            selectCourseDAO.insertSchedule(pkId , content);
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 根据课程号查询学生的平均打分情况 如返回-1.0则表示没有打分情况
     * @param courseId 课程号
     * @return 返回平均打分情况 未打分则返回-1.0
     */
    public double getAvgScoreByCourseId(String courseId) {
        double avg = -1.0;
        try {
            avg = selectCourseDAO.searchAvgScoreByCourseId(courseId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return avg;
    }

    /**
     * 根据学生号和课程号查询是该学生是否选了该门课
     * @param stuId 学生好
     * @param courseId 课程号
     * @return 选了返回大于0的数 否则返回0
     */
    public int ifSelected(String stuId , String courseId) {
        int row = 0;
        try {
            row = selectCourseDAO.ifSelected(stuId , courseId);
            if (row > 0) {
                System.out.println(stuId + "选到了" + courseId + "的课");
            } else {
                System.out.println(stuId + "没有选到" + courseId + "的课");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return row;
    }

    /**
     * 查询某学生选了哪些课
     * @param stuId 学生好
     * @param pageNow 第几页
     * @return 结果集
     */
    public List<CourseBasicParam> listSelectedCoursesByStuId(String stuId , int pageNow) {
        List<CourseBasicParam> list = null;
        try {
            list = selectCourseDAO.listSelectedCourseByStuId(stuId , pageNow , FinalVariablesUtils.COURSE_PAGE_SIZE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}

