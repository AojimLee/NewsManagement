package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/7/29.
 */
public class ConnectDatebase {
    Connection con;

    public  Connection ConnectDatebase() throws SQLException {
        try {
            //加载MySql的驱动类
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/nms?serverTimezone=UTC";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("找不到驱动程序类 ，加载驱动失败！");
            e.printStackTrace();
        }
        if(con==null){
            System.out.println("数据库连接失败");
        }
        else{
            System.out.println("数据库连接成功");
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
       new ConnectDatebase().ConnectDatebase();
    }

}
