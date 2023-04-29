package cn.edu.njust.controller;

import cn.edu.njust.pojo.Login;
import cn.edu.njust.service.LoginService;
import cn.edu.njust.service.impl.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/loginController")
public class LoginController extends HttpServlet {

    private final LoginService ls = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 1. 获取登录表单信息
        String name = request.getParameter("name");
        String password = request.getParameter("pwd");
        String checkCode = request.getParameter("safeCode");
        String school = request.getParameter("school");
        String department = request.getParameter("department");

        // 获取一个session，用于保存登录结果
        HttpSession session = request.getSession();
        if(checkCode != null && checkCode.equals("8774")){
            // 封装登录信息
            Login login = new Login(name,password,school,department);
            // 判断登录结果
            int result = ls.success(login);

            if(result == 0){
                session.setAttribute("status", "6");
                response.sendRedirect("main.jsp");
            }
            else{
                session.setAttribute("str", "失败原因"+ls.reason(result));
                response.sendRedirect("loginFailure.jsp");
            }
        }
        else{
            session.setAttribute("str", "验证码错误！");
            response.sendRedirect("loginFailure.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request, response);
    }
}
