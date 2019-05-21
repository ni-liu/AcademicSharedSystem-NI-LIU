package com.javaee.ass.service;


import com.javaee.ass.dao.BlogDAO;
import com.javaee.ass.entity.blog.BlogCommentDO;
import com.javaee.ass.entity.blog.BlogDO;
import com.javaee.ass.entity.blog.BlogReportDO;
import com.javaee.ass.entity.enums.FileTypeEnum;
import com.javaee.ass.utils.FinalVariablesUtils;
import com.javaee.ass.utils.OSSOperationUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("blogService")
public class BlogService {
    private final BlogDAO blogDAO;

    @Autowired
    public BlogService(BlogDAO blogDAO) {
        this.blogDAO = blogDAO;
    }

    /**
     *  通过博客作者查询博客
     * @param nickName
     * @param pageNow
     * @return
     */
    public List<BlogDO> listBlogByUserNickname(@Param("nickName") String nickName,
                                               @Param("pageNow") int pageNow){
        List<BlogDO> list= null;
        try{
            list = blogDAO.listBlogByUserNickname(nickName, pageNow, FinalVariablesUtils.COURSE_PAGE_SIZE);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     *  通过博客主题查询博客
     * @param blogTitle
     * @param pageNow
     * @return
     */
    public List<BlogDO> ListBlogByBlogTitle(@Param("blogTitle") String blogTitle,
                                            @Param("pageNow") int pageNow){
        List<BlogDO> list= null;
        try{
            list = blogDAO.ListBlogByBlogTitle(blogTitle, pageNow, FinalVariablesUtils.COURSE_PAGE_SIZE);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 通过用户id查看博客
     * @param userId
     * @param pageNow
     * @return
     */
    public List<BlogDO> ListOwnBlog(@Param("userId") String userId,
                                    @Param("pageNow") int pageNow){
        List<BlogDO> list= null;
        try{
            list = blogDAO.ListOwnBlog(userId, pageNow, FinalVariablesUtils.COURSE_PAGE_SIZE);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 查看所有的博客
     * @param pageNow
     * @return
     */
    public List<BlogDO> ListAllBlog(@Param("pageNow") int pageNow){
        List<BlogDO> list= null;
        try{
            list = blogDAO.ListAllBlog(pageNow, FinalVariablesUtils.COURSE_PAGE_SIZE);
//            System.out.println(list.get(0).getLaunchTime());
//            System.out.println(list.get(0).getUserId());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 通过博客id查询博客
     * @param blogID
     * @return
     */
    public BlogDO SelectBlogById(@Param("blogId") String blogID){
        BlogDO blogDO = new BlogDO();
        try {
            blogDO = blogDAO.SelectBlogById(blogID);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return blogDO;
    }

    /**
     *  通过博客号查询当前博客的所有评论
     * @param blogId
     * @param pageNow
     * @param pageSize
     * @return
     */
    public List<BlogCommentDO> SelectBlogCommentByBlogId(@Param("blogId") String blogId,
                                                         @Param("pageNow") int pageNow,
                                                         @Param("pageSize") int pageSize){
        List<BlogCommentDO> list= null;
        try{
            list = blogDAO.SelectBlogCommentByBlogId(blogId, pageNow, pageSize);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     *  通过博客关键信息进行搜索
     * @param blogInfo
     * @param pageNow
     * @param pageSize
     * @return
     */
    public List<BlogDO> SelectBlogByInfo(@Param("blogInfo") String blogInfo,
                                                @Param("pageNow") int pageNow,
                                                @Param("pageSize") int pageSize){
        List<BlogDO> list= null;
        try{
            list = blogDAO.SelectBlogByInfo(blogInfo,pageNow, pageSize);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return list;
    }

    /**
     * 插入博客评论
     * @param userID
     * @param blogId
     * @param comment
     * @param time
     * @return
     */
    public boolean insertBlogComment(@Param("userId") String userID, @Param("blogId") String blogId,
                                     @Param("comments") String comment, @Param("time") String time){
        boolean hasInserted = false;
        try{
            hasInserted = blogDAO.insertBlogComment(userID, blogId, comment, time);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return hasInserted;
    }

    public boolean deleteByPkId(@Param("pkId") String pkId){
        return blogDAO.deleteByPkId(pkId);
    }


    /**
     * 发布博客
     * @param blogDO 博客
     * @param nowTime 发布时间
     * @return
     */
    public boolean insertBlog(BlogDO blogDO, String nowTime){
        boolean hasInserted = false;
//        System.out.println(blogDO.getAuthority());
        try{
            hasInserted = blogDAO.insertBlog(
              blogDO.getUserId(),
              blogDO.getBlogTitle(),
              blogDO.getBlogContent(),
              blogDO.getBlogAttachment(),
                    nowTime,
                    blogDO.getAuthority().getAuthority()
            );
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return hasInserted;
    }

    public boolean insertBlogReport(BlogReportDO blogReportDO, @Param("time") String time){
        boolean hasInserted = false;
        try{
            hasInserted = blogDAO.insertBlogReport(
                    blogReportDO.getUserId(),
                    blogReportDO.getBlogId(),
                    blogReportDO.getReason().getReasonId(),
                    time
            );
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return hasInserted;
    }
}
