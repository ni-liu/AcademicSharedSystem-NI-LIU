package com.javaee.ass.entity.params;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("studentBasicParam")
public class StudentBasicParam {
    private String pkId;
    private String name;
    private String nickName;
    private String majorId;
    private String majorName;

    public StudentBasicParam() {
    }


    public String getPkId() {
        return this.pkId;
    }

    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getMajorId() {
        return this.majorId;
    }

    public String getMajorName() {
        return this.majorName;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StudentBasicParam)) return false;
        final StudentBasicParam other = (StudentBasicParam) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$pkId = this.pkId;
        final Object other$pkId = other.pkId;
        if (!Objects.equals(this$pkId, other$pkId)) return false;
        final Object this$name = this.name;
        final Object other$name = other.name;
        if (!Objects.equals(this$name, other$name)) return false;
        final Object this$nickName = this.nickName;
        final Object other$nickName = other.nickName;
        if (!Objects.equals(this$nickName, other$nickName)) return false;
        final Object this$majorId = this.majorId;
        final Object other$majorId = other.majorId;
        if (!Objects.equals(this$majorId, other$majorId)) return false;
        final Object this$majorName = this.majorName;
        final Object other$majorName = other.majorName;
        return Objects.equals(this$majorName, other$majorName);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StudentBasicParam;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $pkId = this.pkId;
        result = result * PRIME + ($pkId == null ? 43 : $pkId.hashCode());
        final Object $name = this.name;
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $nickName = this.nickName;
        result = result * PRIME + ($nickName == null ? 43 : $nickName.hashCode());
        final Object $majorId = this.majorId;
        result = result * PRIME + ($majorId == null ? 43 : $majorId.hashCode());
        final Object $majorName = this.majorName;
        result = result * PRIME + ($majorName == null ? 43 : $majorName.hashCode());
        return result;
    }

    public String toString() {
        return "StudentBasicParam(pkId=" + this.pkId + ", name=" + this.name + ", nickName=" + this.nickName + ", majorId=" + this.majorId + ", majorName=" + this.majorName + ")";
    }
}
