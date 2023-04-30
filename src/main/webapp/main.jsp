<%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>

    <%-- 第5次作业跳转 --%>
<%--    <meta http-equiv="Refresh" content="5;url=allCourse.jsp ">--%>
    <%-- 第6次作业跳转要求 --%>
    <meta http-equiv="Refresh" content="5;url=hitCourse.jsp ">
</head>
<body>
<div>
    <h2>登录成功啦！</h2>
    <br><br>
    <div id="time"></div>
</div>


<script>
    let times = 6;
    clock();

    function clock() {
        window.setTimeout('clock()', 1000);
        times = times - 1;
        time.innerHTML = times + "秒后查看选课情况信息";
    }
</script>
</body>
</html>
