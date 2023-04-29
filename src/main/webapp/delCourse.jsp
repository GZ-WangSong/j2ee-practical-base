<%@ page import="cn.edu.njust.dao.CourseDAO" %>
<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %><%--
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
<a href="course.jsp">查看全部课程</a>
<form action="MyDelete" onsubmit="return del()">
    <input type="hidden" name="operation" value="del">
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
            <td><input type="checkbox" value=<%=nameList.get(i)%> name="flag"/></td>
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
    <br><br>

    <input type="submit" value="删除选中">
    <%
    %>
</form>

<script>
    function del() {
        return confirm("您确定要删除吗？");
    }
</script>

</body>
</html>
