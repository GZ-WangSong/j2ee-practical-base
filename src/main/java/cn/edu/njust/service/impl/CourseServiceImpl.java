package cn.edu.njust.service.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.dao.impl.CourseDAOImpl;
import cn.edu.njust.pojo.Course;
import cn.edu.njust.service.CourseService;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CourseServiceImpl implements CourseService {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/59_JDBC";
    private String username = "root";
    private String password = "root";
    private Connection con = null;

    public int addCourse(Course course) {
        Connection conn = null;
        int ret = 0;
        try {
            // 1.加载注册JDBC驱动
            Class.forName(driver);

            // 2.创建数据库连接
            conn = (Connection) DriverManager.getConnection(url, username,
                    password);

            // 3.创建createStatement
            Statement statement = (Statement) conn.createStatement();
            String sql = "insert into course values(?,?,?,?)";//数据库操作语句（插入）
            PreparedStatement pst = conn.prepareStatement(sql);//用来执行SQL语句查询，对sql语句进行预编译处理
            pst.setString(1, course.getcId());
            pst.setString(2, course.getcName());
            pst.setInt(3, course.getcNum());
            pst.setString(4, course.getcType());
            ret = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed())
                    conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ret;
    }

    public int deleteCourse(String[] s) {
        CourseDAO c = new CourseDAOImpl();
        return c.deleteCourse(s);
    }
}
