package cn.edu.njust.controller;
/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 9:37
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 先获取一个 ServletConfig
        ServletConfig servletConfig = this.getServletConfig();
        // 2. 获取 ServletConfig 初始化参数
        String studentNo = servletConfig.getInitParameter("student_no");
        String name = servletConfig.getInitParameter("name");

        // 3. 获取
        String course = this.getServletContext().getInitParameter("course");

        // 4. 构造返回值
        String res = "我是学号为" + studentNo + "的" + name + "同学,<br>" +
                "这是从"+ course+ "中学习到的一个简单servlet程序";

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(res);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
