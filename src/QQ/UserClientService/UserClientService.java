package QQ.UserClientService;

import Login.Login;
import QQ.qqcommon.Message;
import QQ.qqcommon.MessageType;
import QQ.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

//完成用户登录验证和用户注册
public class UserClientService {
    //可能在其他地方要使用user信息
    private final User u = new User();
    //可能在其他地方也要使用Socket对象
    private Socket socket;

    //根据userID和pwd到服务器验证用户是否合法
    public boolean checkUser(String userId, String pwd){
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);


        try {
            // 连接到服务器发送u对象
            Socket socket = new Socket(InetAddress.getByName(Login.getIpAddress()),9999);
            //得到ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);//发送user对象

            //读取从服务端回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message) ois.readObject();

            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){

                //创建一个和服务器端保持通信的线程->创建一个类ClientConnectServiceThread
                ClientConnectServiceThread clientConnectServiceThread = new ClientConnectServiceThread(socket);
                //启动客户端的线程
                clientConnectServiceThread.start();
                //为了后面客户端的扩展，将线程放入到集合中管理
                 ManageClientConnectServerThread.addClientConnectServerThread(userId,clientConnectServiceThread);
                b = true;

            }else{
                //如果登录失败，就不能启动和服务器通信的线程，关闭socket
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    //向服务器端请求在线用户列表
    public void onlineFriendList(){
        //发送一个Message，类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器
        //应该得到当前线程的Socket对应的ObjectOutputStream对象
        try {
            //从管理线程的集合中通过userId得到线程
            ClientConnectServiceThread clientConnectServiceThread =
                    ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId());
            //得到这个线程得到关联的socket
            Socket socket = clientConnectServiceThread.getSocket();
            //得到当前线程的Socket对应的ObjectOutputStream对象
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);//发送一个Message对象，向服务器请求在线用户列表
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //编写方法退出客户端并给服务端发送一个退出系统的message对象
    public void logout(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());//一定要指定是哪个客户端id
        //发送message
        try {
            //ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream()) //因为一个用户只有一个socket所以可以这么写
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统 ");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
