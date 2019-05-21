package com.javaee.ass.service;

import com.javaee.ass.dao.CourseMaterialDAO;
import com.javaee.ass.entity.course.CourseMaterialDO;
import com.javaee.ass.entity.enums.FileTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseMaterialService {
    private final CourseMaterialDAO courseMaterialDAO;

    @Autowired
    public CourseMaterialService(CourseMaterialDAO courseMaterialDAO) {
        this.courseMaterialDAO = courseMaterialDAO;
    }

    public boolean insert(String type , CourseMaterialDO courseMaterialDO) {
        boolean hasInserted = false;
        try {
            courseMaterialDAO.insert(type , courseMaterialDO.getCourseId() ,
                    courseMaterialDO.getFileName() , courseMaterialDO.getDownload());
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 课程资料
     * @param type 资料类型
     * @param courseId 课程号
     * @param pageNow 第几页
     * @param pageSize 显示多少
     * @return 结果集
     */
    public List<CourseMaterialDO> listCourseMaterials(FileTypeEnum type , String courseId ,
                                                      int pageNow , int pageSize) {
        List<CourseMaterialDO> list = null;
        try {
            switch (type.getType()) {
                case 3 : { //EXPS
                    list = courseMaterialDAO.listCourseExps(courseId , pageNow , pageSize);
                    break;
                }
                case 4 : { // TEST_PAPERS
                    list = courseMaterialDAO.listCoursePaperTests(courseId , pageNow , pageSize);
                    break;
                }
            }
            Objects.requireNonNull(list).forEach(
                    line -> System.err.println(line.toString())
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
