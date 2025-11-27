package travel;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame  implements  Runnable{

    Thread t;
    JProgressBar bar;
    String user;

    public void run(){
        try {
            for (int i = 1; i <= 101; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();
                if (value < max) {
                    bar.setValue(bar.getValue() + 1);
                } else {
                    setVisible(false);
                    new Dashboard(user);
                }
                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
    Loading(String user){
        this.user = user;
        
        t = new Thread(this);

        setSize(650, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("Travel & Tourism");
        text.setBounds(150, 20, 400, 40);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Raleway", Font.BOLD, 35));
        add(text);

        JLabel loading = new JLabel("Loading, please wait...");
        loading.setBounds(200, 140, 300, 30);
        loading.setForeground(Color.DARK_GRAY);
        loading.setFont(new Font("Raleway", Font.BOLD, 20));
        add(loading);

        JLabel username = new JLabel("Welcome " + user);
        username.setBounds(20, 310, 400, 30);
        username.setForeground(Color.DARK_GRAY);
        username.setFont(new Font("Raleway", Font.BOLD, 30));
        add(username);


        bar = new JProgressBar();
        bar.setBounds(150, 100, 300, 35);
        bar.setStringPainted(true);
        add(bar);

        t.start();

        setVisible(true);
    }
    public static void main(String[] args) {
        new Loading("");
    }
}
