import DatabaseLearning.DruidUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Acui
 * @date 2022年05月22日 14:51
 */
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
