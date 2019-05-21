package com.javaee.ass.entity.course;

import com.javaee.ass.entity.enums.AgreedEnum;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("courseDO")
public class CourseDO {
    private String courseId;
    private String courseName;
    private String teacherId;
    private String majorId;
    private String coursePic;
    private String courseOutlineDownload;
    private AgreedEnum hasAgreed;
    private String courseInfo;

    public CourseDO() {
    }

    public String getCourseId() {
        return this.courseId;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public String getTeacherId() {
        return this.teacherId;
    }

    public String getMajorId() {
        return this.majorId;
    }

    public String getCoursePic() {
        return this.coursePic;
    }

    public String getCourseOutlineDownload() {
        return this.courseOutlineDownload;
    }

    public AgreedEnum getHasAgreed() {
        return this.hasAgreed;
    }

    public String getCourseInfo() {
        return this.courseInfo;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public void setCourseOutlineDownload(String courseOutlineDownload) {
        this.courseOutlineDownload = courseOutlineDownload;
    }

    public void setHasAgreed(AgreedEnum hasAgreed) {
        this.hasAgreed = hasAgreed;
    }

    public void setCourseInfo(String courseInfo) {
        this.courseInfo = courseInfo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseDO)) return false;
        final CourseDO other = (CourseDO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$courseId = this.courseId;
        final Object other$courseId = other.courseId;
        if (!Objects.equals(this$courseId, other$courseId)) return false;
        final Object this$courseName = this.courseName;
        final Object other$courseName = other.courseName;
        if (!Objects.equals(this$courseName, other$courseName))
            return false;
        final Object this$teacherId = this.teacherId;
        final Object other$teacherId = other.teacherId;
        if (!Objects.equals(this$teacherId, other$teacherId)) return false;
        final Object this$majorId = this.majorId;
        final Object other$majorId = other.majorId;
        if (!Objects.equals(this$majorId, other$majorId)) return false;
        final Object this$coursePic = this.coursePic;
        final Object other$coursePic = other.coursePic;
        if (!Objects.equals(this$coursePic, other$coursePic)) return false;
        final Object this$courseOutlineDownload = this.courseOutlineDownload;
        final Object other$courseOutlineDownload = other.courseOutlineDownload;
        if (!Objects.equals(this$courseOutlineDownload, other$courseOutlineDownload))
            return false;
        final Object this$hasAgreed = this.hasAgreed;
        final Object other$hasAgreed = other.hasAgreed;
        if (!Objects.equals(this$hasAgreed, other$hasAgreed)) return false;
        final Object this$courseInfo = this.courseInfo;
        final Object other$courseInfo = other.courseInfo;
        return Objects.equals(this$courseInfo, other$courseInfo);
    }

    private boolean canEqual(final Object other) {
        return other instanceof CourseDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $courseId = this.courseId;
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        final Object $courseName = this.courseName;
        result = result * PRIME + ($courseName == null ? 43 : $courseName.hashCode());
        final Object $teacherId = this.teacherId;
        result = result * PRIME + ($teacherId == null ? 43 : $teacherId.hashCode());
        final Object $majorId = this.majorId;
        result = result * PRIME + ($majorId == null ? 43 : $majorId.hashCode());
        final Object $coursePic = this.coursePic;
        result = result * PRIME + ($coursePic == null ? 43 : $coursePic.hashCode());
        final Object $courseOutlineDownload = this.courseOutlineDownload;
        result = result * PRIME + ($courseOutlineDownload == null ? 43 : $courseOutlineDownload.hashCode());
        final Object $hasAgreed = this.hasAgreed;
        result = result * PRIME + ($hasAgreed == null ? 43 : $hasAgreed.hashCode());
        final Object $courseInfo = this.courseInfo;
        result = result * PRIME + ($courseInfo == null ? 43 : $courseInfo.hashCode());
        return result;
    }

    public String toString() {
        return "CourseDO(courseId=" + this.courseId + ", courseName=" + this.courseName + ", teacherId=" + this.teacherId + ", majorId=" + this.majorId + ", coursePic=" + this.coursePic + ", courseOutlineDownload=" + this.courseOutlineDownload + ", hasAgreed=" + this.hasAgreed + ", courseInfo=" + this.courseInfo + ")";
    }
}
