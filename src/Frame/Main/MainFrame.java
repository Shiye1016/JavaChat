package Frame.Main;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    final int width = 1000;
    final int height = 700;
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
        JLabel uName = new JLabel("   默认用户名");
        uName.setFont(new Font("微软雅黑", Font.BOLD,14));
        IconBox.add(Box.createVerticalStrut(10));
        IconBox.add(uName);
        IconBox.setBounds(60,30,100,135);
        //组装用户名和头像
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Constants.BgColor);
        panel.add(IconBox);


        //头像下列表框

        String[] item = {"好友1","好友2","好友3","好友4","好友5"};
        JList<String> jl_2=new JList<>(item);// 创建列表框
        panel.add(jl_2);
        jl_2.setBounds(40,160,150,150); //列表框在panel中的位置



        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args){
            new MainFrame().Init();
    }
}

