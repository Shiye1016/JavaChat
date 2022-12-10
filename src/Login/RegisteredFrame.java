package Login;

import QQ.UserClientService.UserClientService;

import javax.swing.*;

public class RegisteredFrame extends JFrame{
    private static final int height=480;
    JLabel uLabel=new JLabel("用户名:");
    JLabel pLabel=new JLabel("密     码:");
    JTextField uField=new JTextField(15);
    JTextField pField=new JTextField(15);
    private static final JButton regsBtn=new JButton("注     册");
    private static final JButton cancelBtn=new JButton("取消注册");
    public void init(){
        this.setTitle("注册界面");
        int width = 640;
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
        regsBtn.addActionListener(e -> register());
    }
    public void register(){
        String rUser = uField.getText();
        String rPasswd = pField.getText();
        UserClientService userClientService = new UserClientService();
        if(userClientService.register(rUser,rPasswd)){
            System.out.println("注册成功");
            JOptionPane.showMessageDialog(this,"用户注册成功","Succeed",JOptionPane.INFORMATION_MESSAGE,null);
            Login.CancelRegistered(this);
        }else{
            JOptionPane.showMessageDialog(this,"账号已存在或用户名密码未设置","注册失败", JOptionPane.ERROR_MESSAGE);
        }


    }

}
