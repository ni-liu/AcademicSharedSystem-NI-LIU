package com.javaee.ass.entity.params;

import com.javaee.ass.entity.enums.BlogAuthorityEnum;

public class BlogBasicParam {
    String blogId;
    String blogTitle;
    String userId;
    String blogContent;
    String fileDownload;
    String launchTime;
    BlogAuthorityEnum authority;
    String nickName;

    public BlogBasicParam(String blogId, String blogTitle, String userId, String blogContent, String fileDownload, String launchTime, BlogAuthorityEnum authority, String nickName) {
        this.blogId = blogId;
        this.blogTitle = blogTitle;
        this.userId = userId;
        this.blogContent = blogContent;
        this.fileDownload = fileDownload;
        this.launchTime = launchTime;
        this.authority = authority;
        this.nickName = nickName;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getFileDownload() {
        return fileDownload;
    }

    public void setFileDownload(String fileDownload) {
        this.fileDownload = fileDownload;
    }

    public String getLaunchTime() {
        return launchTime;
    }

    public void setLaunchTime(String launchTime) {
        this.launchTime = launchTime;
    }

    public BlogAuthorityEnum getAuthority() {
        return authority;
    }

    public void setAuthority(BlogAuthorityEnum authority) {
        this.authority = authority;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "BlogBasicParam{" +
                "blogId='" + blogId + '\'' +
                ", blogTitle='" + blogTitle + '\'' +
                ", userId='" + userId + '\'' +
                ", blogContent='" + blogContent + '\'' +
                ", fileDownload='" + fileDownload + '\'' +
                ", launchTime='" + launchTime + '\'' +
                ", authority=" + authority +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
