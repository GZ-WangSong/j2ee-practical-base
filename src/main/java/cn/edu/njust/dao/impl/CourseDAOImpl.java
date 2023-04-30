package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.pojo.Course;
import cn.edu.njust.util.DBConfig;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public List<Course> getCourse() {

        List<Course> courseList = new ArrayList<>();
        try {
            // 1.加载注册JDBC驱动
            Class.forName(DBConfig.DRIVER);

            // 2.创建数据库连接
            Connection conn = (Connection) DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);

            // 3.创建createStatement

            Statement statement = (Statement) conn.createStatement();
            // 4.String sql = "Select * from course";
            ResultSet rs = statement.executeQuery("Select * from course");

            // 5.遍历查询结果
            while (rs.next()) {
                // 5.1 获取一条记录
                String id = rs.getString("cId");
                String name = rs.getString("cName");
                int num = rs.getInt("cNum");
                String type = rs.getString("cType");
                // 5.2 构建实例
                Course course = new Course(id, name, num, type);
                // 5.3 封装结果
                courseList.add(course);
            }

            // 6.关闭资源
            rs.close();
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public int addCourse(Course course) {
        int ret = 0;
        try {
            // 1.加载注册JDBC驱动
            Class.forName(DBConfig.DRIVER);

            // 2.创建数据库连接
            Connection conn = (Connection) DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);

            // 3.拼接数据库操作语句（插入）
            String sql = "insert into course values(?,?,?,?)";
            // 4.使用PreparedStatement执行SQL语句查询，对sql语句进行预编译处理
            PreparedStatement pst = conn.prepareStatement(sql);
            // 4.1 设置参数占位符
            pst.setString(1, course.getCourseId());
            pst.setString(2, course.getCourseName());
            pst.setInt(3, course.getCourseNum());
            pst.setString(4, course.getCourseType());
            // 4.2 执行语句
            ret = pst.executeUpdate();

            // 5.关闭资源
            pst.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int deleteCourse(String[] s) {
        int ret = 0;
        try {
            // 1.加载注册JDBC驱动
            Class.forName(DBConfig.DRIVER);

            // 2.创建数据库连接
            Connection conn = (Connection) DriverManager.getConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD);

            // 3.创建createStatement
            Statement statement = (Statement) conn.createStatement();

            for (String value : s) {
                // 拼接 SQL 语句
                String sql = "delete from course where cName='" + value + "'";
                // 执行 update 方法
                int num = statement.executeUpdate(sql);
                if (ret == 0) ret = num;
            }
            // 关闭资源
            statement.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
