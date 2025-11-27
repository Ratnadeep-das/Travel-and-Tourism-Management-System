package travel;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    Thread thread;
    Splash(){
        // setSize(1200, 600);
        // setLocationRelativeTo(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        add(image);

        setVisible(true);
        thread=new Thread(this);
        thread.start();
        

    }

    public void run(){
        try {
            Thread.sleep(5000);
//            new Login;
            setVisible(false);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public static void main(String[] args) {
        Splash frame = new Splash();

        int x = 1;
        for (int i = 0; i < 500; x+=7, i+=6) {
            frame.setLocationRelativeTo(null);;
            frame.setSize(x+i, i);
            try {
                Thread.sleep(30);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }
}
