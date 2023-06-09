<%@ page import="java.util.List" %>
<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: NJUST'er'wang's
  Date: 2023/4/30
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课</title>
</head>
<body>
<div>
    <input type="button" value="查看全部课程" onclick="location.href = 'allCourse.jsp' ">
    <form action="courseController" method="post" onsubmit="return choose()">
        <input type="hidden" name="operation" value="choose">

        <table border="1">
            <tr>
                <td>&nbsp;</td>
                <td><b>序号</b></td>
                <td><b>课程名称</b></td>
                <td><b>选课人数</b></td>
                <td><b>课程性质</b></td>
            </tr>
            <%
                List<Course> list = new CourseDAOImpl().getCourse();
                for (Course course : list) {
            %>
            <tr>
                <td><input type="checkbox" value=<%=course.getCourseId()%>
                        name="flag"/></td>
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
        <br> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="选中课程">
    </form>

</div>

<script>
    function choose() {
        return confirm("您确定要选择该门课程吗？");
    }
</script>
</body>
</html>
