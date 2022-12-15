package Login;

import Javachat.UserClientService.UserClientService;

import javax.swing.*;
import java.awt.*;

public class RegisteredFrame extends JFrame{
    private static final int height=480;
    private static final int width=640;
    JLabel uLabel=new JLabel("用户名:");
    JLabel pLabel=new JLabel("密  码:");
    JTextField uField=new JTextField (20);
    JTextField pField=new JPasswordField (20);
    private static final JButton regsBtn=new JButton();
    private static final JButton cancelBtn=new JButton();
    public void init(){
        this.setTitle("注册界面");
        this.setSize(width,height);
        this.setIconImage(new ImageIcon("images/logo.png").getImage());//窗口图标
        ImageIcon icon1 = new ImageIcon("images/background2.jpg");
        JLabel background = new JLabel(icon1);
        background.setBounds(0, 0,width,height);
        //主BOX
        Box mainBox=Box.createVerticalBox();
        //账号Box
        uLabel.setFont(new  java.awt.Font("宋体",  Font.BOLD+ Font.ITALIC,  20));
        uLabel.setForeground(Color.white);
        Box ubox=Box.createHorizontalBox();//账号
        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(10));
        ubox.add(uField);
        //密码Box
        pLabel.setForeground(Color.white);
        pLabel.setFont(new  java.awt.Font("宋体",  Font.BOLD+ Font.ITALIC,  20));
        Box pbox=Box.createHorizontalBox();//账号
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(10));
        pbox.add(pField);
        //按钮Box
        Box bBox= Box.createHorizontalBox();
        regsBtn.setContentAreaFilled(false);
        regsBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        regsBtn.setIcon(new ImageIcon("images/register2.png"));

        cancelBtn.setContentAreaFilled(false);
        cancelBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        cancelBtn.setIcon(new ImageIcon("images/cancel.png"));
        bBox.add(regsBtn);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelBtn);

        mainBox.add(Box.createVerticalStrut(150));
        mainBox.add(ubox);
        mainBox.add(Box.createVerticalStrut(50));
        mainBox.add(pbox);
        mainBox.add(Box.createVerticalStrut(60));
        mainBox.add(bBox);

        this.getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));
        JPanel pan=(JPanel)this.getContentPane();
        pan.setOpaque(false);
        pan.setLayout(new FlowLayout());
        pan.add(mainBox);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        cancelBtn.addActionListener(e -> Login.CancelRegistered(this));
        regsBtn.addActionListener(e -> register());
    }
    public void register(){
        String rUser = uField.getText();
        String rPasswd = pField.getText();
        UserClientService userClientService = new UserClientService();
        if(userClientService.register(rUser,rPasswd)){
            JOptionPane.showMessageDialog(this,"用户注册成功","Succeed",JOptionPane.INFORMATION_MESSAGE,null);
            Login.CancelRegistered(this);
        }else{
            JOptionPane.showMessageDialog(this,"账号已存在或用户名密码未设置","注册失败", JOptionPane.ERROR_MESSAGE);
        }
    }
}
