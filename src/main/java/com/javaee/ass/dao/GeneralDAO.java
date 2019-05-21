package com.javaee.ass.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface GeneralDAO<T> {

    /**
     * 主键查询
     * @param pkId 主键值
     * @return 返回结果 - 实体
     */
    T searchByPkId(String pkId); // 必要时主键转化为 int

    /**
     * 主键删除
     * @param pkId 主键值
     * @return 成功返回true 否则返回false
     */
    boolean deleteByPkId(String pkId); // 必要时主键转化为 int

    /**
     * 插入一条数据库记录
     * @param tmp 数据
     * @return 插入成功返回true 否则返回false
     */
    boolean insert(T tmp);
}
