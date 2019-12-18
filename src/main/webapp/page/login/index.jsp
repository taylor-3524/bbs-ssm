<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>Title</title>
</head>
<body>
    <form action="login" method="post">
        <table align="center" border="1">
            <tr>
                <td align="center" colspan="2">BBS大论坛</td>
            </tr>
            <tr>
                <td>账号</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"/></td>
                <td style="color: red;">${tip}</td>
            </tr>
        </table>
    </form>
</body>
</html>
