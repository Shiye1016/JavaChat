package Frame.Main;

import Constants.Constants;

import javax.swing.*;

public class MainFrame extends JFrame {
    final int width = 1000;
    final int height = 700;
    public MainFrame() {}
    public void Init(){
        this.setSize(width,height);
        this.setLocationRelativeTo(null);//窗口居中显示
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        this.setTitle(Constants.APP_NAME);//窗口标题
        this.setResizable(false);
        this.setIconImage(new ImageIcon("images/TIcon.jpg").getImage());//窗口图标

        //左上角头像
        JPanel iPanel = new JPanel();
        iPanel.setLayout(null);
        iPanel.setBackground(Constants.BgColor);
        JLabel IconLabel = new JLabel();
        IconLabel.setVisible(true);
        IconLabel.setIcon(new ImageIcon("images/12333.png"));
        Box IconBox =Box.createVerticalBox();//垂直排列
        IconBox.add(IconLabel);
        //头像下用户名
        JLabel uName = new JLabel("    默认用户名");
        uName.setSize(100,100);
        IconBox.add(Box.createVerticalStrut(10));
        IconBox.add(uName);
        IconBox.setBounds(60,30,100,130);
        iPanel.add(IconBox);
        this.add(iPanel);
        this.setVisible(true);
    }

    public static void main(String[] args){
            new MainFrame().Init();
    }

}

