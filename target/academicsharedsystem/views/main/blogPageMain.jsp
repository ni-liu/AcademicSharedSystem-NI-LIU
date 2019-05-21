<%--
  Created by IntelliJ IDEA.
  User: Nisson_CD
  Date: 2019/5/20
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="info-match-search">
    <div class="col-md-6 col-md-offset-1">
        <form class="bs-example bs-example-form" role="form" action="">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="博客的关键字"/>
                <span class="input-group-btn">
                            <input type="submit" class="btn btn-default" value="搜索"/>
                        </span>
            </div>
        </form>
    </div>
    <div class="col-md-3">
        <div class=" span-label">
            搜索标签：
            <a href="#"><span class="label label-info">信息标签</span></a>
            <a href="#"><span class="label label-info">信息标签</span></a>
            <a href="#"><span class="label label-info">信息标签</span></a>
            <a href="#"><span class="label label-info">信息标签</span></a>
        </div>
    </div>
</div>
<div class="col-md-10 col-md-offset-1 table-frame">
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th style="width: 1000px;text-align: center">博客名称</th>
            <th style="width: 180px;text-align: center">发布者</th>
            <th style="text-align: center">发布日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${}">
            <tr>
                <td>${c.BLOG_TITLE}</td>
                <td>${c.NICKNAME}</td>
                <td>${c.LAUNCH_TIME}</td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>
<div class="col-md-6 col-md-offset-3" style="text-align: center;margin-top: 40px">
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>

</div>