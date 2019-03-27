package cn.edu.dhu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    @Test
    public void test() throws SQLException {
        Connection connection = JdbcUtil.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String gender=resultSet.getString("gender");
            System.out.println("女"==gender);
        }
        JdbcUtil.close(connection,statement);
    }
}
