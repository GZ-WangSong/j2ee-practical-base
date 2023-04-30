package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.HitCourseDAO;
import cn.edu.njust.pojo.HitCourse;
import cn.edu.njust.pojo.Login;
import cn.edu.njust.util.DBConfig;
import cn.edu.njust.util.JDBCUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * -*- coding: UTF-8 -*-
 *
 * @author GZ_WangSong
 * @date 2023/4/30
 */
public class HitCourseDAOImpl implements HitCourseDAO {

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    /**
     * 查询登录用户的所有课程
     *
     * @param login 登录用户
     * @return 课程列表
     */
    @Override
    public List<HitCourse> getHitCourse(Login login) {
        List<HitCourse> hitList = new ArrayList<>();
        try {

            Connection conn = (Connection) JDBCUtils.getConnection();
            // 构建多表查询SQL语句
            String sql = "SELECT * FROM hit_course,course WHERE hit_course.cId=course.cId";
            hitList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(HitCourse.class));

            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return hitList;
    }

    /**
     * 退选课程
     *
     * @param ids 退选课程的ID
     * @return 影响行数
     */
    @Override
    public int withdrawalChoose(String[] ids) {
        int ret = 0;
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();

            for (String id : ids) {
                // 生成一条SQL删除语句
                String sql1 = "delete from hit_course where cId= ? ";
                // 更新course中cNum
                String sql2 = "update course set cNum=cNum-1 where cId= ? ";
                // 执行SQL语句
                int update = QUERY_RUNNER.update(conn, sql1, id);
                QUERY_RUNNER.update(conn, sql2, id);

                if (ret == 0) ret = update;
            }

            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 选择课程
     *
     * @param cId 课程ID
     * @param id  　用户ID
     * @return 影响行数
     */
    @Override
    public int chooseCourse(String[] cId, int id) {
        int ret = 0;
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();

            String sql = "insert into hit_course values(?,?,?)";


            PreparedStatement pst = conn.prepareStatement(sql);
            for (String s : cId) {
                Object[] params = {id, s, 0};
                int update = QUERY_RUNNER.update(conn, sql, params);
                // 更新总表选课人数
                String sql2 = "update course set cNum=cNum+1 where cId= ?";
                QUERY_RUNNER.update(conn, sql2, s);
                if (ret == 0) ret = update;
            }
            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
