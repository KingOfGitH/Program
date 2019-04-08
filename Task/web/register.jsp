<%--
  Created by IntelliJ IDEA.
  User: 张博锐
  Date: 2019/4/4
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户注册</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/RegisterUI.js"></script>
</head>
<body>
<div class="container">
    <center><h3>注册页面</h3></center>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/registerServlet" method="post" onsubmit="return checkAll()">

        <div class="form-group has-warning has-feedback" id="userNameStateDiv">
            <label for="userName" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="userName" name="userName" onblur="checkName()"
                       placeholder="请输入用户名，由3-30位字母数字下划线组成，不能由下划线开头，区分大小写">
                <span id="userNameStateSpan" class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
            </div>
        </div>

        <div class="form-group has-warning has-feedback" id="passwordStateDiv">
            <label for="password" class="col-sm-2 control-label">密码：</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password" name="password" onblur="checkPassword()"
                       placeholder="请输入密码，由6-16位字符组成">
                <span id="passwordStateSpan" class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
            </div>
        </div>

        <div class="form-group has-warning has-feedback" id="passwordStateDiv1">
            <label for="password1" class="col-sm-2 control-label">确认密码：</label>
            <div class="col-sm-8">
                <input type="password" class="form-control" id="password1" name="password1" onblur="checkPassword1()"
                       placeholder="请确认您的密码">
                <span id="passwordStateSpan1" class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
            </div>
        </div>

        <div class="form-group has-success has-feedback" >
            <label  class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-8">
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>
        </div>

        <div class="form-group has-success has-feedback" id="ageStateDiv">
            <label for="age" class="col-sm-2 control-label">年龄：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="age" name="age"
                       onblur="checkAge()" placeholder="请输入年龄">
                <span id="ageStateSpan"></span>
            </div>
        </div>


        <div class="form-group has-success has-feedback" >
            <label  class="col-sm-2 control-label">籍贯：</label>
            <div class="col-sm-8">
            <select name="region" class="form-control" id="region">
                <option value="上海" selected>上海</option>
                <option value="山西">山西</option>
                <option value="深圳">深圳</option>
            </select>
            </div>
        </div>

        <div class="form-group has-success has-feedback" id="emailStateDiv">
            <label  class="col-sm-2 control-label">Email：</label>
            <div class="col-sm-8">
                <input type="email" class="form-control" id="email" name="email"
                       onblur="checkEmail()" placeholder="请输入邮箱地址"/>
                <span id="emailStateSpan"></span>
            </div>
        </div>


        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <a href="${pageContext.request.contextPath}/findUserByPageServlet"><input class="btn btn-default" type="button" value="返回" /></a>
        </div>
    </form>
    <div class="container alert alert-warning alert-dismissible" role="alert"  style="width: 400px;">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span>
        </button>
        <strong>${register_msg}</strong>
    </div>
</div>
</body>
</html>
