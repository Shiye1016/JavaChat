package Frame.Main;
import Constants.Constants;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        JFrame jf = new JFrame();
        jf.setLayout(new FlowLayout());//流动布局
        ImageIcon imageIcon = new ImageIcon("images/123.jpg");
        jf.getContentPane().setBackground(new Color(217, 236, 245)); //设置背景颜色
        jf.setIconImage(imageIcon.getImage());
        jf.setSize(600,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭窗口程序退出
        jf.setTitle(Constants.APP_NAME);
        JTextField te = new JTextField(null,null,20);
        te.setLocation(0,0);
        te.setBounds(0,0,200,10);
        jf.getContentPane().add(te);
        jf.setVisible(true);
        String s = te.getText();
        System.out.println(s);
    }
    public static void main(String[] args){
        MainFrame m =  new MainFrame();
        m.getContentPane().getFocusTraversalKeys(0);
    }
}

