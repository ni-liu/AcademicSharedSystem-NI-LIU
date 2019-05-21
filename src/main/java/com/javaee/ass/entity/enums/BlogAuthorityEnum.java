package com.javaee.ass.entity.enums;

/**
 * 博客权限
 * 1、私人
 * 2、公共
 */
public enum BlogAuthorityEnum {
    AUTHORITY_PRIVATE(1) ,
    AUTHORITY_PUBLIC(2);

    private int authority;

    BlogAuthorityEnum(int authority) {
        this.authority = authority;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public static BlogAuthorityEnum getAuthority(int roleId) {
        switch (roleId) {
            case 1 : return AUTHORITY_PRIVATE;
            default : return AUTHORITY_PUBLIC;
        }
    }
}
