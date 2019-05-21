package com.javaee.ass.entity.enums;

/**
 * 博客态度
 * 0、赞
 * 1、踩
 */
public enum BlogAttitudeEnum {
    ATTITUDE_GOOD(0) ,
    ATTITUDE_BAD(1);

    private int attitude;

    BlogAttitudeEnum(int attitude) {
        this.attitude = attitude;
    }

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }
}
