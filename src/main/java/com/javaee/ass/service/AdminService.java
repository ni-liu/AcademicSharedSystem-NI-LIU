package com.javaee.ass.service;

import com.javaee.ass.dao.AdminDAO;
import com.javaee.ass.entity.role.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private final AdminDAO adminDAO;

    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public boolean insert(UserDO user , String name) {
        boolean hasInserted = false;
        try {
            adminDAO.insert(
                    user.getPkId(),
                    user.getPassword(),
                    (short) user.getRole().getRoleId(),
                    user.getNickName(),
                    name
            );
            hasInserted = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hasInserted;
    }
}
