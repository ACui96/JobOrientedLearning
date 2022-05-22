package DatabaseLearning;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Acui
 * @date 2022年05月22日 10:04
 */
public class DBUtils {
    public static Connection getConnection() throws Exception {
        // 利用反射机制加载数据库配置文件， 放到 properties 中
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        // 继承 Hashtable, 线程安全的 map
        Properties properties = new Properties();
        properties.load(is);
        // 利用 DruidDataSourceFactory 创建数据源
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private ResultSet query(String sql) throws Exception {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    public static void main(String[] args) throws Exception {
        String sql = "select * from dept";
        String name = "dep";
        DBUtils dbUtils = new DBUtils();
        ResultSet query = dbUtils.query(sql);
        System.out.println(query);
    }
}
