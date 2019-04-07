<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 张博锐
  Date: 2019/4/1
  Time: 17:52
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

<h3 style="text-align: center;">用户${user.userName}，欢迎您</h3>
<div align="center">
  <a href="${pageContext.request.contextPath}/findUserByPageServlet">查询用户列表</a>
</div>
<div align="center">
  <a href="${pageContext.request.contextPath}/logoutServlet">安全退出</a>
</div>
  </body>
</html>
