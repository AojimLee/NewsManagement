package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by MSI on 2018/7/29.
 */
public class ConnectDatebase {
    Connection con;

    public  Connection ConnectDatebase() throws SQLException {
        try {
            //����MySql��������
            Class.forName("com.mysql.jdbc.Driver");
            String username = "root";
            String url = "jdbc:mysql://localhost:3306/nms?serverTimezone=UTC";
            String password = "root";
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            System.out.println("�Ҳ������������� ����������ʧ�ܣ�");
            e.printStackTrace();
        }
        if(con==null){
            System.out.println("���ݿ�����ʧ��");
        }
        else{
            System.out.println("���ݿ����ӳɹ�");
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
       new ConnectDatebase().ConnectDatebase();
    }

}
