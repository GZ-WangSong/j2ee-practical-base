<%@ page import="com.mysql.jdbc.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程表</title>
</head>
<body>
<div>
    <a href="course.jsp">查看全部课程</a>
    <%
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/59_JDBC";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username,
                password);

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM course");
    %>
    <table border="1">
        <tr>
            <td>&nbsp;</td>
            <td><b>序号</b></td>
            <td><b>课程名称</b></td>
            <td><b>选课人数</b></td>
            <td><b>课程性质</b></td>
        </tr>

        <%
            while (rs.next()) {
                if (rs.getInt("cNum") != 0) {
        %>
        <tr>
            <td><input type="checkbox"></td>
            <td><%=rs.getString(1)%>
            </td>
            <td><%=rs.getString("cName")%>
            </td>
            <td><%=rs.getInt("cNum")%>
            </td>
            <td><%=rs.getString("cType")%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <br>
    <br> &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" onclick="window.location.href='addCourse.jsp';"
           value="新增"/> &nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" onclick="window.location.href='delCourse.jsp';"
           value="删除"/>
</div>

</body>
</html>
