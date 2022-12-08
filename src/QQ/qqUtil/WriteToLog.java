package QQ.qqUtil;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToLog {
    public static void writeServiceLog(String logInfo){
        try {
            FileWriter log = new FileWriter("log/log.txt",true);
            log.write( logInfo + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static  void writeClientChatRecord(String chatRecord){
        try {
            FileWriter log = new FileWriter("log/chatRecord.txt",true);
            log.write( chatRecord + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
