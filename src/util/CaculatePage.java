package util;

import dao.ConnectDatebase;
import entity.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MSI on 2018/7/29.
 */

//�������ݿ⣬��ȡ�ܵ����ż�¼����������ܹ���ҳ��
public class CaculatePage {
    //���ҳ������
    public int CaculatePage() {
        Page p = new Page();
        ConnectDatebase conn = new ConnectDatebase();
        Connection con = null;
        try {
            Statement st = null;
            con = conn.ConnectDatebase();
            st=con.createStatement();
            ResultSet rs = st.executeQuery("select count(*) as result from news");
            int count=0;
            while(rs.next())
            {
                count=rs.getInt(1);
            }
            if(count%p.pageSize==0) {
                p.setPageAmount(count / p.pageSize );
            }else{p.setPageAmount(count/p.pageSize + 1);}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p.getPageAmount();
    }
}
