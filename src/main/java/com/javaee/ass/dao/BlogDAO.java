package com.javaee.ass.dao;

import com.javaee.ass.entity.blog.BlogCommentDO;
import com.javaee.ass.entity.blog.BlogDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BlogDAO {


    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<BlogDO> listBlogByUserNickname(@Param("nickName") String nickName,
                                        @Param("pageNow") int pageNow,
                                        @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<BlogDO> ListBlogByBlogTitle(@Param("blogTitle") String blogTitle,
                                     @Param("pageNow") int pageNow,
                                     @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<BlogDO> ListOwnBlog(@Param("userId") String userId,
                             @Param("pageNow") int pageNow,
                             @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    List<BlogDO> ListAllBlog(@Param("pageNow") int pageNow,
                             @Param("pageSize") int pageSize);

    List<BlogDO> SelectBlogByInfo(@Param("blogInfo") String blogInfo,
                                         @Param("pageNow") int pageNow,
                                         @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    BlogDO SelectBlogById(@Param("blogId") String blogID);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean deleteByPkId(@Param("pkId") String pkId);

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    List<BlogCommentDO> SelectBlogCommentByBlogId(@Param("blogId") String blogId,
                                                  @Param("pageNow") int pageNow,
                                                  @Param("pageSize") int pageSize);

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    boolean insertBlogComment(@Param("userId") String userID, @Param("blogId") String blogId,
                              @Param("comment") String comment, @Param("time") String time);

    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.SERIALIZABLE)
    boolean insertBlog(@Param("userId") String userID, @Param("blogTitle") String blogTitle,
                       @Param("blogContent") String blogContent,@Param("blogAttachment") String fileDownload,
                       @Param("launchTime") String launchTimem,@Param("authority") int authority);

    boolean insertBlogReport(@Param("userId") String userID, @Param("blogId") String blogID,
                             @Param("reason") int reason, @Param("time") String time);

}
