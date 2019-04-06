<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张博锐
  Date: 2019/4/4
  Time: 16:33
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
    <title>修改信息</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/update.js"></script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">修改联系人</h3>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/updateUserServlet" method="post" onsubmit="return checkAll()">
        <%--隐藏内容--%>
        <input type="hidden" name="password" id="password" value="${user.password}" />

        <div class="form-group has-success has-feedback">
            <label for="id" class="col-sm-2 control-label">用户ID：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="id" name="id" value="${user.id}"
                       readonly="readonly">
            </div>
        </div>

        <div class="form-group has-success has-feedback" id="userNameStateDiv">
            <label for="userName" class="col-sm-2 control-label">用户名：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}"
                       readonly="readonly" placeholder="请输入用户名，由3-30位字母数字下划线组成，不能由下划线开头">
                <span id="userNameStateSpan"></span>
            </div>
        </div>

        <%--        <div class="form-group has-success has-feedback" id="oldPasswordStateDiv">--%>
        <%--            <label for="oldPassword" class="col-sm-2 control-label">用户名：</label>--%>
        <%--            <div class="col-sm-8">--%>
        <%--                <input type="text" class="form-control" id="oldPassword" name="oldPassword" --%>
        <%--                       readonly="readonly" placeholder="如想更改密码，请输入旧密码">--%>
        <%--                <span id="oldPasswordStateSpan"></span>--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <%--        <div class="form-group has-success has-feedback" id="passwordStateDiv">--%>
        <%--            <label for="newPassword" class="col-sm-2 control-label">密码：</label>--%>
        <%--            <div class="col-sm-8">--%>
        <%--                <input type="password" class="form-control" id="newPassword" name="newPassword" onblur="checkPassword()"--%>
        <%--                       placeholder="请输入密码，由6-16位字符组成">--%>
        <%--                <span id="passwordStateSpan"></span>--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <%--        <div class="form-group has-success has-feedback" id="passwordStateDiv1">--%>
        <%--            <label for="newPassword1" class="col-sm-2 control-label">确认密码：</label>--%>
        <%--            <div class="col-sm-8">--%>
        <%--                <input type="password" class="form-control" id="newPassword1" name="newPassword1" onblur="checkPassword1()"--%>
        <%--                       placeholder="请确认您的密码">--%>
        <%--                <span id="passwordStateSpan1"></span>--%>
        <%--            </div>--%>
        <%--        </div>--%>

        <div class="form-group has-success has-feedback">
            <label class="col-sm-2 control-label">性别：</label>
            <div class="col-sm-8">

                <c:if test="${user.gender=='男'}">
                    <input type="radio" name="gender" value="男" checked="checked"/>男
                    <input type="radio" name="gender" value="女"/>女
                </c:if>

                <c:if test="${user.gender=='女'}">
                    <input type="radio" name="gender" value="男"/>男
                    <input type="radio" name="gender" value="女" checked="checked"/>女
                </c:if>

                <c:if test="${user.gender!='男'}">
                    <c:if test="${user.gender!='女'}">
                        <input type="radio" name="gender" value="男" checked="checked"/>男
                        <input type="radio" name="gender" value="女"/>女
                    </c:if>
                </c:if>

            </div>
        </div>

        <div class="form-group has-success has-feedback" id="ageStateDiv">
            <label for="age" class="col-sm-2 control-label">年龄：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="age" name="age"
                       value="${user.age}" onblur="checkAge()" placeholder="请输入年龄">
                <span id="ageStateSpan"></span>
            </div>
        </div>


        <div class="form-group has-success has-feedback">
            <label class="col-sm-2 control-label">籍贯：</label>
            <div class="col-sm-8">
                <select name="region" class="form-control" id="region">
                    <option value="上海">上海</option>
                    <option value="山西">山西</option>
                    <option value="深圳">深圳</option>

                    <c:if test="${user.region=='山西'}">
                        <option value="上海">上海</option>
                        <option value="山西" selected>山西</option>
                        <option value="深圳">深圳</option>
                    </c:if>

                    <c:if test="${user.region=='深圳'}">
                        <option value="上海">上海</option>
                        <option value="山西">山西</option>
                        <option value="深圳" selected>深圳</option>
                    </c:if>

                </select>
            </div>
        </div>

        <div class="form-group has-success has-feedback" id="emailStateDiv">
            <label class="col-sm-2 control-label">Email：</label>
            <div class="col-sm-8">
                <input type="text" class="form-control" id="email" name="email"
                       value="${user.email}" onblur="checkEmail()" placeholder="请输入邮箱地址"/>
                <span id="emailStateSpan"></span>
            </div>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>
