package Frame.Main;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import Constants.Constants;

public class MainFrame extends JFrame {
    final int width = 1000;
    final int height = 700;
    public MainFrame() {}
    public void Init(){
        this.setSize(width,height);
        this.getContentPane().setBackground(new Color(217, 236, 245)); //背景颜色
        this.setIconImage(new ImageIcon("images/123.jpg").getImage());//窗口图标
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        this.setTitle(Constants.APP_NAME);//窗口标题
        this.setResizable(false);
        this.setVisible(true);
        //左上角头像
        JLabel IconLabel = new JLabel();
        IconLabel.setIcon(new ImageIcon("images/123.jpg"));
        Box Icon =Box.createHorizontalBox();//水平排列
        Icon.add(IconLabel);
        this.add(Icon);


    }
    public static void main(String[] args){
        new MainFrame().Init();
    }
}

