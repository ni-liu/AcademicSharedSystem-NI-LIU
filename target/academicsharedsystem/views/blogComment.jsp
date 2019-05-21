<%--
  Created by IntelliJ IDEA.
  User: 曦
  Date: 2019-6-4
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>博客评论</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <jsp:include page="navbar/navbar.jsp"/>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar">
            <jsp:include page="sidebar/blogPageSideBar.jsp"/>
        </div>
        <div class="col-md-10 main">
            <div id="info-match-search">
                <div class="col-md-6 col-md-offset-1">
                    <form class="bs-example bs-example-form" action="/AcademicSharedSystem/releaseBlogComment/release" method="get" role="form" >
                        <div class="input-group">
                            <input type="text" class="form-control" name="comment" placeholder="博客评论"/>
                            <input hidden name="userId" value="1609010001">
                            <input hidden name="blogId" value="${blogId}">
                            <input hidden name="blogTitle" value="${blogTitle}">
                            <span class="input-group-btn">
                                <input type="submit" class="btn btn-default" value="发布评论"/>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-md-10 col-md-offset-1 table-frame">
                <label class="text-center" style="font-size: 22px">${blogTitle}</label>
                <table class="table table-striped table-bordered">
                    <thead>
                    <tr>
                        <th style="width: 500px;text-align: center">博客评论</th>
                        <th style="width: 180px;text-align: center">博客作者</th>
                        <th style="text-align: center">评论日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="c" items="${listComment}">
                        <tr>
                            <td>${c.comments}</td>
                            <td>${c.nickName}</td>
                            <td>${c.time}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                <ul class="pagination">
                    <li><a href="/AcademicSharedSystem/blogComment/show/1?blogTitle=${BlogInfo.blogTitle}&blogId=${BlogInfo.pkId}&userId=${BlogInfo.userId}">&laquo;</a></li>
                    <li><a href="/AcademicSharedSystem/blogComment/show/1?blogTitle=${BlogInfo.blogTitle}&blogId=${BlogInfo.pkId}&userId=${BlogInfo.userId}">1</a></li>
                    <%--                    <li><a href="/AcademicSharedSystem/listBlog/list/2">2</a></li>--%>
                    <%--                    <li><a href="/AcademicSharedSystem/listBlog/list/3">3</a></li>--%>
                    <%--                    <li><a href="/AcademicSharedSystem/listBlog/list/4">4</a></li>--%>
                    <%--                    <li><a href="/AcademicSharedSystem/listBlog/list/5">5</a></li>--%>
                    <li><a href="/AcademicSharedSystem/blogComment/show/1?blogTitle=${BlogInfo.blogTitle}&blogId=${BlogInfo.pkId}&userId=${BlogInfo.userId}">&raquo;</a></li>
                </ul>

            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
