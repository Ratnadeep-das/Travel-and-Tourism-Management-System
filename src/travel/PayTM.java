package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PayTM extends JFrame implements ActionListener{
    
    PayTM(){
        setSize(870, 625);
        setLocationRelativeTo(null);
        //setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);

        try {
            pane.setPage("https://paytm.com/rent-payment");
        } catch (Exception e) {
            pane.setContentType("text/html"); 
            pane.setText("<html>Error 404: Could not load<html>");// TODO: handle exception
        }

        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);

        JButton Back = new JButton("Back");
        Back.setBounds(610, 20, 100, 25);
        Back.addActionListener(this);
        pane.add(Back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Payment();
    }

    public static void main(String[] args) {
        new PayTM();
    }
}
