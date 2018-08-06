package dao;

import entity.Record;
import util.GetTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/3.
 */
public class EditorStep1 {
    public Record EditorStep1(String id){
        Record record = new Record();
        GetTime getTime = new GetTime();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            String sql = "select * from news where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet rs =pstmt.executeQuery();
            while(rs.next()){
                record.setContent(rs.getString("content"));
                record.setAuthor(rs.getString("author"));
                record.setTime(rs.getString("time"));
                record.setTitle(rs.getString("title"));
                record.setId(rs.getInt("id"));
                record.setType(rs.getString("type"));
                record.setAlterTime(getTime.GetTime());
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return record;
    }
}
