<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/29
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>删除课程</title>
</head>
<body>
<div>
    <input type="button" value="查看全部课程" onclick="location.href = 'course.jsp'"/>

    <form action="courseController" onsubmit="return del()">
        <input type="hidden" name="operation" value="del">
        <table border="2">
            <tr>
                <td></td>
                <td><b>序号</b></td>
                <td><b>课程名称</b></td>
                <td><b>选课人数</b></td>
                <td><b>课程性质</b></td>
            </tr>
            <%
                List<Course> courseList = new CourseDAOImpl().getCourse();
                for (Course course : courseList) {
            %>
            <tr>
                <td><input type="checkbox" value=<%=course.getCourseName()%> name="flag"/></td>
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
        <br><br>
        <input type="submit" value="删除选中">
    </form>
</div>

<script>
    function del() {
        return confirm("您确定要删除吗？");
    }
</script>

</body>
</html>
