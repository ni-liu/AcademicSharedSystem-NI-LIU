package com.javaee.ass.entity.role;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("teacherDO")
public class TeacherDO extends UserDO{
    private String name;

    public TeacherDO() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TeacherDO)) return false;
        final TeacherDO other = (TeacherDO) o;
        if (other.canEqual((Object) this)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        return Objects.equals(this$name, other$name);
    }

    protected boolean canEqual(final Object other) {
        return !(other instanceof TeacherDO);
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "TeacherDO(name=" + this.name + ")";
    }
}
