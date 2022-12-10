package QQ.qqServer.service;

import java.util.HashMap;
import java.util.Iterator;

//此类用于管理和客户端通讯的线程
public class ManageClientThreads {
    private static final HashMap<String,ServerConnectClientThread> hm = new HashMap<>();

    //添加线程对象到hm集合
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }
    //根据userId返回ServerConnectClientThread线程
    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    //从集合中移除某个线程对象
    public static void removeServerConnectClientThread(String userId){
        hm.remove(userId);
    }

    //这里编写方法，可以返回在线用户列表
    public static String getOnlineUser(){
        //遍历集合，遍历HashMap的key
        Iterator<String> iterator = hm.keySet().iterator();
        StringBuilder onlineUserList = new StringBuilder();
       // hm.get("123456");
       while(iterator.hasNext())
            onlineUserList.append(iterator.next()).append(" ");
        return onlineUserList.toString();
    }

    public static HashMap<String, ServerConnectClientThread> getHm() {
        return hm;
    }
}