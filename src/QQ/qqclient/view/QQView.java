package QQ.qqclient.view;

import QQ.UserClientService.MessageClientService;
import QQ.UserClientService.UserClientService;
import QQ.qqUtil.Utility;

import javax.swing.*;

//客户端的菜单界面
public class QQView extends JFrame {

    public static void main(String[] args) {
        QQView qqView = new QQView();
        qqView.mainMenu();
        System.out.println("客户端退出系统...");
    }

    private boolean loop = true; //控制是否显示菜单
    private final UserClientService userClientService = new UserClientService();//用于登录服务器
    private final MessageClientService messageClientService = new MessageClientService();//对象用户私聊/群聊

    //显示主菜单
    public void mainMenu(){

//这个循环影响窗口显示
//        while(loop){
//
//            System.out.println("========欢迎登录网络通讯系统========");
//            System.out.println("\t\t 1 登录系统");
//            System.out.println("\t\t 9 退出系统");
//            System.out.print("请输入你的选择：");
//
//            //接收用户的键盘输入
//            String key = Utility.readString(1);
//
//            //根据用户据的输入来处理不同的逻辑
//            switch (key){
//                case "1":
//                    System.out.print("请输入用户号：");
//                    String userId = Utility.readString(50);
//                    System.out.print("请输入密  码：");
//                    String pwd = Utility.readString(50);
//                    //到服务端验证用户
//                    if(userClientService.checkUser(userId,pwd)){
//                        System.out.println("======欢迎(用户 " + userId + "登录成功)======" );
//                        //uName.setText(userId);
//                        //进入到二级菜单
//                        while(loop){
//                            System.out.println("======网络通信系统二级菜单(用户 " + userId + ")======");
//                            System.out.println("\t\t 1 显示在线用户列表");
//                            System.out.println("\t\t 2 群发消息");
//                            System.out.println("\t\t 3 私聊消息");
//                            System.out.println("\t\t 4 发送文件");
//                            System.out.println("\t\t 9 退出系统");
//                            System.out.print("请输入你的选择：");
//                            key = Utility.readString(1);
//                            switch(key){
//                                case "1":
//                                    userClientService.onlineFriendList();//拉取在线用户列表
//                                    break;
//                                case "2":
//                                    System.out.println("请输入想对大家说的话：");
//                                    String s = Utility.readString(100);
//
//                                    //调用一个方法，将消息封装成message
//                                    messageClientService.sendMessageToAll(s,userId);
//                                    break;
//                                case "3":
//                                    System.out.print("请输入对方用户id(在线)");
//                                    String getterId = Utility.readString(50);
//                                    System.out.print("请输入想说的话：");
//                                    String content = Utility.readString(100);
//                                    //编写一个方法将消息发送给服务端
//                                    messageClientService.sendMessageToOne(content, userId, getterId);
//                                    break;
//                                case "4":
//                                    System.out.println("发送文件");
//                                    break;
//                                case "9":
//                                    //调用方法给服务器发送一个退出系统的message
//                                    userClientService.logout();
//                                    loop = false;
//                                    break;
//                            }
//                        }
//                    }else{
//                        System.out.println("======登录失败======");
//                    }
//                    break;
//                case "9":
//                    loop = false;
//                    break;
//            }
//
//        }
    }
    public QQView(){

    }


    //一下给嵌套界面代码

}
