package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.CourseDAO;
import cn.edu.njust.mapping.CourseMapping;
import cn.edu.njust.pojo.Course;
import cn.edu.njust.util.JDBCUtils;
import com.mysql.jdbc.Connection;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.util.ArrayList;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    /**
     * 获取所有课程
     *
     * @return 返回课程列表
     */
    @Override
    public List<Course> getCourse() {

        List<Course> courseList = new ArrayList<>();
        try {
            // 1.通过工具类获取一个 Connection
            Connection con = (Connection) JDBCUtils.getConnection();
            // 2.拼些SQL语句
            String sql = "Select * from course";
            // 3.调用
            courseList = QUERY_RUNNER.query(con, sql, new BeanListHandler<>(Course.class, CourseMapping.getProcessor()));

            // 4.关闭资源
            DbUtils.closeQuietly(con);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    /**
     * 添加一门课程
     *
     * @param course 课程实体
     * @return 影响行数
     */
    @Override
    public int addCourse(Course course) {
        int ret = 0;
        try {
            // 1.创建数据库连接
            Connection conn = (Connection) JDBCUtils.getConnection();
            // 2.拼接数据库操作语句（插入）
            String sql = "insert into course values(?,?,?,?)";
            // 3.封装占位参数
            Object[] params = {course.getCourseId(), course.getCourseName(),
                    course.getCourseNum(), course.getCourseType()};
            // 4.执行操作
            ret = QUERY_RUNNER.update(conn, sql, params);

            // 5.关闭资源
            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 删除课程
     *
     * @param s 待删除的课程集合
     * @return 影响行数
     */
    @Override
    public int deleteCourse(String[] s) {
        int ret = 0;
        try {
            // 1.创建数据库连接
            Connection conn = (Connection) JDBCUtils.getConnection();
            // 2.
            for (String value : s) {
                // 拼接 SQL 语句
                String sql = "delete from course where cName = ?";
                int update = QUERY_RUNNER.update(conn, sql, value);
                if (ret == 0) ret = update;
            }
            // 关闭资源
            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 查询数据总数
     *
     * @return 总数
     */
    @Override
    public int getTotalCount() {
        // 1.获取数据库连接
        Connection coon = (Connection) JDBCUtils.getConnection();
        // 2.SQL语句
        String sql = "select count(*) from Course";
        int count = -1;
        try {
            count = QUERY_RUNNER.query(coon, sql, new ScalarHandler<Integer>(1));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(coon);
        }
        return count;
    }

    @Override
    public List<Course> queryCourseByPage(int currentPage, int pageSize) {
        Connection conn = (Connection) JDBCUtils.getConnection();
        List<Course> arrayList = new ArrayList<>();
        try {
            String sql = "select * from Course limit ?,?";
            Object[] params = {(currentPage - 1) * pageSize, pageSize};

            arrayList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(Course.class,CourseMapping.getProcessor()), params);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return arrayList;
    }


}
