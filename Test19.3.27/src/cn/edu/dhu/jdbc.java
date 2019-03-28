package cn.edu.dhu;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
    @Test
    public void test() throws SQLException, UnsupportedEncodingException {
        Connection connection = JdbcUtil.getConnection();
        Statement statement=connection.createStatement();
        String sql="select * from student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String gender=new String(resultSet.getString(3).getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(gender);
            System.out.println("女".equals(gender));
            System.out.println("女"==gender);
        }
        JdbcUtil.close(connection,statement);
    }
}
