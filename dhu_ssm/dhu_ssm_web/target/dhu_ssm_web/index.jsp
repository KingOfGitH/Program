<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>
<a href="${pageContext.request.contextPath}/product/findAll.do">查询所有</a>

<script>
        window.location.href="${pageContext.request.contextPath}/pages/main.jsp";
</script>
</body>
</html>
