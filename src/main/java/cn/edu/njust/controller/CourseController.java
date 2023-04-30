package cn.edu.njust.controller;

import cn.edu.njust.pojo.Course;
import cn.edu.njust.service.CourseService;
import cn.edu.njust.service.impl.CourseServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CourseController", value = "/courseController")
public class CourseController extends HttpServlet {
    private final CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取操作符
        String operation = request.getParameter("operation");

        // 添加课程
        if ("add".equals(operation)){
            String cId = request.getParameter("cId");
            String cName = request.getParameter("cName");
            String cNum = request.getParameter("cNum");
            String cType = request.getParameter("cType");

            if (cId.isEmpty() || cName.isEmpty() || cNum.isEmpty()
                    || cType.isEmpty()) {
                response.sendRedirect("courseFailure.jsp");
            } else {
                Course course = new Course(cId, cName, Integer.parseInt(cNum), cType);
                int check = courseService.addCourse(course);
                if (check > 0)
                    response.sendRedirect("allCourse.jsp");
                else
                    response.sendRedirect("courseFailure.jsp");
            }
        }
        // 删除课程
        if ("del".equals(operation)) {
            String[] s = request.getParameterValues("flag");
            if (s != null) {
                int check = courseService.deleteCourse(s);
                if (check > 0)
                    response.sendRedirect("allCourse.jsp");
                else
                    response.sendRedirect("courseFailure.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
