package cn.edu.dhu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    private static String url=null;
    private static String user=null;
    private static String password=null;
    private static String driverClass=null;
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream=JdbcUtil.class.getResourceAsStream(
                    "/cn/edu/dhu/r_temp.properties");
            properties.load(inputStream);
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            driverClass=properties.getProperty("driverClass");
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
