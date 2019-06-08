<%--
  Created by IntelliJ IDEA.
  User: 曦
  Date: 2019-5-23
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布博客</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="../css/index-layout.css" type="text/css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
        <meta http-equiv="CONTENT-TYPE" content="text/html;charest=utf-8">
        <script type="text/javascript" charset="utf-8" src="../ueditor2/utf8-jsp/ueditor.config.js"></script>
        <script type="text/javascript" charset="utf-8" src="../ueditor2/utf8-jsp/ueditor.all.js"></script>
        <link href="../ueditor2/utf8-jsp/themes/default/css/ueditor.css" rel="stylesheet">
        <script type="text/javascript" charset="utf-8" src="../ueditor2/utf8-jsp/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<style>
    div{
        white-space:nowrap;
    }
</style>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <%@include file="navbar/navbar.jsp"%>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar">
            <%@include file="sidebar/UserBlogInfoSideBar.jsp"%>
        </div>
        <div class="col-md-10 main">
            <div class="col-md-12">
                <div class="form-container col-md-8 col-md-offset-2">
                    <form class="form-horizontal" action="/AcademicSharedSystem/releaseBlog/add" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="userId" value="${sessionScope.get('loginUser').pkId}"/>
                        <input type="hidden" name="courseId" value="${courseId}">

                        <div class="col-md-12 form-group">
                            <label for="inputBlogTitle" class="col-sm-2  control-label" style="padding-right: 10px;padding-left: 10px;" >博客主题(*必填)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control col-md-offset-1" id="inputBlogTitle" name="blogTitle"
                                       placeholder="请填写发布博客的主题" required>
                            </div>
                        </div>

                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="inputBlogContent" class="col-sm-2 control-label" style="padding-right: 10px;padding-left: 10px;">博客正文(*必填)</label>
                            <div class="col-sm-10" >
                                <%--                    <textarea class="form-control" id="inputBlogContent" name="blogContent"  rows="15"--%>
                                <%--                              placeholder="请填写发布博客的内容"  required></textarea>--%>
                                <textarea class="form-control col-md-offset-1" id="inputBlogContent" name="blogContent" type="text/plain" rows="15">请填写发布的内容</textarea>
<%--                                    <script id="inputBlogContent" name="blogContent" type="text/plain" style="width:770px;height:360px;"  ></script>--%>
<%--                                    <script type="text/javascript">--%>
<%--                                        UE.getEditor('inputBlogContent');--%>
<%--                                        UE.getEditor('inputBlogContent').getContent();--%>
<%--                                    </script>--%>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="blogAuthority" class="col-sm-2 control-label" style="padding-right: 10px;padding-left: 10px;">博客权限(*必选)</label>
                            <div class="col-sm-10 ">
                                <select class="form-control col-md-offset-4" name="authority" id="blogAuthority"  style="margin-left: 60px;padding-left: px;" required>
                                    <option value="2">公有</option>
                                    <option value="1">私人</option>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12  form-group" style=" margin-top: 40px">
                            <label for="blogFile" class="control-label col-sm-2 " style="padding-right: 5px;padding-left: 0px;margin-left: 0px;">请上传博客的附件</label>
                            <div class="col-sm-10 ">
                                <input type="file" class="col-md-offset-8" style="margin-left: 60px;" id="blogFile" name="blogAttachmentDownload" required>
                                <p class="help-block" class=" form-control col-md-offset-2" style="margin-left: 60px;">*必填</p>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="text-align: center;margin-top: 5px">
                            <input type="submit" class="btn btn-default" value="提交博客">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

</body>
</html>
