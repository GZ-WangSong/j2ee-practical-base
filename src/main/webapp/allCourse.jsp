<%@ page import="cn.edu.njust.dao.impl.CourseDAOImpl" %>
<%@ page import="cn.edu.njust.pojo.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="cn.edu.njust.service.impl.CourseServiceImpl" %>
<%@ page import="cn.edu.njust.service.CourseService" %>
<%@ page import="cn.edu.njust.pojo.CoursePage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>全部课程</title>
</head>
<body>
<div>
    <input type="button" value="查看个人课表" onclick="location.href='hitCourse.jsp'">

    <%
        CourseService courseService = new CourseServiceImpl();
        // 1.获取总记录数
        int count = courseService.getTotalCount();

        String cPage = request.getParameter("currentPage");
        if (cPage == null)
            cPage = "1";

        int currentPage = Integer.parseInt(cPage);

        int pageSize = 10;

        List<Course> courseList = courseService.queryCourseByPage(currentPage, pageSize);

        int sumPage = count % pageSize == 0 ? count / pageSize : count
                % pageSize + 1;
        CoursePage cp = new CoursePage(currentPage, pageSize, courseList,
                count, sumPage);

        request.setAttribute("coursePage", cp);
    %>

    <table border="1">
        <tr>
            <td></td>
            <td><b>序号</b></td>
            <td><b>课程名称</b></td>
            <td><b>选课人数</b></td>
            <td><b>课程性质</b></td>
        </tr>

        <%
            // List<Course> courseList = new CourseDAOImpl().getCourse();
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

    <input type="button"
           onclick="window.location.href='allCourse.jsp?currentPage=1';"
           value="首页" />
    <input type="button"
           onclick="window.location.href='allCourse.jsp?currentPage=<%=cp.getCurrentPage() - 1%>';"
           value="上一页" />
    <input type="button"
           onclick="window.location.href='allCourse.jsp?currentPage=<%=cp.getCurrentPage() + 1%>';"
           value="下一页" />
    <input type="button"
           onclick="window.location.href='allCourse.jsp?currentPage=<%=cp.getSum()%>';"
           value="尾页" />
    &nbsp; <b>每页10条</b>
    &nbsp;<b>总页数：</b><%=count%>
    <br>
    <br>
    <input type="button" value="新增" onclick="window.location.href='addCourse.jsp'"/>
    <br>
    <input type="button" value="删除" onclick="window.location.href='delCourse.jsp'"/>
    <br>
    <input type="button" value="选课" onclick="window.location.href='chooseCourse.jsp'"/>
</div>
</body>
</html>
