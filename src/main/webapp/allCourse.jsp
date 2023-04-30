<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %>
<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部课程</title>
</head>
<body>
<div>
    <a href="course.jsp">查看全部课程</a>
    <table border="1">
        <tr>
            <td>&nbsp;</td>
            <td><b>序号</b></td>
            <td><b>课程名称</b></td>
            <td><b>选课人数</b></td>
            <td><b>课程性质</b></td>
        </tr>
        <%
            // 1.获取课程列表
            List<Course> courseList = new CourseDAOImpl().getCourse();
            // 2.遍历集合
            for (Course course : courseList) {
        %>
        <tr>
            <td><input type="checkbox"></td>
            <td><%=course.getCourseId()%>
            </td>
            <td><%=course.getCourseName()%>
            </td>
            <td><%=course.getCourseNum()%>
            </td>
            <td><%=course.getCourseType()%>
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
