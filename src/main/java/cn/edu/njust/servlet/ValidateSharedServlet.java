package cn.edu.njust.servlet; /**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 10:26
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class ValidateSharedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取一个 ServletContext 对象
        ServletContext servletContext = this.getServletContext();
        // 2. 获取其它Servlet绑定的参数
        Object contextValue = servletContext.getAttribute("contextValue");
        // 3. 获取使用 session 绑定的参数
        Object sessionValue = request.getSession().getAttribute("sessionValue");

        String res = "contextValue = " + contextValue + "\n" +
                "sessionValue = " + sessionValue;

        response.getWriter().write(res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
