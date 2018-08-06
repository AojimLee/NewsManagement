package dao;

import util.GetTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/3.
 */
public class EditorStep2 {
    public void EditorStep2(String id,String content,String author,String title,String type){
        GetTime getTime = new GetTime();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;

        System.out.println("*********" + id+author+title);

        String time = getTime.GetTime();
        try {
            con = conn.ConnectDatebase();
            String sql = "update news set content ='" + content + "',type = '"+type +
                    "', author = '"+author+"',title = '" + title+"',alterTime = '"+
                    time +"' where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
