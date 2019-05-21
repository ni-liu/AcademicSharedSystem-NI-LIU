package com.javaee.ass.entity.enums;

/**
 * 学生对课程打分 / 教师对学生实验打分
 * 1、1分
 * 2、2分
 * 3、3分
 * 4、4分
 * 5、5分
 */
public enum ScoreEnum {
    SCORE_1(1) ,
    SCORE_2(2) ,
    SCORE_3(3) ,
    SCORE_4(4) ,
    SCORE_5(5);

    private int score;

    ScoreEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
