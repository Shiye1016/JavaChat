package QQ.EvePro;

import Frame.Main.MainFrame;
import QQ.UserClientService.UserClientService;
import QQ.qqclient.view.QQView;

import javax.swing.*;
import java.awt.*;

//用于事件响应
public class EventProcessing {
    //发送按钮事件
    public static void sendButton(JTextArea jTextArea_1, JTextArea jTextArea_2){
        if(!jTextArea_2.getText().equals("")){
                jTextArea_1.append(jTextArea_2.getText() + "\n");
                jTextArea_2.setText("");
        }
    }

    //登录按钮
    public static void LoginBtn(JTextField uName, JTextField pwd,JFrame jFrame){
        if(!(new UserClientService().checkUser(uName.getText(),pwd.getText()))){
            JOptionPane.showMessageDialog(null,"账号或密码错误","登录失败", JOptionPane.ERROR_MESSAGE);
        }else{
            jFrame.dispose();
            MainFrame mainFrame = new MainFrame();
            mainFrame.Init();
            mainFrame.setUserName("用户 " + uName.getText());//实现登录后用户名显示为登录时的用户名
            QQView qqView = new QQView();
            qqView.mainMenu();


        }
    }

    //
}

