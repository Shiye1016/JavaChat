package Frame.Main;
import javax.swing.*;
import java.awt.*;
import Constants.Constants;
public class MainFrame extends JFrame {
    final int width = 600;
    final int height = 600;
    public MainFrame() {
        setSize(width,height);
        getContentPane().setBackground(new Color(217, 236, 245)); //背景颜色
        setIconImage(new ImageIcon("images/123.jpg").getImage());//窗口图标
        setLocationRelativeTo(null);//窗口居中显示
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        setTitle(Constants.APP_NAME);//窗口标题
        setVisible(true);
    }
    public static void main(String[] args){
        MainFrame m =  new MainFrame();
        //`12
    }
}

