package xx;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        JFrame jf = new JFrame();
        ImageIcon imageIcon = new ImageIcon("images/123.jpg");
        jf.getContentPane().setBackground(new Color(217, 236, 245)); //设置背景颜色
        jf.setIconImage(imageIcon.getImage());
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭窗口程序退出
        jf.setTitle("我是柿子砍树");
        jf.setResizable(false);
        jf.setVisible(true);
    }
    public static void main(String[] args){
        new MainFrame();
    }
}

