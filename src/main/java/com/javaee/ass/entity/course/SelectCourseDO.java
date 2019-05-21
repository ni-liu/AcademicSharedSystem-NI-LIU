package com.javaee.ass.entity.course;

import com.javaee.ass.entity.enums.ScoreEnum;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("selectCourseDO")
public class SelectCourseDO {
    private int pkId;
    private String stuId;
    private String courseId;
    private ScoreEnum score;
    private String schedule;

    public SelectCourseDO() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public String getStuId() {
        return this.stuId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public ScoreEnum getScore() {
        return this.score;
    }

    public String getSchedule() {
        return this.schedule;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setScore(ScoreEnum score) {
        this.score = score;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof SelectCourseDO)) return false;
        final SelectCourseDO other = (SelectCourseDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$stuId = this.stuId;
        final Object other$stuId = other.stuId;
        if (!Objects.equals(this$stuId, other$stuId)) return false;
        final Object this$courseId = this.courseId;
        final Object other$courseId = other.courseId;
        if (!Objects.equals(this$courseId, other$courseId)) return false;
        final Object this$score = this.score;
        final Object other$score = other.score;
        if (!Objects.equals(this$score, other$score)) return false;
        final Object this$schedule = this.schedule;
        final Object other$schedule = other.schedule;
        return Objects.equals(this$schedule, other$schedule);
    }

    private boolean canEqual(final Object other) {
        return other instanceof SelectCourseDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $stuId = this.stuId;
        result = result * PRIME + ($stuId == null ? 43 : $stuId.hashCode());
        final Object $courseId = this.courseId;
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        final Object $score = this.score;
        result = result * PRIME + ($score == null ? 43 : $score.hashCode());
        final Object $schedule = this.schedule;
        result = result * PRIME + ($schedule == null ? 43 : $schedule.hashCode());
        return result;
    }

    public String toString() {
        return "SelectCourseDO(pkId=" + this.pkId + ", stuId=" + this.stuId + ", courseId=" + this.courseId + ", score=" + this.score + ", schedule=" + this.schedule + ")";
    }
}
