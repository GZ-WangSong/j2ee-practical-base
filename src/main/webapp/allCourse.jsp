<%@ page import="cn.edu.njust.dao.CourseDAO" %>
<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部课程</title>
</head>
<body>
<div>
    <a href="course.jsp">查看全部课程</a>
    <%
        CourseDAO courseDAO = new CourseDAOImpl();
        // 读取对象
        Course course = courseDAO.readCourse();
        ArrayList<String> Idlist = course.getcIdList();
        ArrayList<String> nameList = course.getcNameList();
        ArrayList<String> numList = course.getcNumList();
        ArrayList<String> typeList = course.getcTypeList();

    %>
    <table border="2">
        <tr>
            <td>&nbsp;</td>
            <td><b>序号</b></td>
            <td><b>课程名称</b></td>
            <td><b>选课人数</b></td>
            <td><b>课程性质</b></td>
        </tr>
        <%
            for (int i = 0; i < Idlist.size(); i++) {
        %>
        <tr>
            <td><input type="checkbox"></td>
            <td><%=Idlist.get(i)%>
            </td>
            <td><%=nameList.get(i)%>
            </td>
            <td><%=numList.get(i)%>
            </td>
            <td><%=typeList.get(i)%>
            </td>
        </tr>
        <%
            }
        %>
    </table>
    <br>
    <br>
    <input type="button" onclick="window.location.href='addCourse.jsp';"
           value="新增"/>
    <input type="button" onclick="window.location.href='delCourse.jsp';"
           value="删除"/>
</div>
</body>
</html>
