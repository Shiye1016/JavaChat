package QQ.UserClientService;

import QQ.qqUtil.GetTime;
import QQ.qqcommon.Message;
import QQ.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
//该类/对象提供和消息相关的服务方法
public class MessageClientService {


    //群发
    public void sendMessageToAll(String content, String senderId){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);//群发消息类型
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(GetTime.displayTime());//发送时间设置到message对象
        System.out.println("你对 大家 说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToOne(String content, String senderId, String getterId){
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通的聊天消息类型
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(GetTime.displayTime());
        System.out.println("\n\n" + message.getSendTime() + "\n" + "你对 " + getterId + " 说：" + content + "\n");//System.out.println(senderId + " 对 " + getterId + " 说 " + content);
        //发送给服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
