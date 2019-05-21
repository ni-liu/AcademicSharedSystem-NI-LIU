<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>课程信息</title>
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
        <div class="col-md-2 sidebar">
            <jsp:include page="sidebar/stuInfoSideBar.jsp"/>
        </div>
        <div class="col-md-10 main">
            <!-- CourseContentMain -->
            <div class="col-md-7 col-md-offset-3" id="course-title">
                <h2>${whichCourse.courseName}(${whichCourse.courseId})</h2>
            </div>
            <div class="col-md-4 col-md-offset-3" id="course-other-info" style="text-align: right">
                <h4>授课老师：<a href="#">${teacherName}</a></h4>
            </div>
            <div class="col-md-2" id="course-select">
                <c:if test="${ifSelected eq true && sessionScope.get('loginUser').role.roleId eq 2}">
                    <form class="form-horizontal" action="#">
                        <input type="hidden" name="courseId" value="${whichCourse.courseId}">
                        <input type="hidden" name="teacherId" value="${whichCourse.teacherId}">
                        <input type="submit" value="已选" class="btn btn-info" disabled>
                    </form>
                </c:if>
                <c:if test="${ifSelected eq false && sessionScope.get('loginUser').role.roleId eq 2}">
                    <form class="form-horizontal" action="/AcademicSharedSystem/stu/courseSelect" method="post">
                        <input type="hidden" name="courseId" value="${whichCourse.courseId}">
                        <input type="hidden" name="teacherId" value="${whichCourse.teacherId}">
                        <input type="submit" value="选课" class="btn btn-info">
                    </form>
                </c:if>

            </div>
            <!-- 信息 -->
            <div class="col-md-12">
                <div class="widget-box">
                    <!-- tab title -->
                    <div class="widget-title">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#tab1">课程信息</a></li>
                            <li><a data-toggle="tab" href="#tab2" onsubmit="">课程实验报告下载</a></li>

                            <c:if test="${ifSelected eq true}">
                                <li><a data-toggle="tab" href="#tab3" onsubmit="">课程实验报告上传</a></li> <!-- 选了课的学生 -->
                            </c:if>

                            <li><a data-toggle="tab" href="#tab4">课程模拟试卷下载</a></li>
                            <li><a data-toggle="tab" href="#tab5">课程大纲下载</a></li>
                        </ul>
                    </div>
                    <!-- tab title -->
                    <div class="widget-content tab-content">
                        <!-- 课程信息 -->
                        <div id="tab1" class="tab-pane active">
                            <pre class="pre-scrollable" style="margin-top: 50px">
                                <p>课设专业：${majorName}</p>
                                <p>课程信息：${whichCourse.courseInfo}</p>
                                <p>其他：<c:choose><c:when test="${whichCourse.hasAgreed.agreed != 3}">普通课程</c:when><c:otherwise>精品课程</c:otherwise></c:choose></p>
                            </pre>
                        </div>
                        <!-- 课程信息 -->
                        <!-- 实验报告 -->
                        <div id="tab2" class="tab-pane">
                            <div class="widget-box" style="margin-top: 50px">
                                <!-- 上传新的实验 -->
                                <c:set var="pkId" scope="page" value="${sessionScope.get('loginUser').pkId}"/>
                                <c:if test="${whichCourse.teacherId eq pkId}">
                                    <form class="form-horizontal" action="/AcademicSharedSystem/course/${whichCourse.courseId}/exp" style="margin-top: 50px" method="post" enctype="multipart/form-data">
                                        <div class="col-md-12 form-group">
                                            <label for="uploadExp" class="control-label col-sm-3">上传课程的新实验报告</label>
                                            <div class="col-sm-3">
                                                <input id="uploadExp" class="form-control" type="text" name="fileName" placeholder="填写上传实验的名称" required>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="file" id="courseOutline" name="fileUpload" required>
                                                <p class="help-block">*必填</p>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="submit" class="btn btn-default" value="新的实验">
                                            </div>
                                        </div>
                                    </form>
                                </c:if>
                                <!-- 上传新的实验 -->
                                <!-- 实验表格 -->
                                <div class="widget-content nopadding">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                        <tr>
                                            <th style="width: 700px">实验报告标题</th>
                                            <th style="width: 200px">上传人</th>
                                            <th style="width: 200px">下载</th>
                                            <c:if test="${whichCourse.teacherId eq pkId}">
                                                <th style="width: 200px">删除</th>
                                            </c:if>
                                            <th>下载次数</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${expsList}" begin="0" end="${expsList.size()}" var="exp">
                                            <tr class="gradeX">
                                                <td>${exp.fileName}</td>
                                                <td>${teacherName}</td>
                                                <td><a href="${exp.download}">点这里下载</a></td>
                                                <c:if test="${whichCourse.teacherId eq pkId}">
                                                    <td><a href="#">删除</a></td>
                                                </c:if>
                                                <td class="center">12</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <!-- 实验表格 -->
                            </div>
                        </div>
                        <!-- 实验报告 -->

                        <c:if test="${ifSelected eq true}">
                            <!-- 实验报告上传 -->
                            <div id="tab3" class="tab-pane">
                                <div class="widget-box" style="margin-top: 50px">
                                    <!-- 实验表格 -->
                                    <div class="widget-content nopadding">
                                        <table class="table table-striped table-bordered">
                                            <thead>
                                            <tr>
                                                <th style="width: 50%">实验报告标题</th>
                                                <th style="width: 25%">上传</th>
                                                <th style="width: 10%">上传状态</th>
                                                <th>上传时间</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="exps" begin="0" end="${expsList.size()}" items="${expsList}">
                                                <tr class="gradeX">
                                                    <td>${exps.fileName}</td>
                                                    <td>
                                                        <form class="form-horizontal" action="/AcademicSharedSystem/course/stuUpload" method="post" enctype="multipart/form-data">
                                                            <input type="hidden" name="expId" value="${exps.pkId}">
                                                            <input type="hidden" name="courseId" value="${whichCourse.courseId}">
                                                            <input type="hidden" name="teacherId" value="${whichCourse.teacherId}">
                                                            <input type="file" name="upload" class="col-sm-10" required>
                                                            <input type="submit" value="上传" class="btn btn-info col-sm-2">
                                                        </form>
                                                    </td>
                                                    <td>未上传</td>
                                                    <td class="center">无</td>
                                                </tr>
                                            </c:forEach>


                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- 实验表格 -->
                                </div>
                            </div>
                            <!-- 实验报告上传 -->
                        </c:if>

                        <!-- 模拟试卷 -->
                        <div id="tab4" class="tab-pane">
                            <div class="widget-box" style="margin-top: 50px">
                                <!-- 上传新的模拟试卷 -->
                                <c:if test="${whichCourse.teacherId eq pkId}">
                                    <form class="form-horizontal" action="/AcademicSharedSystem/course/${whichCourse.courseId}/testPaper" style="margin-top: 50px;" method="post" enctype="multipart/form-data">
                                        <div class="col-md-12 form-group">
                                            <label for="uploadExp" class="control-label col-sm-3">上传课程的新模拟试卷</label>
                                            <div class="col-sm-3">
                                                <input id="uploadPaperTest" class="form-control" type="text" name="fileName" placeholder="填写上传模拟试卷的名称" required>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="file" id="paperTest" name="fileUpload" required>
                                                <p class="help-block">*必填</p>
                                            </div>
                                            <div class="col-sm-3">
                                                <input type="submit" class="btn btn-default" value="新的模拟试卷">
                                            </div>
                                        </div>
                                    </form>
                                </c:if>
                                <!-- 上传新的模拟试卷 -->
                                <!-- 模拟试卷表格 -->
                                <div class="widget-content nopadding">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                        <tr>
                                            <th style="width: 700px">模拟试卷标题</th>
                                            <th style="width: 200px">上传人</th>
                                            <th style="width: 200px">下载</th>
                                            <c:if test="${whichCourse.teacherId eq pkId}">
                                                <th style="width: 200px">删除</th>
                                            </c:if>
                                            <th>下载次数</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${paperTestsList}" begin="0" end="${paperTestsList.size()}" var="paper">
                                            <tr class="gradeX">
                                                <td>${paper.fileName}</td>
                                                <td>${teacherName}</td>
                                                <td><a href="${paper.download}">点这里下载</a></td>
                                                <c:if test="${whichCourse.teacherId eq pkId}">
                                                    <td><a href="#">删除</a></td>
                                                </c:if>

                                                <td class="center">12</td>
                                            </tr>
                                        </c:forEach>

                                        </tbody>
                                    </table>
                                </div>
                                <!-- 模拟试卷表格 -->
                            </div>
                        </div>
                        <!-- 模拟试卷 -->
                        <!-- 课程大纲 -->
                        <div id="tab5" class="tab-pane">
                            <div class="widget-box" style="margin-top: 50px">
                                <div class="widget-content nopadding">
                                    <table class="table table-striped table-bordered">
                                        <thead>
                                        <tr>
                                            <th style="width: 50%">课程大纲</th>
                                            <th style="width: 10%">上传人</th>
                                            <th style="width: 10%">下载次数</th>
                                            <c:if test="${sessionScope.get('loginUser').pkId == whichCourse.teacherId}">
                                                <th style="width: 30%">重传</th>
                                            </c:if>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr class="gradeX">
                                            <td> <a href="${whichCourse.courseOutlineDownload}">点这里下载</a></td>
                                            <td>${teacherName}</td>
                                            <td class="center">12</td>
                                            <c:if test="${sessionScope.get('loginUser').pkId == whichCourse.teacherId}">
                                                <td>
                                                    <form class="form-horizontal" action="" method="post">
                                                        <input type="file" name="courseOutlineReload" class="col-sm-6" required>
                                                        <input type="submit" value="重传" class="btn btn-info col-sm-2">
                                                    </form>
                                                </td>
                                            </c:if>

                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- 课程大纲 -->
                    </div>
                    <!-- CourseContentMain -->
                </div>
            </div>
            <!-- 信息 -->
        </div>
    </div>
</div>
<script src="../js/star.js"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
