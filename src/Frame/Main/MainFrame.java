package Frame.Main;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    final int width = 800;
    final int height = 640;
    public MainFrame() {}
    public void Init(){
        this.setSize(width,height);
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        this.setTitle(Constants.APP_NAME);//窗口标题
        this.setResizable(false);
        this.setIconImage(new ImageIcon("images/TIcon.jpg").getImage());//窗口图标

        //左上角头像
        JLabel IconLabel = new JLabel();
        IconLabel.setVisible(true);
        IconLabel.setIcon(new ImageIcon("images/12333.png"));
        Box IconBox =Box.createVerticalBox();//垂直排列
        IconBox.add(IconLabel);
        //头像下用户名
        JLabel uName = new JLabel("默认用户名");
        uName.setFont(new Font("微软雅黑", Font.BOLD,20));
        IconBox.add(Box.createVerticalStrut(10));
        IconBox.add(uName);
        IconBox.setBounds(60,30,100,135);
        //组装用户名和头像
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Constants.BgColor);
        panel.add(IconBox);
        //聊天列表框
        String[] item = {"好友1","好友2","好友3","好友4","好友5"};
        JList<String> jl_1=new JList<>(item);// 创建列表框
        JLabel listText = new JLabel("聊天列表");
        panel.add(listText);
        listText.setBounds(80,100,200,200);
        JScrollPane js = new JScrollPane();
        js.getViewport().add(jl_1,null);
        panel.add(js);
        js.setBounds(10,210,210,335);
        //添加删除按钮
        Box bBox = Box.createHorizontalBox();
        JButton add = new JButton("添加好友");
        JButton del = new JButton("删除好友");
        bBox.add(add);
        bBox.add(Box.createHorizontalStrut(10));
        bBox.add(del);
        panel.add(bBox);
        bBox.setBounds(23,467,200,200);

        //右侧消息框和输入框
        JTextArea jTextArea_1 = new JTextArea("聊天记录");//消息框
        jTextArea_1.setEditable(false);//消息框只读
        JScrollPane js1 = new JScrollPane();//消息框滚动条
        js1.getViewport().add(jTextArea_1);
        JTextArea jTextArea_2 = new JTextArea();//输入框
        JScrollPane js2 = new JScrollPane();
        js2.getViewport().add(jTextArea_2);
        JButton send = new JButton("发送");//发送按钮
        Box b1 = Box.createVerticalBox();//用于放置消息框
        b1.add(js1);
        panel.add(b1);
        b1.setBounds(230,10,540,350);
        Box b2 = Box.createHorizontalBox();//用于放置输入框和发送按钮
        b2.add(js2);
        panel.add(b2);
        panel.add(send);
        b2.setBounds(230,370,540,175);
        send.setBounds(240,555,520,25);

        this.add(panel);
        this.setVisible(true);

    }

    public static void main(String[] args){
            new MainFrame().Init();
    }
}