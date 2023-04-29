package cn.edu.njust.controller;
/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 10:23
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

public class SharedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取一个 ServletContext 对象
        ServletContext servletContext = this.getServletContext();
        // 2. 获取参数 id
        String id = servletContext.getInitParameter("id");
        // 3. 设置绑定参数
        int value = Integer.parseInt(id);
        servletContext.setAttribute("contextValue", value + 1);
        request.getSession().setAttribute("sessionValue", value + 2);

        // 4. 构造一个字符串，方便观察情况
        String res = "这是SharedServlet：\n" +
                "id = " + id + "\n" +
                "contextValue = " + (value + 1) + "\n" +
                "sessionValue = " + (value + 2);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(res);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
