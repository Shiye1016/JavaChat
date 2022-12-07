package Frame.Main;
import Frame.Login.ChatBoxFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    final int width = 800;
    final int height = 640;

    public static JLabel uName = new JLabel("默认用户名");//用户名标签
    public static String getUname(){
        return uName.getText();
    }
    private static JList<String> jl_1=new JList<>();// 创建列表框
    static JTextArea jTextArea_1 = new JTextArea("聊天记录\n");//消息框
    public static void setTextJ_1(String str){
        jTextArea_1.append(str + "\n");
    }
    private JTextArea jTextArea_2 = new JTextArea();//输入框
    public String getTextJ_2(){
        return jTextArea_2.getText();
    }
    public void setTextJ_2(){
        jTextArea_2.setText("");
    }
    private static DefaultListModel defaultListModel = new DefaultListModel();//设置列表框可以动态添加元素

    public static void setOnlineUser(String user){
        defaultListModel.add(defaultListModel.size(),user);
    }
    public static void clearList(){
        defaultListModel.removeAllElements();
    }
    public String getSelectUser(){
        return jl_1.getSelectedValue();
    }
    private final JButton refresh = new JButton("刷新列表");
    private final JButton del = new JButton("创建群聊");
    public MainFrame() {}
    public void Init(){////
        jl_1.setModel(defaultListModel);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);//窗口居中显示
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭窗口程序退出
        this.setTitle("JavaChat");//窗口标题
        this.setResizable(false);
        this.setIconImage(new ImageIcon("images/TIcon.jpg").getImage());//窗口图标

        //左上角头像
        JLabel IconLabel = new JLabel();
        IconLabel.setVisible(true);
        IconLabel.setIcon(new ImageIcon("images/12333.png"));
        Box IconBox =Box.createVerticalBox();//垂直排列
        IconBox.add(IconLabel);
        //头像下用户名

        uName.setFont(new Font("微软雅黑", Font.BOLD,20));
        IconBox.add(Box.createVerticalStrut(10));
        IconBox.add(uName);
        IconBox.setBounds(60,30,100,135);
        //组装用户名和头像
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(193,210,240));
        panel.add(IconBox);

        //聊天列表框
        JLabel listText = new JLabel("聊天列表");
        panel.add(listText);
        listText.setBounds(80,100,200,200);
        JScrollPane js = new JScrollPane();
        js.getViewport().add(jl_1,null);
        panel.add(js);
        js.setBounds(10,210,210,335);
        //添加删除按钮
        Box bBox = Box.createHorizontalBox();
        bBox.add(refresh);
        bBox.add(Box.createHorizontalStrut(10));
        bBox.add(del);
        panel.add(bBox);
        bBox.setBounds(23,467,200,200);

        //右侧消息框和输入框

        jTextArea_1.setEditable(false);//消息框只读
        JScrollPane js1 = new JScrollPane();//消息框滚动条
        js1.getViewport().add(jTextArea_1);
        JScrollPane js2 = new JScrollPane();
        js2.getViewport().add(jTextArea_2);
        JButton send = new JButton("发送");//发送按钮
        Box b1 = Box.createVerticalBox();//用于放置消息框
        b1.add(js1);
        panel.add(b1);
        b1.setBounds(230,10,540,350);
        Box b2 = Box.createHorizontalBox();//用于放置输入框和发送按钮
        b2.add(js2);
        panel.add(b2);
        panel.add(send);
        b2.setBounds(230,370,540,175);
        send.setBounds(240,555,520,25);

        this.add(panel);
        this.setVisible(true);

        send.addActionListener(e -> ChatBoxFrame.sendButton(this));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new ChatBoxFrame().exit();
                System.exit(0);
            }
        });
        refresh.addActionListener(e -> ChatBoxFrame.refresh());//刷新用户列表按钮事件处理
    }
    public void setUserName(String UserName){
        uName.setText(UserName);
    }

    public static void main(String[] args){
            new MainFrame().Init();
    }
}