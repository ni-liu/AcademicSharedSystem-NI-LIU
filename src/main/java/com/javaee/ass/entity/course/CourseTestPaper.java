package com.javaee.ass.entity.course;

import java.util.Objects;

public class CourseTestPaper {
    private int pkId;
    private int courseId;
    private String paperName;
    private String download;

    public CourseTestPaper() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public int getCourseId() {
        return this.courseId;
    }

    public String getPaperName() {
        return this.paperName;
    }

    public String getDownload() {
        return this.download;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setPaperName(String paperName) {
        this.paperName = paperName;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseTestPaper)) return false;
        final CourseTestPaper other = (CourseTestPaper) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        if (this.courseId != other.courseId) return false;
        final Object this$paperName = this.paperName;
        final Object other$paperName = other.paperName;
        if (!Objects.equals(this$paperName, other$paperName)) return false;
        final Object this$download = this.download;
        final Object other$download = other.download;
        return Objects.equals(this$download, other$download);
    }

    private boolean canEqual(final Object other) {
        return other instanceof CourseTestPaper;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        result = result * PRIME + this.courseId;
        final Object $paperName = this.paperName;
        result = result * PRIME + ($paperName == null ? 43 : $paperName.hashCode());
        final Object $download = this.download;
        result = result * PRIME + ($download == null ? 43 : $download.hashCode());
        return result;
    }

    public String toString() {
        return "CourseTestPaper(pkId=" + this.pkId + ", courseId=" + this.courseId + ", paperName=" + this.paperName + ", download=" + this.download + ")";
    }
}
