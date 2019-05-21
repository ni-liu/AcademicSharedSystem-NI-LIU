package com.javaee.ass.entity.blog;

import com.javaee.ass.entity.enums.BlogAuthorityEnum;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.Objects;

@Alias("blogDO")
public class BlogDO {
    private int pkId;
    private String blogTitle;
    private String userId;
    private String blogContent;
    private String blogAttachment;
    private String launchTime;
    private BlogAuthorityEnum authority;
    private String nickName;

    public BlogDO() {
    }

    public BlogDO(int pkId, String blogTitle, String userId, String blogContent, String blogAttachment, String launchTime, BlogAuthorityEnum authority, String nickName) {
        this.pkId = pkId;
        this.blogTitle = blogTitle;
        this.userId = userId;
        this.blogContent = blogContent;
        this.blogAttachment = blogAttachment;
        this.launchTime = launchTime;
        this.authority = authority;
        this.nickName = nickName;
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

    public String getBlogAttachment() {
        return this.blogAttachment;
    }

    public String getLaunchTime() {
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

    public void setBlogAttachment(String blogAttachment) {
        this.blogAttachment = blogAttachment;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public void setAuthority(BlogAuthorityEnum authority) {
        this.authority = authority;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }


    protected boolean canEqual(final Object other) {
        return other instanceof BlogDO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogDO blogDO = (BlogDO) o;
        return pkId == blogDO.pkId &&
                Objects.equals(blogTitle, blogDO.blogTitle) &&
                Objects.equals(userId, blogDO.userId) &&
                Objects.equals(blogContent, blogDO.blogContent) &&
                Objects.equals(blogAttachment, blogDO.blogAttachment) &&
                Objects.equals(launchTime, blogDO.launchTime) &&
                authority == blogDO.authority &&
                Objects.equals(nickName, blogDO.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, blogTitle, userId, blogContent, blogAttachment, launchTime, authority, nickName);
    }

    @Override
    public String toString() {
        return "BlogDO{" +
                "pkId=" + pkId +
                ", blogTitle='" + blogTitle + '\'' +
                ", userId='" + userId + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", blogAttachment='" + blogAttachment + '\'' +
                ", launchTime=" + launchTime +
                ", authority=" + authority +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
