package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.UserDAO;
import cn.edu.njust.pojo.Login;
import cn.edu.njust.util.DBConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 11:29
 * @Description:
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public Login queryByCondition(Login login) {
        try {
            // 1.加载注册jdbc驱动
            Class.forName(DBConfig.DRIVER);

            // 2.创建数据库连接
            Connection conn = (Connection) DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);

            // 3.使用PreparedStatement操作数据库
            String sql = "SELECT * FROM user WHERE uName = ? and uPw = ? and uSchool = ? and uDepartment = ?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);
            // 3.1 设置参数占位符
            pst.setString(1, login.getName());
            pst.setString(2, login.getPassword());
            pst.setString(3, login.getSchool());
            pst.setString(4, login.getDepartment());

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                login.setId(resultSet.getInt("uId"));
            } else {
                login = null;
            }

            // 5.关闭资源
            resultSet.close();
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
