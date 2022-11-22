import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        JFrame jf = new JFrame();
        ImageIcon imageIcon = new ImageIcon("123.jpg");
        jf.getContentPane().setBackground(new Color(217, 236, 245)); //设置背景颜色
        jf.setIconImage(imageIcon.getImage());
        jf.setBounds(Toolkit.getDefaultToolkit().getScreenSize().width/2- jf.getWidth()/2, 0, 600, 600);//获取屏幕宽度并将窗口放置到屏幕最右边
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("〇〇");
        jf.setResizable(false);
        jf.setVisible(true);

    }
    public static void main(String[] args){
        new MainFrame();
    }
}

