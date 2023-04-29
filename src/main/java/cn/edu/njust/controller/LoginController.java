package cn.edu.njust.controller; /**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 11:23
 * @Description:
 */

import cn.edu.njust.service.LoginService;
import cn.edu.njust.service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

// 为了简化使用，从此次作业开始，不再配置 xml 文件，直接使用注解
@WebServlet(name = "LoginController", value = "/loginController")
public class LoginController extends HttpServlet {
    private LoginService ls = new LoginServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        String safeCode = request.getParameter("safeCode");

        if (ls.checkEmpty(name, password, safeCode)) {
            response.sendRedirect("loginFailure.jsp");
        } else {
            if(ls.checkSafeCode(safeCode)) response.sendRedirect("main.jsp");
            else response.sendRedirect("loginFailure.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 先设置流编码格式，防止乱码
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
