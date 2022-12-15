package Javachat.qqServer.util;

import java.text.SimpleDateFormat;
import java.util.Date;
public class ServerTime {
    public static String displayTime(){
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(date);
    }
}