package com.javaee.ass.entity.course;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("courseExpDO")
public class CourseExpDO {
    private int pkId;
    private String courseId;
    private String expName;
    private String download;

    public CourseExpDO() {
    }


    public int getPkId() {
        return this.pkId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getExpName() {
        return this.expName;
    }

    public String getDownload() {
        return this.download;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseExpDO)) return false;
        final CourseExpDO other = (CourseExpDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$courseId = this.courseId;
        final Object other$courseId = other.courseId;
        if (!Objects.equals(this$courseId, other$courseId)) return false;
        final Object this$expName = this.expName;
        final Object other$expName = other.expName;
        if (!Objects.equals(this$expName, other$expName)) return false;
        final Object this$download = this.download;
        final Object other$download = other.download;
        return Objects.equals(this$download, other$download);
    }

    private boolean canEqual(final Object other) {
        return other instanceof CourseExpDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $courseId = this.courseId;
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        final Object $expName = this.expName;
        result = result * PRIME + ($expName == null ? 43 : $expName.hashCode());
        final Object $download = this.download;
        result = result * PRIME + ($download == null ? 43 : $download.hashCode());
        return result;
    }

    public String toString() {
        return "CourseExpDO(pkId=" + this.pkId + ", courseId=" + this.courseId + ", expName=" + this.expName + ", download=" + this.download + ")";
    }
}
