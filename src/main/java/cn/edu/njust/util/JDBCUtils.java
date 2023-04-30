package cn.edu.njust.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    private static Connection con;

    /*
     * 加载配置文件
     */
    static {
        try {
            // 1.通过输入流拿到配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("/db.properties");
            Properties properties = new Properties();
            // 2.使用流加载配置文件
            properties.load(inputStream);

            // 通过 getProperty 方法，传入键，获取值
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接对象
     *
     * @return 返回一个 Connection 对象
     */
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void release(Connection connection,
                               Statement statement, ResultSet resultSet, PreparedStatement ps) {
        try {
            if (resultSet != null) resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (statement != null) statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
