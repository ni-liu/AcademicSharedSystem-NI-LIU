<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
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
        <div class="col-md-2 sidebar">
            <jsp:include page="sidebar/blogPageSideBar.jsp"/>
        </div>
        <div class="col-md-10 main"  >
            <div id="info-match-search">
                <div class="col-md-6 col-md-offset-1">
                    <form class="bs-example bs-example-form" action="/AcademicSharedSystem/queryBlog/query/1" method="post" role="form">
                        <div class="input-group" >
                            <input type="text" name="blogInfo" class="form-control" placeholder="博客的关键字"/>
<%--                            <input hidden name="pageNow" value="1">--%>
                            <span class="input-group-btn" >
                                <input type="submit" class="btn btn-default" value="搜索"/>
                            </span>
                        </div>
                    </form>
                </div>
                <div class="col-md-3">
                    <div class=" span-label" >
                        搜索标签：
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                    </div>
                </div>
            </div>
            <div class="col-md-10 col-md-offset-1 table-frame">
                <table class="table table-striped table-bordered" style="font-size: 22px">
                    <thead>
                    <tr>
                        <th style="width: 500px;text-align: center">博客名称</th>
                        <th style="width: 230px;text-align: center">发布者</th>
                        <th style="text-align: center">发布日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="c" items="${listBlog}">
                        <tr>
                            <td><a href="../../showBlogContent/show/${c.pkId}">${c.blogTitle}</a></td>
                            <td>${c.nickName}</td>
                            <td>${c.launchTime}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
            <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                <ul class="pagination">
                    <li><a href="/AcademicSharedSystem/listBlog/list/1">&laquo;</a></li>
                    <li><a href="/AcademicSharedSystem/listBlog/list/1">1</a></li>
<%--                    <li><a href="/AcademicSharedSystem/listBlog/list/2">2</a></li>--%>
<%--                    <li><a href="/AcademicSharedSystem/listBlog/list/3">3</a></li>--%>
<%--                    <li><a href="/AcademicSharedSystem/listBlog/list/4">4</a></li>--%>
<%--                    <li><a href="/AcademicSharedSystem/listBlog/list/5">5</a></li>--%>
                    <li><a href="/AcademicSharedSystem/listBlog/list/1">&raquo;</a></li>
                </ul>

            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
