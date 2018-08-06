package dao;

import entity.Record;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by MSI on 2018/7/31.
 */
public class AddRecord {
    Record record = new Record();

    //�������ߡ��������͡���������
    public void  AddRecord(String author,String type,String content,String title){

        AddRecord addRecord = new AddRecord();

        //���÷�����ȡ������źʹ���ʱ��
        record.setId(addRecord.GetRecordId());
        record.setTime(addRecord.GetRecordTime());
        record.setTitle(title);
        record.setAlterTime(record.getTime());//�½�����ʱ�޸�ʱ���봴��ʱ��һ��

        //���½�recordȫ�����ݲ������ݿ�
        String sql = ("Insert into news values (" +
                record.getId() + ",'" + type +"','" + author + "','" +
                record.getTime() + "','"  + content + "','" + record.getAlterTime() + "','" +
                record.getTitle() +"')");
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
//�������ݿ���������µ���ţ������һ���½����µ����
//����֮������bug   ���Բ�����  �ܹ���ֵ   �ܹ���ȡ�����   ���Ǿ��Ǳ���û������    ���Ǹĳ����ܼ�¼
// ��+1����������ʽ�е㲻��
    public int GetRecordId(){
        int id = 0;

        String sql = "select count(*) from news";
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            PreparedStatement pstmt =con.prepareStatement(sql);
            ResultSet rs =pstmt.executeQuery();

            while(rs.next()){
                id = rs.getInt("id")+1;
            }

//            id = rs.getInt("id") + 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
//��ȡ��ǰʱ��
    public String GetRecordTime(){
        //�޸�ʱ�������ʽ
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record.setTime(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
        return record.getTime();
    }
}
