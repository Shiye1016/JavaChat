package QQ.clientUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

//用于获取消息收发的时间
public class GetTime {
    public static String  displayTime(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }
}