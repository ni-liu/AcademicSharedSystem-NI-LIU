package com.javaee.ass.service;

import com.javaee.ass.dao.MajorDAO;
import com.javaee.ass.entity.course.MajorDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorService {
    private final MajorDAO majorDAO;

    @Autowired
    public MajorService(MajorDAO majorDAO) {
        this.majorDAO = majorDAO;
    }

    /**
     * 查询所有专业记录
     * @return 结果集
     */
    public List<MajorDO> listAll() {
        List<MajorDO> list = null;
        try {
           list = majorDAO.listAll();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 根据主键查找专业
     * @param pkId 主键
     * @return 结果
     */
    public MajorDO searchByPkId(String pkId) {
        return majorDAO.searchByPkId(pkId);
    }

    /**
     * 插入专业记录
     * @param pkId 专业号
     * @param majorName 专业名
     * @return 插入成功 true 否则 false
     */
    public boolean insert(String pkId , String majorName) {
        boolean hasInserted = false;
        try {
            majorDAO.insert(pkId , majorName);
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }

    /**
     * 关键字查找 模糊查询
     * @param keyWord 关键系
     * @return 结果集
     */
    public List<MajorDO> searchByKeyWord(String keyWord) {
        List<MajorDO> list = null;
        try {
            list = majorDAO.searchByKeyWords(keyWord);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }


}
