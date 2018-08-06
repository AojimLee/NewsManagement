package util;

import dao.ConnectDatebase;
import entity.Page;
import entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by MSI on 2018/7/29.
 */
public class ShowPage {
    Page p = new Page();
    public List ShowPage(int currentpage){
        //查询语句，根据当前记录页数查询
        String sql = "select * from news limit " + (currentpage-1) *10+  "," + p.pageSize;
        List<Record> list = new ArrayList<Record>();//使用list存取记录
        //链接数据库
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            PreparedStatement pstmt =con.prepareStatement(sql);
            ResultSet rs =pstmt.executeQuery();

            while(rs.next()){
                Record record =new Record();
                record.setId(rs.getInt("id"));
                record.setAuthor(rs.getString("author"));
                record.setType(rs.getString("type"));
                record.setTime(rs.getString("time"));
                record.setContent(rs.getString("content"));
                record.setAlterTime(rs.getString("alterTime"));
                record.setTitle(rs.getString("title"));
                list.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
