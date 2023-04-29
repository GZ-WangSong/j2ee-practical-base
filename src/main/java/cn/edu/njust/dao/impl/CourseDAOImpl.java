package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.pojo.Course;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {
    public String url = "jdbc:mysql://localhost:3306/59_JDBC";
    public String username = "root";
    public String password = "root";
    public Connection con = null;

    @Override
    public Course readCourse() {
        Connection conn = null;
        Course course = new Course();
        try {
            // 加载注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建数据库连接
            conn = (Connection) DriverManager.getConnection(url, username,
                    password);

            // 创建createStatement
            Statement statement = (Statement) conn.createStatement();
            ResultSet rs = statement.executeQuery("Select * from course");

            // 遍历查询结果
            ArrayList<String> l1 = new ArrayList<>();
            ArrayList<String> l2 = new ArrayList<>();
            ArrayList<String> l3 = new ArrayList<>();
            ArrayList<String> l4 = new ArrayList<>();
            while (rs.next()) {
                l1.add(rs.getString("cId"));
                l2.add(rs.getString("cName"));
                l3.add(String.valueOf(rs.getInt("cNum")));
                l4.add(rs.getString("cType"));
            }
            // 将信息返回给course
            course.setcIdList(l1);
            course.setcNameList(l2);
            course.setcNumList(l3);
            course.setcTypeList(l4);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return course;
    }

    @Override
    public int deleteCourse(String[] s) {
        Connection conn = null;
        int ret = 0;
        try {
            // 加载注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 创建数据库连接
            conn = (Connection) DriverManager.getConnection(url, username,
                    password);

            // 创建createStatement
            Statement statement = (Statement) conn.createStatement();

            for (int i = 0; i < s.length; i++) {
                String sql = "delete from course where cName='" + s[i] + "'";// 生成一条sql语句
                int num = statement.executeUpdate(sql);// 执行sql语句
                if (ret == 0) ret = num;
            }
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ret;
    }
}
