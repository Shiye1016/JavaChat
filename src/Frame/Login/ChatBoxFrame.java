package Frame.Login;

import Frame.Main.MainFrame;
import QQ.UserClientService.MessageClientService;
import QQ.UserClientService.UserClientService;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ChatBoxFrame{
    JFrame jf=new JFrame("Wechat");
    final int width=500;
    final int height=300;
    public void init(){
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
        //登陆添加监视
//        loginBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //获取用户输入的数据
//                String username=uField.getText().trim();
//                //获得密码
//                String password=pField.getText().trim();
//                //访问登陆接口
//
//            }
//        });
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
        jf.add(bgPanel);
        jf.setVisible(true);

    }
    public static String getUname(JTextField jTextField){
        return jTextField.getText();
    }

    public static void main(String[] args) {
            new ChatBoxFrame().init();
    }
    static UserClientService userClientService = new UserClientService();
    final static MessageClientService messageClientService = new MessageClientService();//用于用户发消息
    public void LoginBtn(JTextField uName, JTextField pwd,JFrame jFrame){

        if(!(userClientService.checkUser(uName.getText(),pwd.getText()))){
            JOptionPane.showMessageDialog(null,"账号或密码错误","登录失败", JOptionPane.ERROR_MESSAGE);
        }else{
            jFrame.dispose();
            MainFrame mainFrame = new MainFrame();
            mainFrame.Init();
            mainFrame.setUserName(uName.getText());//实现登录后用户名显示为登录时的用户名
            if(!(content.equals(""))){
                messageClientService.sendMessageToOne(content,uName.getText(),"200");
            }
        }
    }
    public void exit(){
        userClientService.logout();
    }
    static private String content = "";
    public static void sendButton(MainFrame mainFrame){
        if(!(mainFrame.getTextJ_2().equals(""))){
            mainFrame.setTextJ_1(mainFrame.getTextJ_2());
            content = mainFrame.getTextJ_2(); //将消息内容赋给content
            messageClientService.sendMessageToOne(content,mainFrame.getUname(),"200");
            mainFrame.setTextJ_2();//实现点击发送按钮后输入框变空
        }
    }

}

