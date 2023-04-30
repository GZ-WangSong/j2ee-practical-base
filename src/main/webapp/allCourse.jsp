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
    <input type="button" value="查看全部课程" onclick="location.href = 'course.jsp' ">
    <table border="1">
        <tr>
            <td></td>
            <td><b>序号</b></td>
            <td><b>课程名称</b></td>
            <td><b>选课人数</b></td>
            <td><b>课程性质</b></td>
        </tr>

        <%
            List<Course> courseList = new CourseDAOImpl().getCourse();
            int index = 1;
            for (Course course : courseList) {
        %>
        <tr>
            <td><%=index++%>
            </td>
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
    <input type="button" value="新增" onclick="window.location.href='addCourse.jsp'"/>
    <br>
    <input type="button" value="删除" onclick="window.location.href='delCourse.jsp'"/>
    <br>
    <input type="button" value="选课" onclick="window.location.href='delCourse.jsp'"/>
</div>
</body>
</html>
