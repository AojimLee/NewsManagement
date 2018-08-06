package util;

import dao.ConnectDatebase;
import entity.Img;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MSI on 2018/8/3.
 */
public class IndexShowImg {

    public List IndexShowImg(){
        String sql = "select * from img";
        List<Img> list = new ArrayList<Img>();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            con = conn.ConnectDatebase();
            PreparedStatement pstmt =con.prepareStatement(sql);
            ResultSet rs =pstmt.executeQuery();

            while(rs.next()){
                Img img = new Img();
                img.setId(rs.getInt("id"));
                img.setTitle(rs.getString("title"));
                img.setSrc(rs.getString("src"));
                list.add(img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
