package com.javaee.ass.service;

import com.javaee.ass.dao.SelectCourseDAO;
import com.javaee.ass.entity.course.SelectCourseDO;
import com.javaee.ass.entity.enums.ScoreEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

