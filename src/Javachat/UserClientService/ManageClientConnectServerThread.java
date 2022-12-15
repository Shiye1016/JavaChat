package Javachat.UserClientService;

import java.util.HashMap;

//管理客户端连接到服务器端的线程的类
public class ManageClientConnectServerThread {
    private static final HashMap<String, ClientConnectServiceThread> hm = new HashMap<>();

    //将某个线程加入到集合中
    public static void addClientConnectServerThread(String userId,ClientConnectServiceThread clientConnectServiceThread){
        hm.put(userId,clientConnectServiceThread);
    }
    //通过userId 可以得到对应线程
    public static ClientConnectServiceThread getClientConnectServerThread(String userId){
        return hm.get(userId);
    }
}