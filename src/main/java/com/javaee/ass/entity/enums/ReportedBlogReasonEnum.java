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
    REASON_MARKETING(1,"垃圾营销" ) ,
    REASON_YELLOW(2,"涉黄信息" ) ,
    REASON_UNREAL(3, "不实消息") ,
    REASON_ASSAULT(4, "人身攻击") ,
    REASON_BAD(5, "有害信息") ,
    REASON_COPY(6, "内容抄袭") ,
    REASON_ILLEGAL(7,"违法信息") ,
    REASON_CHEAT(8, "诈骗信息");

    private int reasonId;
    private String reasonType;

    ReportedBlogReasonEnum(int reasonId, String reasonYype) {
        this.reasonId = reasonId;
        this.reasonType = reasonYype;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonType() {
        return reasonType;
    }

    public void setReasonType(String reasonYype) {
        this.reasonType = reasonYype;
    }

    public static ReportedBlogReasonEnum getReason(int reasonId) {
        switch (reasonId) {
            case 1 : return REASON_MARKETING;
            case 2 : return REASON_YELLOW;
            case 3 : return REASON_UNREAL;
            case 4 : return REASON_ASSAULT;
            case 5 : return REASON_BAD;
            case 6 : return REASON_COPY;
            case 7 : return REASON_ILLEGAL;
            default: return REASON_CHEAT;
        }
    }
}
