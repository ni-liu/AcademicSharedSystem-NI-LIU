package com.javaee.ass.entity.course;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("majorDO")
public class MajorDO {
    private String majorId;
    private String majorName;

    public MajorDO() {
    }


    public String getMajorId() {
        return this.majorId;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MajorDO)) return false;
        final MajorDO other = (MajorDO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$majorId = this.majorId;
        final Object other$majorId = other.majorId;
        if (!Objects.equals(this$majorId, other$majorId)) return false;
        final Object this$majorName = this.majorName;
        final Object other$majorName = other.majorName;
        return Objects.equals(this$majorName, other$majorName);
    }

    private boolean canEqual(final Object other) {
        return other instanceof MajorDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $majorId = this.majorId;
        result = result * PRIME + ($majorId == null ? 43 : $majorId.hashCode());
        final Object $majorName = this.majorName;
        result = result * PRIME + ($majorName == null ? 43 : $majorName.hashCode());
        return result;
    }

    public String toString() {
        return "MajorDO(majorId=" + this.majorId + ", majorName=" + this.majorName + ")";
    }
}
