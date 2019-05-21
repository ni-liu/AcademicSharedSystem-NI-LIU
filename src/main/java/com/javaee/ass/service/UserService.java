package com.javaee.ass.service;

import com.javaee.ass.dao.UserDAO;
import com.javaee.ass.entity.role.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDO searchByPkId(String pkId) {
        return userDAO.searchByPkId(pkId);
    }

    public String searchNicknameByPkId(String pkId) {
        return userDAO.searchNicknameByPkId(pkId);
    }

    /**
     * 根据主键查询昵称
     * @param pkId 主键值
     * @param newNickName 新的昵称
     * @return 更新成功返回true 否则返回false
     */
    public boolean updateNickName(String pkId , String newNickName) {
        boolean hasUpdated = false;
        try {
            userDAO.updateNickName(pkId , newNickName);
            hasUpdated = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasUpdated;
    }
}
