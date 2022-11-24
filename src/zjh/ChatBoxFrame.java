package zjh;
import javax.swing.*;
import Constants.Constants;
public class ChatBoxFrame extends  JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();//新建一个框架
        frame.setTitle(Constants.APP_NAME);//设置标题
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//界面关闭方式
        frame.setLocationRelativeTo(null);//显示的界面居中
        //frame.setResizable(false);//设置能否改变大小
        frame.setSize(700,500);
        //ImageIcon img=new ImageIcon();
        //JLabel labImg=new JLabel(img.getIconImage());
        //img.setIconImage(img.getImage().getScaledInstance(frame.getWidth(),200,Image.SCALE_DEFAULT));
        //labImg.setVisible(true);
        //frame.getContentPane().add(labImg);
        //frame.add(labImg);
        //javax.swing.JLabel labName1=new javax.swing.JLabel(img);
       // frame.add(labName1);
        frame.setVisible(true);
    }
}

