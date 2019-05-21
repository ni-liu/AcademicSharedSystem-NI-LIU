package com.javaee.ass.entity.blog;

import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("blogActionDO")
public class BlogActionDO {
    private int pkId;
    protected String userId;
    protected int blogId;

    public BlogActionDO() {
    }


    public int getPkId() {
        return this.pkId;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getBlogId() {
        return this.blogId;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogActionDO)) return false;
        final BlogActionDO other = (BlogActionDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$userId = this.userId;
        final Object other$userId = other.userId;
        if (!Objects.equals(this$userId, other$userId)) return false;
        return this.blogId == other.blogId;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogActionDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $userId = this.userId;
        result = result * PRIME + ($userId == null ? 43 : $userId.hashCode());
        result = result * PRIME + this.blogId;
        return result;
    }

    public String toString() {
        return "BlogActionDO(pkId=" + this.pkId + ", userId=" + this.userId + ", blogId=" + this.blogId + ")";
    }
}
