package com.javaee.ass.entity.enums;

/**
 * 被举报博客的处理情况
 * 1、待处理
 * 2、已处理
 */
public enum ReportedBlogOperationEnum {
    OPERATE_NO(1) ,
    OPERATE_YES(2);

    private int operation;

    ReportedBlogOperationEnum(int operation) {
        this.operation = operation;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
}
