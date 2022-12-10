package QQ.qqUtil;

import Login.MainFrame;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteAndRead {
    public static void writeServiceLog(String logInfo){
        try {
            FileWriter log = new FileWriter("log.txt",true);
            log.write( logInfo + "\n");
            log.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void writeRecord(String sender, String getter, String content){
        try {
            FileWriter record = new FileWriter(sender + " to " + getter + ".txt",true);
            record.write(content + "\n");
            record.flush();
            record.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //显示历史消息
    public static void showRecord(String sender,String getter){
        MainFrame.setTextJ_1();//消息框置空
        File file = new File(sender + " to " + getter + ".txt");

        try{
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null)
                    MainFrame.setTextJ_1(line);
            br.close();
            isr.close();
            fis.close();
        }catch(IOException e){
            System.out.println("文件打开失败");
        }
    }

}
