package util;

import dao.ConnectDatebase;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/2.
 */
//管理员登陆，与用户登陆模式基本一致  `
public class ManagerLogin {
    public boolean ManagerLogin(String email,String password){
        boolean init = false;

        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            String sql = "select * from manager where email = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,email);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                init = (rs.getString("password")).equals(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return init;
    }

    public String GetName(String email){
        String name = null;
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            String sql = ("select name from manager where email = " + email);
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            name = rs.getString("name");
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return name;
    }
}
