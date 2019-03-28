package cn.edu.dhu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
    private static String url="jdbc:mysql://localhost:3306/web?serverTimezone=GMT%2B8&useSSL=false";
    private static String user="root";
    private static String password="root";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection= DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        if (null!=statement){
            statement.close();
        }
        if (null!=connection)
            connection.close();
    }
}

