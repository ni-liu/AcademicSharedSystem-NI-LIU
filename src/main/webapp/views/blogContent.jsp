<%--
  Created by IntelliJ IDEA.
  User: 曦
  Date: 2019-5-31
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>博客内容</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../js/pdfobject.min.js"></script>
</head>
<body>
<style>
    div{
        white-space:nowrap;
        font-size: 22px;
    }
</style>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <jsp:include page="navbar/navbar.jsp"/>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar" >
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125" style="font-size: 22px">
                <li><a href="/AcademicSharedSystem/blogComment/show/1?blogTitle=${BlogInfo.blogTitle}&blogId=${BlogInfo.pkId}&userId=${sessionScope.get('loginUser').pkId}">评论</a></li>
                <li><a href="/AcademicSharedSystem/showReportBlog/show?blogTitle=${BlogInfo.blogTitle}&blogId=${BlogInfo.pkId}&userId=${sessionScope.get('loginUser').pkId}&nickName=${BlogInfo.nickName}">举报</a></li>
            </ul>
        </div>
        <div class="col-md-10 main" style="font-size: 22px">
            <div class="col-md-4 col-md-offset-3" id="blog-title">
                <h2><label>${BlogInfo.blogTitle}</label></h2>
            </div>
            <div class="col-md-4 col-md-offset-3" id="blog-author-info" style="text-align: right">

                <h4>作者：<label>${BlogInfo.nickName}</label></h4>
            </div>

            <div class="col-md-10 col-md-offset-1" >
                <embed src="${BlogInfo.blogContent}" height="745" width="1000">
            </div>

            <div id="blog-attachment" style="margin-top: 10px">
                <h4>附件：<a href="${BlogInfo.blogAttachment}">附件</a></h4>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
