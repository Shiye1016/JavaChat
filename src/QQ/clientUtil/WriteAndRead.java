package QQ.clientUtil;

import Login.MainFrame;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteAndRead {

    //将发送的信息写入本地文件
    public static void writeSend(String sender, String getter, String content){
        try {
            FileWriter record = new FileWriter("record//" + sender + " to " + getter + ".txt",true);
            record.write(GetTime.displayTime() + "\n你对" + getter + "说：" + content + "\n\n");
            record.flush();
            record.close();
        } catch (IOException e) {
            System.out.println("发送消息写入失败");
        }

    }

    //将收到的信息写入本地文件
    public static void writeGet(String sender,String getter, String content){
        try{
            FileWriter get = new FileWriter("record//" + getter + " to " + sender + ".txt",true);
            get.write(GetTime.displayTime() + "\n" +sender + "对你说：" + content + "\n\n");
            get.flush();
            get.close();
        }catch (IOException e){
        }

    }

    //显示历史消息
    public static void showRecord(String sender,String getter){
        MainFrame.setTextJ_1();//消息框置空
        File file = new File("record//" + sender + " to " + getter + ".txt");

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
        }
    }
}