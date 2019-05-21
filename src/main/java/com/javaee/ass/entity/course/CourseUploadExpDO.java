package com.javaee.ass.entity.course;

import com.javaee.ass.entity.enums.ScoreEnum;
import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.Objects;

@Alias("courseUploadExpDO")
public class CourseUploadExpDO {
    private int pkId;
    private String stuId;
    private int expId;
    private ScoreEnum score;
    private Date uploadTime;

    public CourseUploadExpDO() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public String getStuId() {
        return this.stuId;
    }

    public int getExpId() {
        return this.expId;
    }

    public ScoreEnum getScore() {
        return this.score;
    }

    public Date getUploadTime() {
        return this.uploadTime;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public void setExpId(int expId) {
        this.expId = expId;
    }

    public void setScore(ScoreEnum score) {
        this.score = score;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseUploadExpDO)) return false;
        final CourseUploadExpDO other = (CourseUploadExpDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$stuId = this.stuId;
        final Object other$stuId = other.stuId;
        if (!Objects.equals(this$stuId, other$stuId)) return false;
        if (this.expId != other.expId) return false;
        final Object this$score = this.score;
        final Object other$score = other.score;
        if (!Objects.equals(this$score, other$score)) return false;
        final Object this$uploadTime = this.uploadTime;
        final Object other$uploadTime = other.uploadTime;
        return Objects.equals(this$uploadTime, other$uploadTime);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CourseUploadExpDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $stuId = this.stuId;
        result = result * PRIME + ($stuId == null ? 43 : $stuId.hashCode());
        result = result * PRIME + this.expId;
        final Object $score = this.score;
        result = result * PRIME + ($score == null ? 43 : $score.hashCode());
        final Object $uploadTime = this.uploadTime;
        result = result * PRIME + ($uploadTime == null ? 43 : $uploadTime.hashCode());
        return result;
    }

    public String toString() {
        return "CourseUploadExpDO(pkId=" + this.pkId + ", stuId=" + this.stuId + ", expId=" + this.expId + ", score=" + this.score + ", uploadTime=" + this.uploadTime + ")";
    }
}
