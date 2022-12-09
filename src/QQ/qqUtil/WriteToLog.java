package QQ.qqUtil;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToLog {
    public static void writeServiceLog(String logInfo){
        try {
            FileWriter log = new FileWriter("log.txt",true);
            log.write( logInfo + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void writeClientChatRecord(String chatRecord,String sender,String getter){
        try {
            FileWriter log = new FileWriter(sender + " To " + getter + ".txt",true);
            log.write( chatRecord + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showRecord(String sender,String getter){

    }

}
