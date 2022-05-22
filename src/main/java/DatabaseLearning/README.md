# 数据库连接工具类

## 利用 Druid 数据库连接池连接数据库

Druid是阿里开源的数据库连接池，作为后起之秀，性能比dbcp、c3p0更高，使用也越来越广泛。Druid不仅是一个数据库连接池，还包含一个ProxyDriver、一系列内置的JDBC组件库、一个SQL Parser。支持所有JDBC兼容的数据库，包括Oracle、MySql、Derby、Postgresql、SQL Server、H2等。

druid的优点：

1. **高性能**。性能比dbcp、c3p0高很多。
2. 只要是jdbc支持的数据库，druid都支持，对数据库的**支持性好**。并且Druid针对oracle、mysql做了特别优化。
3. 提供**监控功能**。可以监控sql语句的执行时间、ResultSet持有时间、返回行数、更新行数、错误次数、错误堆栈等信息，来了解连接池、sql语句的工作情况，方便统计、分析SQL的执行性能

### pom.xml

```xml
<!--阿里Druid数据库连接池-->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.24</version>
</dependency>
<!--MySQL驱动-->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.23</version>
</dependency>
```

### druid.properties

```properties
# 放在 resources 下， mark direction as source root 才能访问到

url=jdbc:mysql://localhost:3306/test
#这个可以缺省的，会根据url自动识别
driverClassName=com.mysql.jdbc.Driver
username=root
password=root
 
##初始连接数，默认0
initialSize=10
#最大连接数，默认8
maxActive=30
#最小闲置数
minIdle=10
#获取连接的最大等待时间，单位毫秒
maxWait=2000
#缓存PreparedStatement，默认false
poolPreparedStatements=true
#缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句设置
maxOpenPreparedStatements=20
```

### DruidUtil.java

```java
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

```

### DruidTest.java

```java
public class DruidTest {
    @Test
    public void utilTest() throws SQLException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        DruidUtil druidUtil = new DruidUtil();
        try {
            connection = druidUtil.getConnection();
            String sql = "select * from emp";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                System.out.println(id + "\t" + ename);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            druidUtil.release(connection, resultSet,preparedStatement);
        }
    }
}

```

结果

```shell
五月 22, 2022 3:04:00 下午 com.alibaba.druid.pool.DruidDataSource info
信息: {dataSource-1} inited
7369	SIMITH
7499	ALLEN
7521	WARD
```

