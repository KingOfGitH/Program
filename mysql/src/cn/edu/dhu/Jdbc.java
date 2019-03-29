package cn.edu.dhu;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class Jdbc {
    private String url = "jdbc:mysql://localhost:3306/web";
    private String user = "root";
    private String password = "root";

    /**
     * 普通方式
     * @throws SQLException
     */
    @Test
    public void test() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        Properties properties = new Properties();
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        Connection connection = driver.connect(url, properties);
        System.out.println(connection);
    }

    /**
     * 注册
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = " CREATE TABLE student(\n " +
                " id INT PRIMARY KEY AUTO_INCREMENT,\n " +
                " NAME VARBINARY(20),\n " +
                " gender VARBINARY(3)) ";
        int count = statement.executeUpdate(sql);
        System.out.println("影响了" + count + "行!");
        if (null != statement) {
            statement.close();
        }
        if (null != connection)
            connection.close();
    }

    @Test
    public void test4() throws SQLException {

        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO student (NAME,gender) VALUE('王五','女')";
        int count = statement.executeUpdate(sql);
        System.out.println("影响了" + count + "行!");
        JdbcUtil.close(connection, statement);
    }

    @Test
    public void test5() throws SQLException, UnsupportedEncodingException {

        Connection connection = JdbcUtil.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = new String(resultSet.getString("name").getBytes("ISO-8859-1"), "UTF-8");
            String gender = new String(resultSet.getString(3).getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(id + "," + name + "," + gender);
        }
        JdbcUtil.close(connection, statement);
    }

    @Test
    public void test6() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test7() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM student where id=?";
        QueryRunner queryRunner = new QueryRunner();
        Student student = queryRunner.query(connection, sql, new BeanHandler<Student>(Student.class), 2);
        System.out.println(student);
        connection.close();
    }

    @Test
    public void test8() throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM student where id=?";
        QueryRunner queryRunner = new QueryRunner();
        Student student = queryRunner.query(connection, sql, new ResultSetHandler<Student>() {
                    @Override
                    public Student handle(ResultSet resultSet) throws SQLException {
                        if (resultSet.next()) {
                            Student student1 = new Student();
                            student1.setId(resultSet.getInt(1));
                            student1.setName(resultSet.getString(2));
                            student1.setGender(resultSet.getString(3));
                            return student1;
                        }
                        return null;
                    }
                },
                2);
        System.out.println(student);
        connection.close();
    }

    @Test
    public void test9() throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = Jdbc.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        String sql = "SELECT * FROM student";
        QueryRunner queryRunner = new QueryRunner();
        List<Student> list = queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class));
        System.out.println(list);
        connection.close();
    }

    /**
     * 分页显示
     * @throws Exception
     */
    @Test
    public void test10() throws Exception {
        Properties properties = new Properties();
        InputStream resourceAsStream = Jdbc.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement=null;
        for (int i = 0; i < 11; i++) {
            String sql = "SELECT * FROM student";
            preparedStatement=connection.prepareStatement(sql);
        }
        String sql = "SELECT * FROM student";
        QueryRunner queryRunner = new QueryRunner();
        List<Student> list = queryRunner.query(connection, sql, new BeanListHandler<Student>(Student.class));
        System.out.println(list);
        connection.close();
    }
}
