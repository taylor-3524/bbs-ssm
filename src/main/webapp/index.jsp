<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<input type="button" value="主贴" onclick="btn_1()">
<input type="button" value="登录" onclick="btn_2()">
</body>
<script>
    function btn_1() {
        window.location.href="index/show"
    }
</script>
<script>
    function btn_2() {
        window.location.href="login/index"
    }
</script>
</html>
