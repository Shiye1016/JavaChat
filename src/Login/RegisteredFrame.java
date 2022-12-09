package Login;

import javax.swing.*;

public class RegisteredFrame extends JFrame{
    private static int height=480;
    private static int width=640;
    private static JButton regsbtn=new JButton("注册");
    private static JButton cancelbtn=new JButton("取消");
    public void init(){
    this.setSize(width,height);
    //主BOX
    Box mainBox=Box.createVerticalBox();

    //



    //按钮
    Box uBox= Box.createHorizontalBox();
    uBox.add(regsbtn);
    uBox.add(Box.createHorizontalStrut(60));
    uBox.add(cancelbtn);




    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
    }
}
