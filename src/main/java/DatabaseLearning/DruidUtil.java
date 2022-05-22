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
 * @date 2022年05月22日 11:15
 */
public class DruidUtil {
    private static DataSource dataSource;

    static {
        // 利用反射机制加载数据库配置文件， 放到 properties 中
        InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        // 继承 Hashtable, 线程安全的 map
        Properties properties = new Properties();
        try {
            properties.load(is);
            // 利用 DruidDataSourceFactory 创建数据源
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池
     * @author Acui
     * @date 2022/5/22 11:19
     * @return javax.sql.DataSource
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接池中的一个连接
     * @author Acui
     * @date 2022/5/22 11:21
     * @return java.sql.Connection
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭数据库资源
     * @author Acui
     * @date 2022/5/22 14:47
     * @param conn  与特定数据库的连接（会话）
     * @param res   表示数据库结果集的数据表
     * @param pstmt 预编译 SQL 语句的对象
     */
    public static void release(Connection conn, ResultSet res, PreparedStatement pstmt) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (res != null) {
                res.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
