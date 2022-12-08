package QQ.qqUtil;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToLog {
    public static void writeLog(String logInfo){
        try {
            FileWriter log = new FileWriter("log.txt",true);
            log.write( logInfo + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
