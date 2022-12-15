package Javachat.UserClientService;

import Login.MainFrame;
import Javachat.clientUtil.MusicPlay;
import Javachat.clientUtil.WriteAndRead;
import Javachat.ChatCommon.Message;
import Javachat.ChatCommon.MessageType;

import java.io.ObjectInputStream;
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
                    MainFrame.clearList();
                    for (String onlineUser : onlineUsers) {
                        MainFrame.setOnlineUser(onlineUser);
                    }
                } else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){//普通的聊天消息
                    //把服务器端转发的消息显示到控制台
                    MainFrame.setTextJ_1(message.getSendTime() + "\n" + message.getSender() + "对你说：" + message.getContent() + "\n");
                    MusicPlay.MusicPlay("music/music1.wav");
                    WriteAndRead.writeGet(message.getSender(),message.getGetter(),message.getContent());
                }
            } catch (Exception e) {
            }
        }
    }
}