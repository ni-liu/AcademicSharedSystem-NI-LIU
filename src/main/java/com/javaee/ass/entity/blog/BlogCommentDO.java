package com.javaee.ass.entity.blog;

import org.apache.ibatis.type.Alias;

import java.sql.Date;
import java.util.Objects;

@Alias("blogCommentDO")
public class BlogCommentDO {
    private int pkId;
    private String userId;
    private String blogId;
    private String comments;
    private String nickName;
    private String time;


    public BlogCommentDO() {
    }

    public BlogCommentDO(int pkId, String userId, String blogId, String comments, String nickName, String time) {
        this.pkId = pkId;
        this.userId = userId;
        this.blogId = blogId;
        this.comments = comments;
        this.nickName = nickName;
        this.time = time;
    }

    public int getPkId() {
        return this.pkId;
    }

    public String getComments() {
        return this.comments;
    }

    public String getTime() {
        return this.time;
    }

    public void setPkId(int pkId) {
        this.pkId = pkId;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlogCommentDO that = (BlogCommentDO) o;
        return pkId == that.pkId &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(blogId, that.blogId) &&
                Objects.equals(comments, that.comments) &&
                Objects.equals(time, that.time);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogCommentDO;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pkId, userId, blogId, comments, time);
    }

    @Override
    public String toString() {
        return "BlogCommentDO{" +
                "pkId=" + pkId +
                ", userId='" + userId + '\'' +
                ", blogId='" + blogId + '\'' +
                ", comments='" + comments + '\'' +
                ", nickName='" + nickName + '\'' +
                ", time=" + time +
                '}';
    }
}
