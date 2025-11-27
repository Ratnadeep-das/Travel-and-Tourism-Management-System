package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Payment extends JFrame implements ActionListener{

    JButton Pay, Back;

    Payment() {
        setSize(870, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(870, 625, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(0,0, 870,625));
        add(icon);

        Pay = new JButton("Pay");
        Pay.setBounds(70, 100, 100, 25);
        Pay.addActionListener(this);
        icon.add(Pay);

        Back = new JButton("Back");
        Back.setBounds(700, 100, 100, 25);
        Back.addActionListener(this);
        icon.add(Back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Pay){
            setVisible(false);
            new PayTM();
        }
        else
            setVisible(false);
    }
    
    public static void main(String[] args) {
        new Payment();
    }
}
