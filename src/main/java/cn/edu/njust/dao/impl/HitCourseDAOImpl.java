package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.HitCourseDAO;
import cn.edu.njust.pojo.HitCourse;
import cn.edu.njust.pojo.Login;
import cn.edu.njust.util.JDBCUtils;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * -*- coding: UTF-8 -*-
 *
 * @author GZ_WangSong
 * @date 2023/4/30
 */
public class HitCourseDAOImpl implements HitCourseDAO {
    @Override
    public List<HitCourse> getHitCourse(Login login) {
        List<HitCourse> hitList = new ArrayList<>();
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();
            Statement stmt = (Statement) conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM hit_course,course WHERE hit_course.cId=course.cId;");

            // 遍历查询结果
            while (rs.next()) {
                HitCourse hitCourse = new HitCourse(rs.getInt("uId"), login.getName(), rs.getString("cId"), rs.getString("cName"), rs.getDouble("score"));
                hitList.add(hitCourse);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hitList;
    }

    @Override
    public int withdrawalChoose(String[] ids) {
        int ret = 0;
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();
            Statement stmt = (Statement) conn.createStatement();

            for (String id : ids) {
                // 生成一条SQL删除语句
                String sql1 = "delete from hit_course where cId='" + id + "'";
                // 更新course中cNum
                String sql2 = "update course set cNum=cNum-1 where cId='" + id + "'";
                // 执行SQL语句
                int num = stmt.executeUpdate(sql1);
                stmt.executeUpdate(sql2);

                if (ret == 0) ret = num;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public int chooseCourse(String[] cId, int id) {
        int ret = 0;
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();
            /*
             * stmt用来更新总表中的选课人数
             * */
            Statement stmt = (Statement) conn.createStatement();
            // 数据库操作语句（插入）
            String sql = "insert into hit_course values(?,?,?)";

            PreparedStatement pst = conn.prepareStatement(sql);
            for (String s : cId) {
                pst.setInt(1, id);
                pst.setString(2, s);
                pst.setInt(3, 0);
                // 更新总表选课人数
                String sql2 = "update course set cNum=cNum+1 where cId='" + s + "'";
                stmt.executeUpdate(sql2);
            }
            ret = pst.executeUpdate();

            pst.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
