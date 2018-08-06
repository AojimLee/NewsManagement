package util;

import dao.ConnectDatebase;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/7/31.
 */
//用户登陆，根据输入的email获取用户姓名
public class Login {
    public boolean Login(String email, String password) {
        boolean test = false;
        User user = new User();
        //链接数据库
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            String sql = "select * from users where email = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                user.setPassword(rs.getString("password"));
                test = user.getPassword().equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

    public String getName(String email){
        User user = new User();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;

        try {
            con = conn.ConnectDatebase();
            String sql = ("select name from users where email ='" + email +"'");
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                user.setName(rs.getString("name"));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return user.getName();
    }
}
