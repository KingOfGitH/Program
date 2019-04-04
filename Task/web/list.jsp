<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张博锐
  Date: 2019/4/4
  Time: 20:59
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
    <title>用户列表</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <h3 style="text-align: center">注册用户列表</h3>
    <div style="float: left;margin: 5px;">
        <form class="form-inline">
            <div class="form-group">
                <label for="findUserName">用户名</label>
                <input type="text" class="form-control" id="findUserName">
            </div>
            <div class="form-group">
                <label for="findAddress">籍贯</label>
                <input type="email" class="form-control" id="findAddress">
            </div>
            <div class="form-group">
                <label for="findEmail">Email</label>
                <input type="email" class="form-control" id="findEmail">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="register.jsp">注册用户</a>
        <a class="btn btn-primary" href="register.jsp">删除用户</a>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tbody>
        <tr class="success">
            <th><input type="checkbox"></th>
            <th>编号</th>
            <th>ID</th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>邮箱</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${users}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.id}</td>
                <td><a class="btn btn-default btn-sm" href="update.jsp">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="10" align="center"><a class="btn btn-primary" href="register.jsp">添加联系人</a></td>
        </tr>
        </tbody>
    </table>
    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 25px;margin-left: 5px;">
        共16条记录，共4页
      </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
