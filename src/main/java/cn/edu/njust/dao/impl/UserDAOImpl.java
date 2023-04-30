package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.UserDAO;
import cn.edu.njust.pojo.Login;
import cn.edu.njust.util.DBConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

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
    public int queryByName(Login login) {
        int result = 1;//用户不存在
        try {
            // 1.加载注册jdbc驱动
            Class.forName(DBConfig.DRIVER);

            // 2.创建数据库连接
            Connection conn = (Connection) DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);

            // 3.创建createStatement
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from user");

            // 4.遍历查询结果
            while (rs.next()) {
                String uName = rs.getString("uName");
                String uPw = rs.getString("uPw");
                String uSchool = rs.getString("uSchool");
                String uDepartment = rs.getString("uDepartment");
                // 对比数据库信息，层层递进的检验
                if (login.getName().equals(uName)) {
                    result = 2;
                    if (login.getPassword().equals(uPw)) {
                        result = 4;
                        if (login.getSchool().equals(uSchool)) {
                            result = 5;
                            if (login.getDepartment().equals(uDepartment))
                                result = 0;//最终若是相等，则返回0
                        }
                    }
                }
            }

            // 5.关闭资源
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
