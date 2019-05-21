
<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
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
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
                <li><a href="/AcademicSharedSystem/course/all/1">全部课程</a></li>
                <c:if test="${sessionScope.get('loginUser').role.roleId eq 2}">
                    <li><a href="/AcademicSharedSystem/stu/selected/1">已选课程</a></li>
                </c:if>
                <li><a href="/AcademicSharedSystem/course/excl/1">精品课程</a></li>

            </ul>
        </div>
        <div class="col-md-10 main">
            <div id="info-match-search">
                <div class="col-md-6 col-md-offset-1">
                    <form class="bs-example bs-example-form" role="form" action="">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="课程的关键字"/>
                            <span class="input-group-btn">
                        <input type="submit" class="btn btn-default" value="搜索"/>
                    </span>
                        </div>
                    </form>
                </div>
                <div class="col-md-3">
                    <div class=" span-label" style="margin-top: 7px;">
                        搜索标签：
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                        <a href="#"><span class="label label-info">信息标签</span></a>
                    </div>
                </div>
            </div>
            <div class="row-courses-frame" style="margin-top: 50px">
                <c:forEach items="${courses}" var="course" begin="0" end="${courses.size()}">
                    <div class="col-md-3 course-info-frame" style="height: 270px;margin-top: 50px">
                        <div class="course-pic" style="height: 250px;overflow: hidden">
                            <a href="/AcademicSharedSystem/course/${course.courseId}?teacherId=${course.teacherId}"><img class="img-responsive img-thumbnail" src="${course.coursePic}" alt=""></a>
                        </div>
                        <div class="course-brief" style="height: 20px;">
                            <div class="col-md-7">
                                <span class="glyphicon glyphicon-align-left"></span>
                                &nbsp;&nbsp;
                                <a href="/AcademicSharedSystem/course/${course.courseId}?teacherId=${course.teacherId}" style="font-size: 11px;">${course.courseName}</a>
                            </div>
                            <div class="col-md-5" style="text-align: right">
                                <span class="glyphicon glyphicon-user"></span>
                                <a href="#" style="font-size: 11px;">${course.teacherName}</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="col-md-12">
                <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                    <ul class="pagination">
                        <c:if test="${type.equals('all')}">
                            <li><a href="/AcademicSharedSystem/course/all/1">&laquo;</a></li>
                            <li><a href="/AcademicSharedSystem/course/all/1">1</a></li>
                            <li><a href="/AcademicSharedSystem/course/all/2">2</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </c:if>
                        <c:if test="${type.equals('exl')}">
                            <%--                            <li><a href="/AcademicSharedSystem/course/excl/1">&laquo;</a></li>--%>
                            <li><a href="/AcademicSharedSystem/course/excl/1">1</a></li>
                            <%--                            <li><a href="/AcademicSharedSystem/course/excl/2">2</a></li>--%>
                            <%--                            <li><a href="#">&raquo;</a></li>--%>
                        </c:if>
                        <c:if test="${type.equals('selected')}">
                            <li><a href="#">&laquo;</a></li>
                            <li><a href="#">1</a></li>
                            <li><a href="#">&raquo;</a></li>
                        </c:if>

                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
