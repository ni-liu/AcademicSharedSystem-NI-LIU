package com.javaee.ass.entity.enums;

public enum FileTypeEnum {
    COURSE_PIC(1) ,
    COURSE_OUTLINES(2) ,
    COURSE_EXPS(3) ,
    COURSE_TEST_PAPERS(4) ,
    BLOG_ATTACHMENT(5);


    private int type;

    FileTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
