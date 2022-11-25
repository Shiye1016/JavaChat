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
        IconLabel.setPreferredSize(new Dimension(100,100));
        IconLabel.setIcon(new ImageIcon("images/12333.png"));
        Box IconBox =Box.createVerticalBox();//头像垂直排列
        //Icon.add(Box.createHorizontalStrut(5));
       // IconBox.add(Box.createHorizontalStrut(20));
        IconBox.add(IconLabel);
        this.add(IconBox);
        Box.createHorizontalStrut(200);
        this.setVisible(true);
    }

    public static void main(String[] args){
            new MainFrame().Init();
    }

}

