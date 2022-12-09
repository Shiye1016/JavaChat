package Login;

import QQ.UserClientService.MessageClientService;
import QQ.UserClientService.UserClientService;
import QQ.qqUtil.GetTime;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Login {
    JFrame jf=new JFrame("Wechat");
    final int width=600;
    final int height=500;

    private static String ipAddress = "127.0.0.1";//用于指定服务器IP地址
    public static String getIpAddress(){
        return ipAddress;
    }
    public void init(){
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(width,height);
        //设置界面居中
        jf.setLocationRelativeTo(null);
        //不可改变按大小
        jf.setResizable(false);
        try {
            jf.setIconImage(ImageIO.read(new File("images/123.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置窗口的内容
        //垂直水平排列BOX实现 +panel
        JPanel bgPanel=new JPanel();
        //组装登陆相关的元素
        Box vBox=Box.createVerticalBox();//垂直
        //组装用户名
        Box uBox= Box.createHorizontalBox();//水平
        JLabel uLabel=new JLabel("用户名:");
        //输入框 15字符的宽度
        JTextField uField=new JTextField(15);
        uBox.add(uLabel);
        //20个像素的空格
        uBox.add(Box.createHorizontalStrut(10));//间隔距离
        uBox.add(uField);

        //组装密码
        Box pBox= Box.createHorizontalBox();//水平
        JLabel pLabel=new JLabel("密     码:");
        //输入框 15字符的宽度
        JTextField pField=new JTextField(15);
        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(10));//  间隔距离
        pBox.add(pField);

        //组装按钮
        Box btnBox=Box.createHorizontalBox();
        JButton loginBtn=new JButton("登陆");
        JButton RegisterBtn=new JButton("注册");

        loginBtn.addActionListener(e -> LoginBtn(uField,pField,jf));



        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(60));//间隔距离
        btnBox.add(RegisterBtn);

        //放在垂直Box中
        vBox.add(Box.createVerticalStrut(50));//距离界面上方距离
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));//行之间距离
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));//行之间距离
        vBox.add(btnBox);
        bgPanel.add(vBox);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("首选项");
        JMenuItem jMenuItem = new JMenu("服务器ip");
        JMenuItem jMenuItem1 = new JMenu("关于");
        jMenuItem.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Object s = JOptionPane.showInputDialog(jf,"set ip address","Server IP Address", //当点击取消时s为空则toString()方法会抛出异常，因此先将返回的对象赋给对象s，若不为空则调用toString()方法
                        JOptionPane.INFORMATION_MESSAGE,null,null,"127.0.0.1");
                if(s == null)
                    ipAddress = "127.0.0.1";
                else
                    ipAddress = s.toString();
            }
        });
        jMenuItem1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(jf,"Developed by Xiang Xi and Zhou Jun" +
                        "hao\nfor Java courses in December 2022","About us",JOptionPane.INFORMATION_MESSAGE,null);
            }
        });
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenuBar.add(jMenu);
        jf.setJMenuBar(jMenuBar);

        jf.add(bgPanel);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
            new Login().init();
            new RegisteredFrame().init();
    }
    static UserClientService userClientService = new UserClientService();
    final static MessageClientService messageClientService = new MessageClientService();//用于用户发消息

    public void LoginBtn(JTextField uName, JTextField pwd,JFrame jFrame){

        if(!(userClientService.checkUser(uName.getText(),pwd.getText()))){
            JOptionPane.showMessageDialog(null,"账号或密码错误","登录失败", JOptionPane.ERROR_MESSAGE);
        }else{
            username = uName.getText();
            jFrame.dispose();
            MainFrame mainFrame = new MainFrame();
            mainFrame.Init();
            mainFrame.setUserName(username);//实现登录后用户名显示为登录时的用户名
        }
    }
    private static String username;
    public void exit(){
        userClientService.logout();
    }

    public static void sendButton(MainFrame mainFrame){
        if(!(mainFrame.getTextJ_2().equals(""))){
            String content = mainFrame.getTextJ_2(); //将消息内容赋给content
            if(mainFrame.getSelectUser() != null && !mainFrame.getSelectUser().equals(username)){
                messageClientService.sendMessageToOne(content,username,mainFrame.getSelectUser());
                MainFrame.setTextJ_1(GetTime.displayTime() + "\n你 对 " + mainFrame.getSelectUser() + "说：" + mainFrame.getTextJ_2() + "\n" );
                mainFrame.setTextJ_2();//实现点击发送按钮后输入框变空
            }else if(mainFrame.getSelectUser() == null){
                JOptionPane.showMessageDialog(mainFrame,"请选择聊天对象！","发送失败", JOptionPane.ERROR_MESSAGE);
            }else if(mainFrame.getSelectUser().equals(username)){
                JOptionPane.showMessageDialog(mainFrame,"不能给自己发消息！","发送失败", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(mainFrame,"不能发送空消息！","发送失败", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void refresh(){
        userClientService.onlineFriendList();
    }
}

