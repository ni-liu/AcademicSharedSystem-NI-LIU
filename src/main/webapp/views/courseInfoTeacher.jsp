<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>课程信息 - 教师</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        ul,li{
            list-style: none;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <jsp:include page="navbar/navbar.jsp"/>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar" style="font-size: 22px">
            <jsp:include page="sidebar/teacherInfoSideBar.jsp"/>
        </div>
        <div class="col-md-10 main">
            <jsp:include page="main/courseInfoTeacherMain.jsp"/>
        </div>
    </div>
</div>
<script src="../js/star.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
