package cn.edu.dhu;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Properties;


public class jdbc {
    private  String url="jdbc:mysql://localhost:3306/web";
    private String user="root";
    private String password="root";

    @Test
    public void test() throws ClassNotFoundException, SQLException {
        Driver driver=new com.mysql.cj.jdbc.Driver();
        Properties properties = new Properties();
        properties.setProperty("user",user);
        properties.setProperty("password",password);
        Connection connection=driver.connect(url,properties);
        System.out.println(connection);
    }
    @Test
    public void test2() throws ClassNotFoundException, SQLException {
        Driver driver=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);
        Connection connection=  DriverManager.getConnection(url,user,password);
        System.out.println(connection);
    }
    @Test
    public void test3() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection=  DriverManager.getConnection(url,user,password);
        Statement statement=connection.createStatement();
        String sql=" CREATE TABLE student(\n " +
                " id INT PRIMARY KEY AUTO_INCREMENT,\n " +
                " NAME VARBINARY(20),\n " +
                " gender VARBINARY(3)) ";
        int count=statement.executeUpdate(sql);
        System.out.println("影响了"+count+"行!");
        if (null!=statement){
            statement.close();
        }
        if (null!=connection)
            connection.close();
    }
    @Test
    public void test4() throws SQLException {

        Connection connection=JdbcUtil.getConnection();
        Statement statement=connection.createStatement();
        String sql="INSERT INTO student (NAME,gender) VALUE('王五','女')";
        int count=statement.executeUpdate(sql);
        System.out.println("影响了"+count+"行!");
        JdbcUtil.close(connection,statement);
    }
    @Test
    public void test5() throws SQLException, UnsupportedEncodingException {

        Connection connection=JdbcUtil.getConnection();
        Statement statement=connection.createStatement();
        String sql="SELECT * FROM student";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int id= resultSet.getInt("id");
            String name= new String(resultSet.getString("name").getBytes("ISO-8859-1"),"UTF-8");
            String gender=new String( resultSet.getString(3).getBytes("ISO-8859-1"),"UTF-8");
            System.out.println(id+","+name+","+gender);
        }
        JdbcUtil.close(connection,statement);
    }
}
