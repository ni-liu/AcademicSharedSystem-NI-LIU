package com.javaee.ass.entity.course;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("courseMaterialDO")
public class CourseMaterialDO {
    private int pkId;
    private String courseId;
    private String fileName;
    private String download;

    public CourseMaterialDO() {
    }


    public int getPkId() {
        return this.pkId;
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getFileName() {
        return this.fileName;
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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseMaterialDO)) return false;
        final CourseMaterialDO other = (CourseMaterialDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$courseId = this.courseId;
        final Object other$courseId = other.courseId;
        if (!Objects.equals(this$courseId, other$courseId)) return false;
        final Object this$expName = this.fileName;
        final Object other$expName = other.fileName;
        if (!Objects.equals(this$expName, other$expName)) return false;
        final Object this$download = this.download;
        final Object other$download = other.download;
        return Objects.equals(this$download, other$download);
    }

    private boolean canEqual(final Object other) {
        return other instanceof CourseMaterialDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $courseId = this.courseId;
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        final Object $expName = this.fileName;
        result = result * PRIME + ($expName == null ? 43 : $expName.hashCode());
        final Object $download = this.download;
        result = result * PRIME + ($download == null ? 43 : $download.hashCode());
        return result;
    }

    public String toString() {
        return "CourseMaterialDO(pkId=" + this.pkId + ", courseId=" + this.courseId + ", fileName=" + this.fileName + ", download=" + this.download + ")";
    }
}
