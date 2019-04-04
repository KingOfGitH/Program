package cn.edu.dhu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * druid连接池
 */
public class JDBCUtils {
    private static DataSource dataSource;

    static {
        try {
            Properties properties=new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream(
                    "druid.properties"));
            dataSource=DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("JDBCUtils.static");
        }
    }
    /**
     * 连接池对象
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
