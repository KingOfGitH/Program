<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>test</title>
    <script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testAjax",
                    contentType:"application/json;charset=utf-8",
                    data:'{"uname":"uname","age":10,"date":20}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        alert(data);
                        alert(data.uname)
                    }
                })
            });
        });
    </script>
</head>
<body>
    <h2>Hello World!</h2>

    <a href="/user/zhangsan&456">点我</a>

    <form method="post" action="/user/saveUser">
    <%--    姓名：<input type="text" name="username" /><br>--%>
    <%--    密码：<input type="password" name="password"><br>--%>
    <%--    金额：<input type="text" name="money"><br>--%>
        用户：<input type="text" name="uname"><br>
        年龄：<input type="text" name="age"><br>
    <%--    年龄：<input type="text" name="date"><br>--%>
        <input type="submit" value="提交">
    </form>
    <br>

    <button id="btn">hello</button>
    <br>

    <form method="post" action="/user/fileUpLoad" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>

    <form method="post" action="/user/fileUpLoad1" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>

    <form method="post" action="/user/fileUpLoad2" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"><br>
        <input type="submit" value="上传">
    </form>
    <br>

    <a href="/user/exception">异常处理</a><br>
    <a href="/user/interceptor">拦截器</a><br>
</body>
</html>
