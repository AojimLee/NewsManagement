package dao;

import entity.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/8/1.
 */

//�޸�������Ϣ
public class AlterRecord {
    Record record = new Record();
    public void AlterRecord(Record record){
        //��������id�޸����ż�¼
        String sql = "update news set type = '" + record.getType() + "',title = '" + record.getTitle() +
                "',author = '" + record.getAuthor() + "',alterTime = '" + record.getAlterTime() +
                "' where id = " + record.getId();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
