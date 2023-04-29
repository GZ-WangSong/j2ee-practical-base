<%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>

    <meta http-equiv= "Refresh" content= "6;url=login.jsp ">
</head>
<body>
<div>
    <b>输入有误！</b><br>
    <b>请重新输入</b><br>
    <b>请检查验证码，且各项均不能为空值</b><br><br>
    <div  id= "time"> <b>处理中，请稍后...</b> </div>
</div>

<script>
    let times = 7;
    clock();
    function clock()
    {
        window.setTimeout('clock()',1000);
        times=times-1;
        time.innerHTML ="将在"+times+"秒后前往登录界面......";
    }
</script>
</body>
</html>
