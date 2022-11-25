package Frame.Login;
import javax.imageio.ImageIO;
import javax.swing.*;
import Constants.Constants;
import com.sun.scenario.effect.impl.sw.java.JSWBoxBlurPeer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ChatBoxFrame{
    JFrame jf=new JFrame("Wechat");
    final int width=500;
    final int height=300;
    public void init(){
        jf.setSize(width,height);
        //设置界面居中
        jf.setLocationRelativeTo(null);
        //不可改变按大小
        jf.setResizable(false);
        try {
            jf.setIconImage(ImageIO.read(new File("images/123.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置窗口的内容
        //垂直水平排列BOX实现 +panel
        JPanel bgpanel=new JPanel();
        //组装登陆相关的元素
        Box vBox=Box.createVerticalBox();//垂直
        //组装用户名
        Box uBox= Box.createHorizontalBox();//水平
        JLabel ulabel=new JLabel("用户名:");
        //输入框 15字符的宽度
        JTextField ufiedl=new JTextField(15);
        uBox.add(ulabel);
        //20个像素的空格
        uBox.add(Box.createHorizontalStrut(10));//间隔距离
        uBox.add(ufiedl);

        //组装密码
        Box pBox= Box.createHorizontalBox();//水平
        JLabel plabel=new JLabel("密     码:");
        //输入框 15字符的宽度
        JTextField pfiedl=new JTextField(15);
        pBox.add(plabel);
        pBox.add(Box.createHorizontalStrut(10));//间隔距离
        pBox.add(pfiedl);

        //组装按钮
        Box btnBox=Box.createHorizontalBox();
        JButton loginBtn=new JButton("登陆");
        JButton registBtn=new JButton("注册");
        //登陆添加监视
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取用户输入的数据
                String username=ufiedl.getText().trim();
                //获得密码
                String password=pfiedl.getText().trim();

                //访问登陆接口

            }
        });

        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(60));//间隔距离
        btnBox.add(registBtn);

        //放在垂直Box中
        vBox.add(Box.createVerticalStrut(50));//距离界面上方距离
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));//行之间距离
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));//行之间距离
        vBox.add(btnBox);
        bgpanel.add(vBox);
        jf.add(bgpanel);
        jf.setVisible(true);

    }
    public static void main(String[] args) {
/*        JFrame frame = new JFrame();//新建一个框架
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
        frame.setVisible(true);*/
            new ChatBoxFrame().init();
    }
}

