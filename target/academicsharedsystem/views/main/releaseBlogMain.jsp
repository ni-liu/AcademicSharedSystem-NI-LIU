<%--
  Created by IntelliJ IDEA.
  User: 曦
  Date: 2019-5-23
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="col-md-12">
    <div class="form-container col-md-8 col-md-offset-2">
        <form class="form-horizontal" action="/AcademicSharedSystem/releaseBlog/add" method="post" enctype="multipart/form-data">
						<input type="hidden" name="userId" value="1609010001"/>
            <div class="col-md-12 form-group">
                <label for="inputBlogTitle" class="col-sm-2 control-label" style="padding-right: 10px;padding-left: 10px;" >博客主题(*必填)</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputBlogTitle" name="blogTitle"
										 placeholder="请填写发布博客的主题" required>
                </div>
            </div>
            <div class="col-md-12 form-group" style="margin-top: 50px">
                <label for="inputBlogContent" class="col-sm-2 control-label" style="padding-right: 10px;padding-left: 10px;">博客正文(*必填)</label>
                <div class="col-sm-10">
                    <textarea class="form-control" id="inputBlogContent" name="blogContent"  rows="15"
                              placeholder="请填写发布博客的内容"  required></textarea>
                </div>
            </div>
            <div class="col-md-12 form-group" style="margin-top: 50px">
                <label for="blogAuthority" class="col-sm-2 control-label" style="padding-right: 10px;padding-left: 10px;">博客权限(*必选)</label>
                <div class="col-sm-10 form-group">
                    <select class="form-control" name="authority" id="blogAuthority" type="" style="margin-left: 15px;" required>
                        <option value="2">公有</option>
                        <option value="1">私人</option>
                    </select>
                </div>
            </div>
            <div class="col-md-12 form-group" style=" margin-top: 50px">
                <label for="blogFile" class="control-label col-sm-2" style="padding-right: 5px;padding-left: 0px;margin-left: 0px;">请上传博客的附件</label>
                <div class="col-sm-10">
                    <input type="file" style="margin-left: 5px;" id="blogFile" name="blogAttachmentDownload" required>
                    <p class="help-block" style="margin-left: 10px;">*必填</p>
                </div>
            </div>
            <div class="col-md-12 form-group" style="text-align: center;margin-top: 25px">
                <input type="submit" class="btn btn-default" value="提交博客">
            </div>
        </form>
    </div>
</div>
