package Login;

import javax.swing.*;

public class RegisteredFrame extends JFrame{
    private static int height=480;
    private static int width=640;
    JLabel uLabel=new JLabel("用户名:");
    JLabel pLabel=new JLabel("密     码:");
    JTextField uField=new JTextField(15);
    JTextField pField=new JTextField(15);
    private static JButton regsBtn=new JButton("注     册");
    private static JButton cancelBtn=new JButton("取消注册");
    public void init(){
        this.setTitle("注册界面");
        this.setSize(width,height);
        //主BOX
        Box mainBox=Box.createVerticalBox();
        //账号Box
        Box ubox=Box.createHorizontalBox();//账号
        ubox.add(uLabel);
        ubox.add(Box.createHorizontalStrut(10));
        ubox.add(uField);
        //密码Box
        Box pbox=Box.createHorizontalBox();//账号
        pbox.add(pLabel);
        pbox.add(Box.createHorizontalStrut(10));
        pbox.add(pField);
        //按钮Box
        Box bBox= Box.createHorizontalBox();
        bBox.add(regsBtn);
        bBox.add(Box.createHorizontalStrut(60));
        bBox.add(cancelBtn);

        mainBox.add(Box.createVerticalStrut(150));
        mainBox.add(ubox);
        mainBox.add(Box.createVerticalStrut(50));
        mainBox.add(pbox);
        mainBox.add(Box.createVerticalStrut(60));
        mainBox.add(bBox);
        JPanel panel=new JPanel();
        panel.add(mainBox);
        this.add(panel);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        cancelBtn.addActionListener(e -> Login.CancelRegistered(this));
        }

}
