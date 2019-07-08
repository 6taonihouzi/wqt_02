package zzgs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true"; // 数据库名字
    private static String userName = "root"; // 数据库用户名
    private static String passWord = "123"; // 数据库密码

     public  Connection getConnection() throws Exception {
         Class.forName("com.mysql.jdbc.Driver");//加载驱动
         Connection conn = DriverManager.getConnection(url,userName,passWord);//创建连接
         return conn;
     }
     public void closeConn(Connection conn)throws Exception{
         if(conn!=null){
             conn.close();
         }
     }
}
