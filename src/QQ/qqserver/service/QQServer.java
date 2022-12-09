package QQ.qqserver.service;

import QQ.qqUtil.GetTime;
import QQ.qqUtil.WriteToLog;
import QQ.qqcommon.User;
import QQ.qqcommon.Message;
import QQ.qqcommon.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

//服务器，在监听999，等待客户端的连接，并保持通信
public class QQServer {
    public static void main(String[] args) {
        new QQServer();
    }

    //创建一个集合存放多个用户，如果是这些用户登录就认为是合法的
    //这里可以使用ConcurrentHashMap,可以处理并发的集合，无线程安全的问题
    //HashMap没有线程安全因此在多线程情况下不安全

    private static final ConcurrentHashMap<String, User> validUsers = new ConcurrentHashMap<>();
    static { //在静态代码块初始化 validUsers

        validUsers.put("徐林靖",new User("徐林靖","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("400",new User("400","123456"));
        validUsers.put("500",new User("500","123456"));
        validUsers.put("600",new User("600","123456"));


    }

    //验证用户是否有效的方法
    private boolean checkUser(String userId, String passwd){

        User user = validUsers.get(userId);
        if(user == null) return false; //说明userId没有存在validUsers的key中

        return user.getPasswd().equals((passwd));//用户名正确，密码错误return false 否则return true
    }

    public QQServer(){

        //端口可以写在配置文件
        ServerSocket ss = null;
        try {
            System.out.println("服务端已启动，端口：9999 \t" + GetTime.displayTime());
            WriteToLog.writeServiceLog("\n\n\n服务端已启动，端口：9999 " + GetTime.displayTime());
            ss = new ServerSocket(9999);

            while (true){ //当和某个客户端连接后，会继续监听
                Socket socket = ss.accept();//如果没有客户端连接就会阻塞在这里
                //得到socket关联的对象输入流
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                //得到socket关联的对象输出流
                ObjectOutputStream oos =
                        new ObjectOutputStream(socket.getOutputStream());
                User u = (User)ois.readObject();//读取客户端发送的User对象
                //创建一个Message对象准白回复客户端
                Message message = new  Message();
                //验证
                if(checkUser(u.getUserId(),u.getPasswd())){//登录成功
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    //将Message对象回复
                    oos.writeObject(message);
                    //创建一个线程和客户端保持通信，该线程需要持有Socket对象
                    ServerConnectClientThread serverConnectClientThread =
                            new ServerConnectClientThread(socket,u.getUserId());
                    //启动线程
                    serverConnectClientThread.start();
                    //把该线程放入到一个集合中进行管理
                    ManageClientThreads.addClientThread(u.getUserId(),serverConnectClientThread);
                }else{//登录失败
                    System.out.println("用户 id = " + u.getUserId() + " pwd = " + u.getPasswd() + "验证失败 " + GetTime.displayTime());
                    WriteToLog.writeServiceLog("用户 id = " + u.getUserId() + " pwd = " + u.getPasswd() + "验证失败\t" + GetTime.displayTime());
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    oos.writeObject(message);
                    //登录失败关闭socket
                    socket.close();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务端退出while，说明服务端不在监听因此关闭ServerSocket
            try {
                assert ss != null;
                ss.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
