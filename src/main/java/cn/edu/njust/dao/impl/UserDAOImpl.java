package cn.edu.njust.dao.impl;

import cn.edu.njust.dao.UserDAO;
import cn.edu.njust.mapping.LoginMapping;
import cn.edu.njust.pojo.Login;
import cn.edu.njust.util.JDBCUtils;
import com.mysql.jdbc.Connection;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * -*- coding: UTF-8 -*-
 *
 * @IDE: IntelliJ IDEA
 * @Author: GZ-WangSong
 * @Date: 2023/4/29 11:29
 * @Description:
 */
public class UserDAOImpl implements UserDAO {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    /**
     * 查询登录用户是否存在
     *
     * @param login 登录表单信息
     * @return 查询到的对象
     */
    @Override
    public Login queryByCondition(Login login) {
        try {
            Connection conn = (Connection) JDBCUtils.getConnection();

            String sql = "SELECT * FROM user WHERE uName = ? and uPw = ? and uSchool = ? and uDepartment = ?";
            Object[] params = {login.getName(), login.getPassword(), login.getSchool(), login.getDepartment()};
            login = QUERY_RUNNER.query(conn, sql, new BeanHandler<>(Login.class, LoginMapping.getProcessor()), params);

            DbUtils.closeQuietly(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return login;
    }
}
