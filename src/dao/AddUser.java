package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/1.
 */
public class AddUser {
    public void AddUser(String name,String password,String phone,String email){
        String sql = "Insert into users values ('" +
                email+"','" + name + "','" + password +"','" + phone + "')";

        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            //根据新闻id删除该纪录
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
