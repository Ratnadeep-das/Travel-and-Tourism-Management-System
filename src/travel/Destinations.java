package travel;

import java.awt.*;
import javax.swing.*;

public class Destinations extends JFrame implements Runnable{

    Thread t1;
    JLabel[] icon = new JLabel[10];
    JLabel caption;
    public void run(){
        
        try {
            for (int i = 0; i < 10; i++) {
                icon[i].setVisible(true);
                
                Thread.sleep(2500);
                icon[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
    Destinations() {
        setSize(870, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[10];
        
        for (int i = 0; i < 10; i++) {
            String base = "icons/dest"+(i+1);

            java.net.URL url = ClassLoader.getSystemResource(base + ".jpg");
            if (url == null) 
                url = ClassLoader.getSystemResource(base + ".png");
            if (url == null) 
                url = ClassLoader.getSystemResource(base + ".jpeg");
            
            image[i] = new ImageIcon(url);
            Image i2 = image[i].getImage().getScaledInstance(870, 625, Image.SCALE_DEFAULT);
            icon[i] = new JLabel(new ImageIcon(i2));
            icon[i].setBounds(new Rectangle(0,0, 870,625));
            add(icon[i]);
        }
        t1 = new Thread(this);
        t1.start();

        setVisible(true);

    }
    

    public static void main(String[] args) {
        new Destinations();
    }
}
