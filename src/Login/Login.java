package Login;

import Javachat.UserClientService.UserClientService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class Login {
    private static final JFrame jf=new JFrame("登录界面");
    final int width=640;
    final int height=480;
    private static String ipAddress = "127.0.0.1";//用于指定服务器IP地址
    private static final RegisteredFrame registeredFrame =new RegisteredFrame();
    public static String getIpAddress(){
        return ipAddress;
    }
    static UserClientService userClientService = new UserClientService();

    public void init() {
        try {
            jf.setIconImage(ImageIO.read(new File("images/logo.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon icon1 = new ImageIcon("images/backgroundP.jpg");
        JLabel background = new JLabel(icon1);
        background.setBounds(0, 0,width,height);
        //jf.setLayout(null);
        //设置窗口的内容
        //垂直水平排列BOX实现 +panel

        //bgPanel.setOpaque(false);
        //组装登陆相关的元素
        Box vBox=Box.createVerticalBox();//垂直
        //组装用户名
        Box uBox= Box.createHorizontalBox();//水平
        JLabel uLabel=new JLabel("用户名:");
        uLabel.setFont(new  java.awt.Font("宋体",  Font.BOLD+ Font.ITALIC,  20));
        //输入框 15字符的宽度
        JTextField uField=new JTextField(20);
        uBox.add(uLabel);
        //20个像素的空格
        uBox.add(Box.createHorizontalStrut(10));//间隔距离
        uBox.add(uField);

        //组装密码
        Box pBox= Box.createHorizontalBox();//水平
        JLabel pLabel=new JLabel("密  码:");
        pLabel.setFont(new  java.awt.Font("宋体",  Font.BOLD+ Font.ITALIC,  20));
        //输入框 15字符的宽度
        JPasswordField pField=new JPasswordField(20);
        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(10));//  间隔距离
        pBox.add(pField);

        //组装按钮
        Box btnBox=Box.createHorizontalBox();
        JButton loginBtn=new JButton();
        JButton RegisterBtn=new JButton();
        loginBtn.setContentAreaFilled(false);
        loginBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        loginBtn.setIcon(new ImageIcon("images/login1.png"));


        RegisterBtn.setContentAreaFilled(false);
        RegisterBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        RegisterBtn.setIcon(new ImageIcon("images/register.png"));

        loginBtn.addActionListener(e -> LoginBtn(uField,pField,jf));
        RegisterBtn.addActionListener(e->Registered(registeredFrame));

        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(60));//间隔距离
        btnBox.add(RegisterBtn);

        vBox.add(Box.createVerticalStrut(130));//距离界面上方距离

        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(50));//行之间距离
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(60));//行之间距离
        vBox.add(btnBox);


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

        jf.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        JPanel pan=(JPanel)jf.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());
        pan.add(vBox);

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setSize(width, height);
        //设置界面居中
        jf.setLocationRelativeTo(null);
        //不可改变按大小
        jf.setResizable(false);
        jf.setVisible(true);

    }
    public static void main(String[] args) {
            Login L=new Login();
            L.init();
            registeredFrame.init();
            registeredFrame.setVisible(false);
    }
    public static void Registered(RegisteredFrame registeredframe){
        jf.setVisible(false);
        registeredframe.setVisible(true);
    }
    public static void CancelRegistered(RegisteredFrame registeredframe){
        registeredframe.setVisible(false);
        jf.setVisible(true);

    }

    public void LoginBtn(JTextField uName, JTextField pwd,JFrame jFrame){

        if(!(userClientService.checkUser(uName.getText(),pwd.getText()))){
            JOptionPane.showMessageDialog(null,"账号或密码错误","登录失败", JOptionPane.ERROR_MESSAGE);
        }else{
            String username = uName.getText();
            jFrame.dispose();
            MainFrame mainFrame = new MainFrame();
            mainFrame.Init();
            mainFrame.setUserName(username);//实现登录后用户名显示为登录时的用户名
        }
    }

    //无异常退出
    public static void exit(){
        userClientService.logout();
    }

    //刷新在线列表
    public static void refresh(){
        userClientService.onlineFriendList();
    }
}