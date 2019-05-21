package com.javaee.ass.entity.blog;

import com.javaee.ass.entity.enums.BlogLabelEnum;
import org.apache.ibatis.type.Alias;

import java.util.Objects;

@Alias("blogLabelDO")
public class BlogLabelDO {
    private int pkId;
    private int blogId;
    private BlogLabelEnum blogLabel;

    public BlogLabelDO() {
    }

    public int getPkId() {
        return this.pkId;
    }

    public int getBlogId() {
        return this.blogId;
    }

    public BlogLabelEnum getBlogLabel() {
        return this.blogLabel;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setBlogLabel(BlogLabelEnum blogLabel) {
        this.blogLabel = blogLabel;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogLabelDO)) return false;
        final BlogLabelDO other = (BlogLabelDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        if (this.blogId != other.blogId) return false;
        final Object this$blogLabel = this.blogLabel;
        final Object other$blogLabel = other.blogLabel;
        return Objects.equals(this$blogLabel, other$blogLabel);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogLabelDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        result = result * PRIME + this.blogId;
        final Object $blogLabel = this.blogLabel;
        result = result * PRIME + ($blogLabel == null ? 43 : $blogLabel.hashCode());
        return result;
    }

    public String toString() {
        return "BlogLabelDO(pkId=" + this.pkId + ", blogId=" + this.blogId + ", blogLabel=" + this.blogLabel + ")";
    }
}
