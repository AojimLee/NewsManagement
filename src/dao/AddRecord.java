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

    //传入作者、文章类型、文章内容
    public void  AddRecord(String author,String type,String content,String title){

        AddRecord addRecord = new AddRecord();

        //调用方法获取文章序号和传入时间
        record.setId(addRecord.GetRecordId());
        record.setTime(addRecord.GetRecordTime());
        record.setTitle(title);
        record.setAlterTime(record.getTime());//新建文章时修改时间与创建时间一致

        //将新建record全部数据插入数据库
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
//访问数据库中最大文章的序号，将其加一问新建文章的序号
//编译之后发现有bug   调试不出来  能够传值   能够获取最大数   但是就是报错没法创建    于是改成了总记录
// 数+1，这个解决方式有点不妥
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
//获取当前时间
    public String GetRecordTime(){
        //修改时间输出格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        record.setTime(df.format(new Date()));// new Date()为获取当前系统时间
        return record.getTime();
    }
}
