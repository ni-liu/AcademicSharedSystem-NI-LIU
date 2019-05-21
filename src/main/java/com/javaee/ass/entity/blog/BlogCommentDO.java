package com.javaee.ass.entity.blog;

import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.Objects;

@Alias("blogCommentDO")
public class BlogCommentDO {
    private int pkId;
    private String comments;
    private Date time;

    public BlogCommentDO() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public String getComments() {
        return this.comments;
    }

    public Date getTime() {
        return this.time;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogCommentDO)) return false;
        final BlogCommentDO other = (BlogCommentDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$comments = this.comments;
        final Object other$comments = other.comments;
        if (!Objects.equals(this$comments, other$comments)) return false;
        final Object this$time = this.time;
        final Object other$time = other.time;
        return Objects.equals(this$time, other$time);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogCommentDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $comments = this.comments;
        result = result * PRIME + ($comments == null ? 43 : $comments.hashCode());
        final Object $time = this.time;
        result = result * PRIME + ($time == null ? 43 : $time.hashCode());
        return result;
    }

    public String toString() {
        return "BlogCommentDO(pkId=" + this.pkId + ", comments=" + this.comments + ", time=" + this.time + ")";
    }
}
