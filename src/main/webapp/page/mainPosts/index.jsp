<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <script type="text/javascript">
        function tiaozhuan(id) {
            window.location.href="discuss?mainPostsId="+id;
        }
    </script>
</head>
<body>
<div class="wrap">
    <div class="top"></div>
    <div class="body">
        <c:forEach var="mainPosts" items="${list}" varStatus="status">
            <div class="content" onclick="tiaozhuan(${mainPosts.id})">
                <div class="left">
                    <ul>
                        <li class="li-head">
                            <img src="${mainPosts.url}">
                        </li>
                        <li>
                                ${mainPosts.userName}
                        </li>
                    </ul>
                </div>
                <div class="right">
                    <div class="title">
                            ${mainPosts.title}
                    </div>
                    <div>
                            ${mainPosts.content}
                    </div>
                    <div class="time">
                            ${mainPosts.time}
                    </div>
                </div>
            </div>
        </c:forEach>
        <div class="page">
            <c:forEach   var="varName"     varStatus="vatStatusName"    begin="1"   end="${allPage}"  step="1">
                <a href="index?nowPage=${varName}">第${varName}页</a>
            </c:forEach>
        </div>

    </div>
    <div class="bottom">
        <form action="index" method="post">
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="type" value="add">
                        <input name="title" type="text" placeholder="在此处输入标题">
                    </td>
                </tr>
                <tr>
                    <td>
                   <textarea name="content">

                   </textarea>
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="提交评论"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
