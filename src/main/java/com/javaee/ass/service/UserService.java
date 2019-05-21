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
}
