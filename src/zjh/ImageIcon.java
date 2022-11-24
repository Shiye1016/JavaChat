package zjh;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class ImageIcon extends JFrame{
    public ImageIcon() {
        setBounds(100,100,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();

        JLabel l=new JLabel("这是一个图片的标签");
            URL url=ImageIcon.class.getResource("images/123.jpg");//获取图片url 路径
        Icon icon=new javax.swing.ImageIcon(url);
        l.setIcon(icon);//这里才是添加图片的
        c.add(l);

        setVisible(true);
    }

    public static void main(String[] args)
    {
        new ImageIcon();
    }

}
