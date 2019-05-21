package com.javaee.ass.entity.blog;

import com.javaee.ass.entity.enums.BlogAuthorityEnum;
import org.apache.ibatis.type.Alias;
import org.springframework.core.annotation.AliasFor;

import java.sql.Date;
import java.util.Objects;

@Alias("blogDO")
public class BlogDO {
    private int pkId;
    private String blogTitle;
    private String blogContent;
    private String fileDownload;
    private Date launchTime;
    private BlogAuthorityEnum authority;

    public BlogDO() {
    }


    public int getPkId() {
        return this.pkId;
    }

    public String getBlogTitle() {
        return this.blogTitle;
    }

    public String getBlogContent() {
        return this.blogContent;
    }

    public String getFileDownload() {
        return this.fileDownload;
    }

    public Date getLaunchTime() {
        return this.launchTime;
    }

    public BlogAuthorityEnum getAuthority() {
        return this.authority;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public void setFileDownload(String fileDownload) {
        this.fileDownload = fileDownload;
    }

    public void setLaunchTime(Date launchTime) {
        this.launchTime = launchTime;
    }

    public void setAuthority(BlogAuthorityEnum authority) {
        this.authority = authority;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogDO)) return false;
        final BlogDO other = (BlogDO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.pkId != other.pkId) return false;
        final Object this$blogTitle = this.blogTitle;
        final Object other$blogTitle = other.blogTitle;
        if (!Objects.equals(this$blogTitle, other$blogTitle)) return false;
        final Object this$blogContent = this.blogContent;
        final Object other$blogContent = other.blogContent;
        if (!Objects.equals(this$blogContent, other$blogContent))
            return false;
        final Object this$fileDownload = this.fileDownload;
        final Object other$fileDownload = other.fileDownload;
        if (!Objects.equals(this$fileDownload, other$fileDownload))
            return false;
        final Object this$launchTime = this.launchTime;
        final Object other$launchTime = other.launchTime;
        if (!Objects.equals(this$launchTime, other$launchTime))
            return false;
        final Object this$authority = this.authority;
        final Object other$authority = other.authority;
        return Objects.equals(this$authority, other$authority);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogDO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.pkId;
        final Object $blogTitle = this.blogTitle;
        result = result * PRIME + ($blogTitle == null ? 43 : $blogTitle.hashCode());
        final Object $blogContent = this.blogContent;
        result = result * PRIME + ($blogContent == null ? 43 : $blogContent.hashCode());
        final Object $fileDownload = this.fileDownload;
        result = result * PRIME + ($fileDownload == null ? 43 : $fileDownload.hashCode());
        final Object $launchTime = this.launchTime;
        result = result * PRIME + ($launchTime == null ? 43 : $launchTime.hashCode());
        final Object $authority = this.authority;
        result = result * PRIME + ($authority == null ? 43 : $authority.hashCode());
        return result;
    }

    public String toString() {
        return "BlogDO(pkId=" + this.pkId + ", blogTitle=" + this.blogTitle + ", blogContent=" + this.blogContent + ", fileDownload=" + this.fileDownload + ", launchTime=" + this.launchTime + ", authority=" + this.authority + ")";
    }
}
