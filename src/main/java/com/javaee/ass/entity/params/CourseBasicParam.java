package com.javaee.ass.entity.params;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("courseBasicParam")
public class CourseBasicParam {
    private String courseId;
    private String courseName;
    private String teacherId;
    private String teacherName;
    private String coursePic;

    public CourseBasicParam() {
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

    public String getTeacherName() {
        return this.teacherName;
    }

    public String getCoursePic() {
        return this.coursePic;
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

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseBasicParam)) return false;
        final CourseBasicParam other = (CourseBasicParam) o;
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
        final Object this$teacherName = this.teacherName;
        final Object other$teacherName = other.teacherName;
        if (!Objects.equals(this$teacherName, other$teacherName))
            return false;
        final Object this$coursePic = this.coursePic;
        final Object other$coursePic = other.coursePic;
        return Objects.equals(this$coursePic, other$coursePic);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CourseBasicParam;
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
        final Object $teacherName = this.teacherName;
        result = result * PRIME + ($teacherName == null ? 43 : $teacherName.hashCode());
        final Object $coursePic = this.coursePic;
        result = result * PRIME + ($coursePic == null ? 43 : $coursePic.hashCode());
        return result;
    }

    public String toString() {
        return "CourseBasicParam(courseId=" + this.courseId + ", courseName=" + this.courseName + ", teacherId=" + this.teacherId + ", teacherName=" + this.teacherName + ", coursePic=" + this.coursePic + ")";
    }
}
