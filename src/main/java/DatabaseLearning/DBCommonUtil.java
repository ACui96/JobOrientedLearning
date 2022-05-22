package DatabaseLearning;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Acui
 * @date 2022年05月22日 8:59
 */

public class DBCommonUtil {
    private String driverName;
    private String url;
    private String username;
    private String password;

    public DBCommonUtil() {
        Properties properties = new Properties();
        InputStream is = DBCommonUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
            driverName = properties.getProperty("driver");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Class.forName("driverName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(ResultSet rs, Statement stmt, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }


    public static void main(String[] args) throws SQLException {
        String sql = "select * from departments";
        String name = "dep";
        DBCommonUtil dbCommonUtil = new DBCommonUtil();
        ResultSet query = dbCommonUtil.query(sql);
        System.out.println(query.getInt(1));
    }

    private ResultSet query(String sql) throws SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
}
