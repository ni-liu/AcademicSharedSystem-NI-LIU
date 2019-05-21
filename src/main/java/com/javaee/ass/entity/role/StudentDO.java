package com.javaee.ass.entity.role;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("studentDO")
public class StudentDO extends UserDO {
    private String name;
    private String majorId;

    public StudentDO() {
    }

    public String getName() {
        return this.name;
    }

    public String getMajorId() {
        return this.majorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StudentDO)) return false;
        final StudentDO other = (StudentDO) o;
        if (other.canEqual((Object) this)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (!Objects.equals(this$name, other$name)) return false;
        final Object this$majorId = this.majorId;
        final Object other$majorId = other.majorId;
        return Objects.equals(this$majorId, other$majorId);
    }

    protected boolean canEqual(final Object other) {
        return !(other instanceof StudentDO);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $majorId = this.majorId;
        result = result * PRIME + ($majorId == null ? 43 : $majorId.hashCode());
        return result;
    }

    public String toString() {

        return super.toString() +
                "\n" +
                "StudentDO(name=" + this.name + ", majorId=" + this.majorId + ")";
    }
}
