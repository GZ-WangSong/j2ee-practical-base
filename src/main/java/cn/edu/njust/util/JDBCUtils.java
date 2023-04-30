package cn.edu.njust.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("/db.properties");
            Properties properties = new Properties();

            if (is != null) {
                properties.load(is);
                System.out.println("JDBC UTIL");
                driver = properties.getProperty("driver");
                url = properties.getProperty("url");
                username = properties.getProperty("username");
                password = properties.getProperty("password");
            } else {
                driver = "com.mysql.jdbc.Driver";
                url = "jdbc:mysql://localhost:3306/59_JDBC?useUnicode=true&characterEncoding=utf-8";
                username = "root";
                password = "root";
            }
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
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
