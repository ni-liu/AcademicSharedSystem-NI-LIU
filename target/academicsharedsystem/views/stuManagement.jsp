<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/6/3
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>学生信息管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <nav class="navbar" role="navigation" style="font-size: 22px">
        <jsp:include page="navbar/navbar.jsp"/>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar" style="font-size: 22px">
            <jsp:include page="sidebar/adminInfoSideBar.jsp"/>
        </div>
        <div class="col-md-10 main" style="font-size: 22px">
            <!-- 学生信息表格 -->
            <div class="row col-md-12" id="stu-info-table" style="margin-top: 50px;font-size: 22px">
                <table class="table table-hover table-bordered table-striped" style="font-size: 22px">
                    <thead>
                    <tr>
                        <th style="text-align: center">学生学号</th>
                        <th style="text-align: center">学生名字</th>
                        <th style="text-align: center">学生专业</th>
                        <th style="text-align: center">学生昵称</th>
                        <th style="text-align: center">学生密码重置</th>
                        <th style="text-align: center">学生删除</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${stuList}" var="stu" begin="0" end="${stuList.size()}">
                            <tr>
                                <td class="text-center" style="width: 10%">${stu.pkId}</td>
                                <td class="text-center" style="width: 25%">${stu.name}</td>
                                <td class="text-center" style="width: 25%"><a href="/AcademicSharedSystem/admin/manage/${stu.majorId}/1">${stu.majorName}</a></td>
                                <td class="text-center" style="width: 25%">${stu.nickName}</td>
                                <td class="text-center"><a href="">重置密码</a> </td>
                                <td class="text-center"><a href="">删除</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
                <div class="col-md-6 col-md-offset-3" style="text-align: center">
                    <ul class="pagination">
                        <li><a href="/AcademicSharedSystem/admin/manage/all/1">&laquo;</a></li>
                        <li><a href="/AcademicSharedSystem/admin/manage/all/1">1</a></li>
                        <li><a href="/AcademicSharedSystem/admin/manage/all/2">2</a></li>
                        <li><a href="/AcademicSharedSystem/admin/manage/all/3">3</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>

                </div>
            </div>
            <!-- 学生信息表格 -->
            <!-- 批量导入 -->
            <div class="row col-md-12 text-center" id="patch-stu" style="margin-top: 50px";font-size: 22px">
                <form class="form-inline" action="/AcademicSharedSystem/admin/patch" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="filePatch">学生批量批量导入</label>
                        <input type="file" class="form-control" id="filePatch" name="filePatch">
                    </div>
                    <input type="submit" class="btn btn-info" value="导入"/>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
