<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="form-container col-md-10 col-md-offset-1">
    <form class="form-horizontal" action="#" method="post">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label" name="userId">用户名</label>
            <div class="col-sm-10">
                <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的用户名">
            </div>
        </div>
        <div class="form-group" style="margin-top: 50px">
            <label for="inputPassword3" class="col-sm-2 control-label" name="pwd">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="请输入您的密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" > 记住我
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default"> 登录</button>
            </div>
        </div>
    </form>
</div>
