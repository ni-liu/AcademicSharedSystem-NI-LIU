package com.javaee.ass.entity.blog;

import com.javaee.ass.entity.enums.BlogAttitudeEnum;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("blogAttitudeDO")
public class BlogAttitudeDO extends BlogActionDO{
    private int pkId;
    private BlogAttitudeEnum attitude;

    public BlogAttitudeDO() {
    }

    public BlogAttitudeEnum getAttitude() {
        return this.attitude;
    }

    public void setAttitude(BlogAttitudeEnum attitude) {
        this.attitude = attitude;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogAttitudeDO)) return false;
        final BlogAttitudeDO other = (BlogAttitudeDO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$attitude = this.attitude;
        final Object other$attitude = other.attitude;
        return Objects.equals(this$attitude, other$attitude);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogAttitudeDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $attitude = this.attitude;
        result = result * PRIME + ($attitude == null ? 43 : $attitude.hashCode());
        return result;
    }

    public String toString() {
        return "BlogAttitudeDO(attitude=" + this.attitude + ")";
    }

    public int getPkId() {
        return this.pkId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }
}
