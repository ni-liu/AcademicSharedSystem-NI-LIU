package com.javaee.ass.entity.enums;

/**
 * 系统角色
 * 1、教师
 * 2、学生
 * 3、管理员
 */
public enum RoleEnum {
    ROLE_TEACHER(1 , "教师") ,
    ROLE_STUDENT(2 , "学生") ,
    ROLE_ADMIN(3 , "管理员");
    private int roleId;
    private String roleType;

    RoleEnum(int roleId, String roleType) {
        this.roleId = roleId;
        this.roleType = roleType;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public static RoleEnum getRole(int roleId) {
        switch (roleId) {
            case 1 : return ROLE_TEACHER;
            case 2 : return ROLE_STUDENT;
            default: return ROLE_ADMIN;
        }
    }
}
