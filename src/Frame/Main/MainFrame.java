package Frame.Main;
import javax.swing.*;
import java.awt.*;

import Constants.Constants;

public class MainFrame extends JFrame {
    final int width = 1000;
    final int height = 700;
    public MainFrame() {}
    public void Init(){
        this.setSize(width,height);
        this.getContentPane().setBackground(new Color(217, 236, 245)); //背景颜色
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        this.setTitle(Constants.APP_NAME);//窗口标题
        this.setResizable(false);
        this.setIconImage(new ImageIcon("images/TIcon.jpg").getImage());//窗口图标

        //左上角头像
        JLabel IconLabel = new JLabel();

        IconLabel.setIcon(new ImageIcon("images/1233.png"));
        IconLabel.setSize(100,100);
        Box Icon =Box.createVerticalBox();//水平排列
        Icon.add(IconLabel);
        Icon.setSize(100,100);
        this.add(Icon);
        this.setVisible(true);
    }

    public static void main(String[] args){
            new MainFrame().Init();
    }

}

