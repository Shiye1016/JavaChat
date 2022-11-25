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
        setSize(width,height);
        getContentPane().setBackground(new Color(217, 236, 245)); //背景颜色
        setIconImage(new ImageIcon("images//123.jpg").getImage());//窗口图标
        setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        setTitle(Constants.APP_NAME);//窗口标题
        setResizable(false);
        setVisible(true);
        //左上角头像
        JLabel IconLabel = new JLabel();
        this.add(IconLabel);
        Box Icon =Box.createHorizontalBox();//水平排列

        this.add(Icon);


    }
    public static void main(String[] args){
        new MainFrame().Init();
    }
}

