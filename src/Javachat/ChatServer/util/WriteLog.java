package Javachat.ChatServer.util;

import java.io.FileWriter;
import java.io.IOException;

public class WriteLog {
    public static void writeServiceLog(String logInfo){
        try {
            FileWriter log = new FileWriter("src//Javachat//ChatServer//log.txt",true);
            log.write( logInfo + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}