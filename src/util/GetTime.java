package util;

import java.text.SimpleDateFormat;
import java.util.Date;


//��ȡ��ǰʱ�䣬�ڴ������޸�����ʱ�������
public class GetTime {
    public String GetTime(){
        //�޸�ʱ�������ʽ
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
    }
}
