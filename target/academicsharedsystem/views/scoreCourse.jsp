<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/29
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
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
                <li><a href="/AcademicSharedSystem/stu/score/1">课程打分</a></li>
                <li><a href="/AcademicSharedSystem/releaseBlog/toRelease?courseId=${course.courseId}">发布博客</a></li>
                <li><a href="#">个人信息管理</a></li>
            </ul>
        </div>
        <div class="col-md-10 main" style="margin-top: 50px">
            <form method="post" action="">
                <div class="col-md-12">
                    <table class="table table-striped table-bordered">
                        <thead>
                        <tr>
                            <th style="width: 60%">课程名</th>
                            <th style="width: 10%;text-align: center">课号</th>
                            <th style="width: 10%;text-align: center">老师</th>
                            <th style="width: 20%;text-align: center">分数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courses}" begin="0" end="${courses.size()}" var="course">
                            <tr>
                                <td><a href="/AcademicSharedSystem/course/${course.courseId}?teacherId=${course.teacherId}">${course.courseName}&nbsp;&nbsp;</a> </td>
                                <td style="text-align: center">${course.courseId}</td>
                                <td style="text-align: center"><a href="">${course.teacherName}</a> </td>
                                <td style="text-align: center">
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadio${course.courseId}" value="1" onclick="f('inlineRadio${course.courseId}' , 'inlineRadio1Value${course.courseId}')"> 1
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadio${course.courseId}" value="2" onclick="f('inlineRadio${course.courseId}' , 'inlineRadio1Value${course.courseId}')"> 2
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadio${course.courseId}" value="3" onclick="f('inlineRadio${course.courseId}' , 'inlineRadio1Value${course.courseId}')"> 3
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadio${course.courseId}" value="4" onclick="f('inlineRadio${course.courseId}' , 'inlineRadio1Value${course.courseId}')"> 4
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="inlineRadio${course.courseId}" value="5" onclick="f('inlineRadio${course.courseId}' , 'inlineRadio1Value${course.courseId}')"> 5
                                    </label>
                                    <input type="hidden" name="courseIds">
                                    <input type="hidden" name="scores"/>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div style="text-align: right" class="col-md-12"><strong>注： &nbsp;只能评价一次，不能更改</strong></div>
                <div style="text-align: center;"><input type="submit" class="btn btn-info" value="提交"></div>
            </form>
            <div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
                <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#">1</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul>
            </div>


        </div>
    </div>
</div>

<script type="text/javascript">
    function f(radioName , goalInputName) {
        let score = document.getElementsByName(radioName);
        let value = 0;
        for(let i = 0 ; i < score.length ; i ++) {
            if (score[i].checked === true) {
                value = score[i].value;
                break;
            }
        }
        document.getElementsByName(goalInputName).value = value;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
