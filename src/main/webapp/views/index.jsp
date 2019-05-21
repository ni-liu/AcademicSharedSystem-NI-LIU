<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/6
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>高校资源管理共享系统-主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">高校资源管理共享系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="#">高校课程信息</a></li>
                <li><a href="#">优质博客内容</a></li>
                <li><a href="#">个人主页</a></li>
            </ul>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> 注册</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
        </ul>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar">
            <jsp:include page="sidebar/indexSidebar.jsp"/>
        </div>
        <div class="col-md-10 main">Main</div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
