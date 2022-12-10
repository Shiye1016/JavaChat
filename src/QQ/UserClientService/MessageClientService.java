package QQ.UserClientService;

import QQ.clientUtil.GetTime;
import QQ.clientUtil.WriteAndRead;
import QQ.qqCommon.Message;
import QQ.qqCommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
//该类/对象提供和消息相关的服务方法
public class MessageClientService {

    public void sendMessageToOne(String content, String senderId, String getterId){
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);//普通的聊天消息类型
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(GetTime.displayTime());
        System.out.println("\n\n" + message.getSendTime() + "\n" + "你对" + getterId + "说：" + content + "\n");
        WriteAndRead.writeSend(message.getSender(),message.getGetter(),message.getContent());
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
