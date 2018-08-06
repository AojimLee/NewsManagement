package util;

import java.text.SimpleDateFormat;
import java.util.Date;


//获取当前时间，在创建和修改新闻时均会调用
public class GetTime {
    public String GetTime(){
        //修改时间输出格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
