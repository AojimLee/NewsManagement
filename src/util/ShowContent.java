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
//���չ�����ž������ݣ�ͨ�����ı��༭�������ŵ����ݾ����ʽhtml�������ַ�����ʽ�������ݿ�
//ͨ��ǰ̨���ص�ʶ����������ݿ���������,����   idʶ����  ����  һ��record
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
