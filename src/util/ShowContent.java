package util;

import dao.ConnectDatebase;
import entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/2.
 */
//点击展现新闻具体内容，通过富文本编辑器将新闻的内容具体格式html代码以字符串形式存在数据库
//通过前台传回的识别码调用数据库文章内容,传入   id识别码  传出  一条record
public class ShowContent {
    public Record ShowContent(String id){
        Record record = new Record();

        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            String sql = "select * from news where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                record.setId(rs.getInt("id"));
                record.setAuthor(rs.getString("author"));
                record.setType(rs.getString("type"));
                record.setTime(rs.getString("time"));
                record.setContent(rs.getString("content"));
                record.setAlterTime(rs.getString("alterTime"));
                record.setTitle(rs.getString("title"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }
}
