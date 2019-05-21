<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>发布课程</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <%@include file="navbar/navbar.jsp"%>
    </nav>
    <div class="row">
        <div class="col-md-2 sidebar">
            <%@include file="sidebar/teacherInfoSideBar.jsp"%>
        </div>
        <div class="col-md-10 main">
            <div class="col-md-12">
                <div class="form-container col-md-8 col-md-offset-2">
                    <form class="form-horizontal" action="/AcademicSharedSystem/course/add" method="post" enctype="multipart/form-data">
                        <div class="col-md-12 form-group">
                            <label for="inputCourseName" class="col-sm-2 control-label">名称(*必填)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputCourseName" name="courseName" placeholder="请填写发布课程的名称" required>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="inputCourseId" class="col-sm-2 control-label">课程号(*必填)</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputCourseId" name="courseId" placeholder="请填写发布课程的课程号" required>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="courseMajor" class="col-sm-2 control-label">开设专业(*必选)</label>
                            <div class="col-sm-10 form-group">
                                <select class="form-control" name="majorId" id="courseMajor" type="" required>
                                    <c:forEach items="${allMajor}" var="major" begin="0" end="${allMajor.size()}">
                                        <option value="${major.majorId}">${major.majorName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="coursePic" class="control-label col-sm-2">选择一张课程图片</label>
                            <div class="col-sm-10">
                                <input type="file" id="coursePic" name="coursePic">
                                <p class="help-block">*选填(未选择照片则默认使用系统图片)</p>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="margin-top: 50px">
                            <label for="courseOutline" class="control-label col-sm-2">请上传课程的大纲</label>
                            <div class="col-sm-10">
                                <input type="file" id="courseOutline" name="courseOutlineDownload" required>
                                <p class="help-block">*必填</p>
                            </div>
                        </div>
                        <div class="col-md-12 form-group" style="text-align: center;margin-top: 50px">
                            <input type="submit" class="btn btn-default" value="提交课程">
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
