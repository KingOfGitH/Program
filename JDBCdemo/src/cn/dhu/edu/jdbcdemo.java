package cn.dhu.edu;

import java.sql.*;

public class jdbcdemo {
    private static final String DBDRIVE= "oracle.jdbc.driver.OracleDriver";
    private static final String DBURL= "jdbc:oracle:thin:@localhost:1521:ORCL";
    private static final String USER= "scott";
    private static final String PASSWORD= "tiger";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        String name ="我";
//        java.util.Date birthday=new Date();
//        int age=18;
//        String note="今年会赚大钱";
        String keyWord="张";
//        第一步加载数据库驱动程序，此时不需要实例化，因为会由容器自己负责管理
        Class.forName(DBDRIVE);
//        第二步连接数据库
        Connection conn= DriverManager.getConnection(DBURL,USER,PASSWORD);
        //System.out.println(conn);
//        第三步进行数据库的数据操作

        /**
         * 数据库更新操作
         */
////        Statement stmt =conn.createStatement();
////        在编写SQL的过程中，如果太长的时候需要增加换行，那么请一定要记住前后加上空格
////        String sql=" INSERT INTO member(mid,name,birthday,age,note) VALUES "
////                + " (myseq.nextval,'"+name+"',TO_DATE('"+birthday+"','yyyy-mm-dd'),' "
////                +age+" ',' "+note+" ') ";//变量里有单引号会出错
//        String sql=" INSERT INTO member(mid,name,birthday,age,note) VALUES "
//                + " (2,?,?,?,?) ";
//        PreparedStatement stmt=conn.prepareStatement(sql);
//        stmt.setString(1,name);
//        stmt.setDate(2,new java.sql.Date(birthday.getTime()) );
//        stmt.setInt(3,age);
//        stmt.setString(4,note);
//        System.out.println(sql);
//        int len=stmt.executeUpdate();//执行SQL返回更新数据行
//        System.out.println("影响的数据行："+len);
        /**
         * 数据库查询操作
         */
        String sql="SELECT mid,name,birthday,age,note FROM member where name like ?";
        PreparedStatement stmt=conn.prepareStatement(sql);
        stmt.setString(1,"%"+keyWord+"%");
        ResultSet rs=stmt.executeQuery();
        while (rs.next()){
            int mid=rs.getInt(1);
            String name=rs.getString(2);
            Date birthday=rs.getDate(3);
            int age=rs.getInt(4);
            String note=rs.getString(5);
            System.out.println(mid+","+name+","+birthday+","+age+","+note);
        }

//        关闭数据库
        stmt.close();//是可选的，并且无用的
        conn.close();
    }
}
