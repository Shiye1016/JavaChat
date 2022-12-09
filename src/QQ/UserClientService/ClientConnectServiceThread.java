package QQ.UserClientService;

import Login.MainFrame;
import QQ.qqUtil.GetTime;
import QQ.qqUtil.WriteToLog;
import QQ.qqcommon.Message;
import QQ.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.WriteAbortedException;
import java.net.Socket;

public class ClientConnectServiceThread extends Thread{
    //该线程需要持有Socket
    private final Socket socket;

    public ClientConnectServiceThread(Socket socket){
        this.socket = socket;
    }

    //为了更方便得到Socket
    public Socket getSocket(){
        return socket;
    }

    @Override
    public void run() {
        //因为线程需要在后台和服务器通信，因此while循环
        System.out.println("客户端线程，等待从读取从服务器端发送的消息");
        while(true){
            try {
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message)ois.readObject(); //如果服务器没有发送Message对象，线程会阻塞在这里
                //判断这个message类型，然后做相应的业务处理
                //如果是读取到的是服务器的在线用户列表
                if(message.getMesType().equals((MessageType.MESSAGE_RET_ONLINE_FRIEND))){
                    //取出在线列表信息并显示
                    String[] onlineUsers = message.getContent().split(" ");
                    System.out.println("\n======在线用户列表======");
                    MainFrame.clearList();
                    for (String onlineUser : onlineUsers) {
                        System.out.println("用户：" + onlineUser);
                        MainFrame.setOnlineUser(onlineUser);
                    }

                } else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){//普通的聊天消息
                    //把送服务器端转发的消息显示到控制台
                    System.out.println("\n\n"+ GetTime.displayTime() + "\n" + message.getSender() + " 对 你 说：" + message.getContent() + "\n");//System.out.println("\n" + message.getSender() + " 对 " + message.getGetter() + " 说 " + message.getContent());
                    //WriteToLog.writeClientChatRecord(message.getSender() + " 对 " + message.getGetter() + " 说：" + message.getContent() +"\t"+ message.getSendTime());
                    MainFrame.setTextJ_1(GetTime.displayTime() + "\n" + message.getSender() + " 对 你 说：" + message.getContent() + "\n");

                } else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //显示在客户端的控制台
                    System.out.println(message.getSendTime() + "\n" + message.getSender() + " 对 大家 说：" + message.getContent());
                   // WriteToLog.writeClientChatRecord(message.getSendTime() + "\n" + message.getSender() + " 对 大家 说：" + message.getContent() + "\t" + message.getSendTime());
                } else {
                    System.out.println("是其他类型的message,暂时不处理……");
                }
            } catch (Exception e) {
            }
        }
    }
}
