<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<body>
<h2>Hello World!</h2>

<script>
        window.location.href="${pageContext.request.contextPath}/pages/login.jsp";
</script>
</body>
</html>
