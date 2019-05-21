<%--
  Created by IntelliJ IDEA.
  User: 曦
  Date: 2019-6-2
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>举报博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../css/index-layout.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<style>
    div{
        white-space:nowrap;
    }
    .layui-form-radio span{
         font-size:23px;
     }
</style>
<div class="container-fluid">
    <nav class="navbar" role="navigation">
        <jsp:include page="navbar/navbar.jsp"/>
    </nav>
    <div class="row">
        <div class="col-md-12 main">
            <div class="form-container col-md-6 col-md-offset-4">
                <form class="form-horizontal" action="/AcademicSharedSystem/reportBlog/report" method="post" enctype="multipart/form-data">
                    <input hidden name="blogId" value="${blogId}"/>
                    <input hidden name="userId" value="${userId}">
                    <div class="col-md-8 col-md-offset-2 form-group">
                        <h3 class="col-sm-2 control-label" style="font-family: 楷体">博客主题:</h3>
                        <h3 class="col-md-2 control-label col-md-offset-3" style="font-family: 楷体">${blogTitle}</h3>
                    </div>
                    <div class="col-md-8 col-md-offset-2 form-group">
                        <h3 class="col-sm-2 control-label" style="font-family: 楷体">博客作者:</h3>
                        <h3 class="col-md-2 control-label col-md-offset-3" style="font-family: 楷体">${nickName}</h3>
                    </div>
                    <div class="col-md-8 col-md-offset-2 form-group">
                        <h3 class="col-sm-2 " style="font-family: 楷体">举报原因:</h3>
                        <div class="col-sm-6 col-md-offset-5">
                            <label style="font-size: 21px"><input type="radio" name="reason" value="1" >垃圾营销</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="2" >涉黄信息</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="3" >不实信息</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="4" >人身攻击</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="5" >有害信息</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="6" >内容抄袭</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="7" >违法信息</label><br/>
                            <label style="font-size: 21px"><input type="radio" name="reason" value="8" >诈骗信息</label><br/>
                        </div>
                    </div>
                    <div class="col-md-12  form-group" >
                        <input type="submit" class="col-md-offset-4 btn btn-default" style="font-size: 22px" value="提交举报" >
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>
</html>
