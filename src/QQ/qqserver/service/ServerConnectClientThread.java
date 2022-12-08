package QQ.qqserver.service;

import QQ.qqUtil.GetTime;
import QQ.qqUtil.WriteToLog;
import QQ.qqcommon.Message;
import QQ.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

//该类的对象和某个客户端保持通信
public class ServerConnectClientThread extends Thread{

    private final Socket socket;
    private final String userId;//连接到服务器的用户id
    public Socket getSocket(){
        return socket;
    }
    public ServerConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {//线程处于run状态，可以发送和接收消息
        System.out.println("用户 " + userId + " 已上线 " + GetTime.displayTime());
        WriteToLog.writeServiceLog("用户 " + userId + " 已上线 " + GetTime.displayTime());//写入日志
        while(true){
            try {

                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                //根据message的类型做相应的业务处理
                if(message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)){
                    //客户端要在线用户列表
                    System.out.println(message.getSender() + " 刷新了在线用户列表\t" + GetTime.displayTime());
                    WriteToLog.writeServiceLog(message.getSender() + " 刷新了在线用户列表\t" + GetTime.displayTime());//写入日志
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    //返回message
                    //构建一个Message对象返回给客户端
                    Message message2 = new Message();
                    message2.setMesType(MessageType.MESSAGE_RET_ONLINE_FRIEND);
                    message2.setContent(onlineUser);
                    message2.setGetter(message.getSender());
                    //返回给客户端
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message2);

                } else if(message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    //根据message获取getterId然后得到对应的线程
                    ServerConnectClientThread serverConnectClientThread
                            = ManageClientThreads.getServerConnectClientThread(message.getGetter());
                    //得到对应socket的对象输出流，将message对象转发给指定的客户端
                    ObjectOutputStream oos
                            = new ObjectOutputStream(serverConnectClientThread.getSocket().getOutputStream());
                    oos.writeObject(message);//转发消息，如果客户不在线保存到数据库，以实现离线留言
                } else if(message.getMesType().equals(MessageType.MESSAGE_TO_ALL_MES)){
                    //遍历管理线程的集合，把所有线程的socket得到并把message进行转发
                    HashMap<String, ServerConnectClientThread> hm = ManageClientThreads.getHm();

                    for (String onLineUserId : hm.keySet()) {
                        //取出在线用户的id
                        if (!onLineUserId.equals(message.getSender())) {//排除群发的发送者
                            //转发message
                            ObjectOutputStream oos = new ObjectOutputStream(hm.get(onLineUserId).getSocket().getOutputStream());
                            oos.writeObject(message);

                        }


                    }

                } else if(message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)){//客户端退出
                    System.out.println(message.getSender() + " 退出");
                    WriteToLog.writeServiceLog(message.getSender() + " 退出\t" + GetTime.displayTime());//写入日志
                    //将这个客户端对应线程从集合中删除
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    socket.close();//关闭连接
                    //退出线程
                    break;


                }
                else {
                    System.out.println("其他类型的message,暂时不处理");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }

}
