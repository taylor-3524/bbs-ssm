<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/discuss.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".replyButton").click(function () {
               $(this).parent().parent().parent().children().eq(1).children().eq(0).slideToggle();
            });
            
            $(".fabiao").click(function () {
                var content=$(this).parent().parent().children().eq(1).children().eq(0).val();
                var discussId=$(this).attr("value");
                var ul=$(this).parent().parent().children().eq(0).children().eq(0);
                $.ajax({
                    url:"discuss",
                    method:"post",
                    data:{
                        content:content,
                        discussId:discussId,
                        type:"replyAdd"
                    },
                    dataType:"json",
                    success:function (data) {
                        // console.log(data)
                        var li=$("<li>");
                        li.text(content);
                        ul.append(li)

                    }

                })
            })
        })
    </script>
</head>
<body>
<div class="wrap">
    <c:forEach var="mainList" items="${mainList}" varStatus="status">
    <div class="top">
        <div class="title">
                ${mainList.title}
        </div>
        <div class="content">
                ${mainList.content}
        </div>
        <div class="other">
            <div class="time"> ${mainList.time}</div>
            <div class="author"> ${mainList.userName}&nbsp;&nbsp;&nbsp;&nbsp;</div>
        </div>
        </c:forEach>
    </div>
    <div class="middle">
        <c:forEach var="discuss" items="${list}" varStatus="status">
            <div class="discuss">
                <div class="content">
                        ${discuss.content}
                </div>
                <div class="other">
                    <div class="time"> ${discuss.time}</div>
                    <div class="author"> ${discuss.userName}&nbsp;&nbsp;&nbsp;&nbsp;</div>
                    <div class="number">第${status.index+1}楼</div>
                </div>
                <div class="reply">
                    <table>
                        <tr>
                            <td align="right">
                                <button class="replyButton">回复</button>
                            </td>
                        </tr>
                        <tr>
                            <td class="replyWrap" align="right">
                                <div>
                                    <ul>
                                        <c:forEach var="reply" items="${discuss.list}" varStatus="status2">
                                            <li>${reply.content}</li>
                                        </c:forEach>
                                    </ul>
                                </div>
                                <div>
                                    <textarea></textarea>
                                </div>
                                <div>
                                    <button class="fabiao" value="${discuss.id}">发表</button>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="bottom">
        <form action="discuss" method="post">
            <input type="hidden" name="mainPostsId" value="${mainPostsId}">
            <input type="hidden" name="type" value="add">
            <table>
                <tr>
                    <td><textarea name="content"></textarea></td>
                </tr>
                <tr>
                    <td align="right"><input type="submit" value="评论"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
