package com.javaee.ass.entity.enums;

/**
 * 精品课程审核情况
 * 1、未提交审核
 * 2、已提交审核待处理
 * 3、已提交审核并通过
 */
public enum AgreedEnum {

    AGREED_NO(1) ,
    AGREED_WAITING(2) ,
    AGREED_YES(3);

    private int agreed;

    AgreedEnum(int agreed) {
        this.agreed = agreed;
    }

    public int getAgreed() {
        return agreed;
    }

    public void setAgreed(int agreed) {
        this.agreed = agreed;
    }
}
