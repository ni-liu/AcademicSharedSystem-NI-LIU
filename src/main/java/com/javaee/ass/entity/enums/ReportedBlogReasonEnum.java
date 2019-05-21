package com.javaee.ass.entity.enums;

/**
 * 举报博客的理由
 * 1、垃圾营销
 * 2、涉黄信息
 * 3、不实信息
 * 4、人身攻击
 * 5、有害信息
 * 6、内容抄袭
 * 7、违法信息
 * 8、诈骗信息
 */
public enum ReportedBlogReasonEnum {
    REASON_MARKETING(1) ,
    REASON_YELLOW(2) ,
    REASON_UNREAL(3) ,
    REASON_ASSAULT(4) ,
    REASON_BAD(5) ,
    REASON_COPY(6) ,
    REASON_ILLEGAL(7) ,
    REASON_CHEAT(8);


    private int reasonId;

    ReportedBlogReasonEnum(int reasonId) {
        this.reasonId = reasonId;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public static String getReason(int reasonId) {
        switch (reasonId) {
            case 1 : return "垃圾营销";
            case 2 : return "涉黄信息";
            case 3 : return "不实消息";
            case 4 : return "人身攻击";
            case 5 : return "有害信息";
            case 6 : return "内容抄袭";
            case 7 : return "违法信息";
            default: return "诈骗信息";
        }
    }
}
