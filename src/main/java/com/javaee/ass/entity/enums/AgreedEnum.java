package com.javaee.ass.entity.enums;

/**
 * 精品课程审核情况
 * 1、未提交审核
 * 2、已提交审核待处理
 * 3、已提交审核并通过
 */
public enum AgreedEnum {

    AGREED_NO(1 , "普通课程") ,
    AGREED_WAITING(2 , "待审核") ,
    AGREED_YES(3 , "精品课程");

    private int agreed;
    private String context;

    AgreedEnum(int agreed, String context) {
        this.agreed = agreed;
        this.context = context;
    }

    public int getAgreed() {
        return agreed;
    }

    public void setAgreed(int agreed) {
        this.agreed = agreed;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public static AgreedEnum getAgreeEnum(int agreed) {
        switch (agreed) {
            case 1 : return AgreedEnum.AGREED_NO;
            case 2 : return AgreedEnum.AGREED_WAITING;
            default: return AGREED_YES;
        }
    }
}
