package QQ.qqclient.view;

import com.xx.EvePro.EventProcessing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Login extends JFrame{
    private int width = 500;
    private int height = 300;
    public void init(){
        setSize(width,height);
        //设置界面居中
        setLocationRelativeTo(null);
        //不可改变按大小
        setResizable(false);
        try {
            setIconImage(ImageIO.read(new File("images/123.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //设置窗口的内容
        //垂直水平排列BOX实现 +panel
        JPanel bgPanel=new JPanel();
        //组装登陆相关的元素
        Box vBox=Box.createVerticalBox();//垂直
        //组装用户名
        Box uBox= Box.createHorizontalBox();//水平
        JLabel jLabel=new JLabel("用户名:");
        //输入框 15字符的宽度
        JTextField uFiled=new JTextField(15);
        uBox.add(jLabel);
        //20个像素的空格
        uBox.add(Box.createHorizontalStrut(10));//间隔距离
        uBox.add(uFiled);


        //组装密码
        Box pBox= Box.createHorizontalBox();//水平
        JLabel pLabel=new JLabel("密     码:");
        //输入框 15字符的宽度
        JTextField pFiled=new JTextField(15);
        pBox.add(pLabel);
        pBox.add(Box.createHorizontalStrut(10));//间隔距离
        pBox.add(pFiled);

        //组装按钮
        Box btnBox=Box.createHorizontalBox();
        JButton loginBtn=new JButton("登陆");
        JButton registerBtn=new JButton("注册");
        //登陆添加监视
//        loginBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //获取用户输入的数据
//                String username=uFiled.getText().trim();
//                //获得密码
//                String password=pFiled.getText().trim();
//                //访问登陆接口
//
//            }
//        });

        btnBox.add(loginBtn);
        btnBox.add(Box.createHorizontalStrut(60));//间隔距离
        btnBox.add(registerBtn);

        //放在垂直Box中
        vBox.add(Box.createVerticalStrut(50));//距离界面上方距离
        vBox.add(uBox);
        vBox.add(Box.createVerticalStrut(20));//行之间距离
        vBox.add(pBox);
        vBox.add(Box.createVerticalStrut(40));//行之间距离
        vBox.add(btnBox);
        bgPanel.add(vBox);
        add(bgPanel);
        setVisible(true);

        loginBtn.addActionListener(x -> EventProcessing.LoginBtn(uFiled,pFiled,this));


    }


    public static void main(String[] args) {
        new Login().init();
    }
}
