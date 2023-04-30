<%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程</title>
</head>
<body>
<div>
    <form action="courseController" method="post">
        <%-- 给控制器说明操作 --%>
        <input type = "hidden" name = "operation" value="add">

        课程序号：<input type="text" name="cId"><br>
        课程名称：<input type="text" name="cName"><BR>
        选课人数：<input type="text" name="cNum"><BR>
        课程性质：
        <select name="cType">
            <option value="必修">必修</option>
            <option value="选修">选修</option>
        </select><br>
        <input type="submit" value="添加课程">
    </form>
</div>
</body>
</html>
