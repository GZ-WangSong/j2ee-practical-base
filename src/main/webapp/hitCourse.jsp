<%@ page import="cn.edu.njust.pojo.Login" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.njust.pojo.HitCourse" %>
<%@ page import="cn.edu.njust.dao.impl.HitCourseDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/30
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hitCourse</title>
</head>
<body>
<div>
    <form action="courseController" method="post" onsubmit="return exit()">
        <input type="hidden" name="operation" value="withdrawal">
        <%
            Login loginUser = (Login) request.getSession().getAttribute("loginUser");
        %>
        <b>学号：</b><%=loginUser.getId()%>
        <b>姓名：</b><%=loginUser.getName()%>
        <table border="1">
            <tr>
                <td></td>
                <td align="center"><b></b></td>
                <td align="center"><b>课程序号</b></td>
                <td align="center"><b>课程名称</b></td>
                <td align="center"><b>分数</b></td>
            </tr>
            <%
                List<HitCourse> hitCourseList = new HitCourseDAOImpl().getHitCourse(loginUser);
                for (int i = 0; i < hitCourseList.size(); i++) {
            %>
            <tr>
                <td><input type="checkbox" value=<%=hitCourseList.get(i).getcId()%>
                        name="choose"/></td>
                <td align="center"><b><%=i + 1%>
                </b></td>
                <td align="center"><b><%=hitCourseList.get(i).getcId()%>
                </b></td>
                <td align="center"><b><%=hitCourseList.get(i).getcName()%>
                </b></td>
                <td align="center"><b><%=hitCourseList.get(i).getScore()%>
                </b></td>

            </tr>
            <%
                }
            %>
        </table>
        <br> <br>
        <input type="submit" class="button" value="退选">
        <br>
        <input type="button" value="课程管理" onclick="window.location.href='allCourse.jsp'"/>
    </form>
</div>

<script>
    function exit() {
        return confirm("您确定要退选选中课程吗？");
    }
</script>
</body>
</html>
