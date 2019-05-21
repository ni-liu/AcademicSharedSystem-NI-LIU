<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>主页</title>
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
            <jsp:include page="sidebar/indexSideBar.jsp"/>
        </div>
        <div class="col-md-10 main">
            <jsp:include page="main/coursesListMain.jsp"/>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
