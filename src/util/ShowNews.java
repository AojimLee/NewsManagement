package util;

import dao.ConnectDatebase;
import entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/8/2.
 */

//ҳ���߼����˷��������б���ʾ���ţ��ڵ�������ģ����ѯʱ������ô˷���
//������Ҫ���������Ϣ����list����ǰ̨��ǰ̨��ȡtitle������ʱ�������ʾ������sql���
public class ShowNews {
    public List ShowNews(String sql){

        List<Record> list = new ArrayList<Record>();
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
