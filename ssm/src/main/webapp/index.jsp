<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello World</title>
</head>
<body>
    <a href="account/findAll">测试</a>

    <form method="post" action="/account/save">
        姓名：<input type="text" name="name" /><br>
        金钱：<input type="text" name="money" /><br>
        <input type="submit" value="保存"/>
    </form>
</body>
</html>
