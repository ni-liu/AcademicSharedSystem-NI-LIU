<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<div class="navbar-header">
    <a class="navbar-brand" href="#">高校资源管理共享系统</a>
</div>
<div>
    <ul class="nav navbar-nav">
        <li><a href="/AcademicSharedSystem/course/all/1">高校课程信息</a></li>
        <li><a href="/AcademicSharedSystem/listBlog/list/1">优质博客内容</a></li>
        <li>
            <c:choose>
                <c:when test="${sessionScope.get('loginUser') == null}">
                    <a href="/AcademicSharedSystem/views/login.jsp">个人主页</a>
                </c:when>
                <c:otherwise>
                    <c:if test="${sessionScope.get('loginUser').role.roleId eq 1}">
                        <a href="/AcademicSharedSystem/course/release">教师个人主页</a>
                    </c:if>
                    <c:if test="${sessionScope.get('loginUser').role.roleId eq 2}">
                        <a href="/AcademicSharedSystem/stu/selected/1">学生个人主页</a>
                    </c:if>
                    <c:if test="${sessionScope.get('loginUser').role.roleId eq 3}">
                        <a href="/AcademicSharedSystem/admin/manage/all/1">管理员个人主页</a>
                    </c:if>
                </c:otherwise>
            </c:choose>

        </li>
    </ul>
</div>
<ul class="nav navbar-nav navbar-right">
    <li>
        <c:choose>
            <c:when test="${sessionScope.get('loginUser') == null}">
                <a href="#"><span class="glyphicon glyphicon-log-in"></span> 注册</a>
            </c:when>
            <c:otherwise>
                <a href="/AcademicSharedSystem/login-out"><span class="glyphicon glyphicon-log-out"></span> 注销 </a>
            </c:otherwise>
        </c:choose>

    </li>
    <li>
        <c:choose>
            <c:when test="${sessionScope.get('loginUser') == null}">
                <a href="/AcademicSharedSystem/views/login.jsp"><span class="glyphicon glyphicon-log-in"></span> 登录</a>
            </c:when>
            <c:otherwise>
                <a href=""><span class="glyphicon glyphicon-user"></span> ${sessionScope.get('loginUser').nickName} </a>
            </c:otherwise>
        </c:choose>

    </li>
</ul>