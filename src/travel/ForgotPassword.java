package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ForgotPassword extends JFrame implements ActionListener{

    JButton Search, Retrieve;
    JTextField tflbl, tfname, tfpass, tfans;
    Choice security;

    ForgotPassword(){
        setSize(850, 380);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel lbl = new JLabel("Username:");
        lbl.setBounds(40, 40, 100, 25);
        lbl.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(lbl);

        tflbl = new JTextField();
        tflbl.setBounds(150, 40, 225, 25);
        tflbl.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tflbl);

        Search = new JButton("Search");
        Search.setBackground(Color.GRAY);
        Search.setForeground(Color.WHITE);
        Search.setBounds(390, 40, 100, 25);
        Search.addActionListener(this);
        p1.add(Search);

        JLabel name = new JLabel("Name:");
        name.setBounds(40, 80, 100, 25);
        name.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(150, 80, 225, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel sec = new JLabel("Security Question:");
        sec.setBounds(40, 120, 100, 25);
        sec.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(sec);

        security = new Choice();
        security.add("Who is your favorite historical figure?");
        security.add("Who is your favourite Marvel Character?");
        security.add("What is your lucky number?");
        security.add("What is your favourite movie?");
        security.setBounds(150, 120, 225, 25);
        p1.add(security);

        JLabel answer = new JLabel("Answer:");
        answer.setBounds(40, 160, 100, 25);
        answer.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(answer);

        tfans = new JTextField();
        tfans.setBounds(150, 160, 225, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        Retrieve = new JButton("Retrieve");
        Retrieve.setBackground(Color.GRAY);
        Retrieve.setForeground(Color.WHITE);
        Retrieve.setBounds(390, 160, 100, 25);
        Retrieve.addActionListener(this);
        p1.add(Retrieve);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(40, 200, 100, 25);
        pass.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(pass);

        tfpass = new JTextField();
        tfpass.setBounds(150, 200, 225, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(580, 70, 200,200);
        add(image);

        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Search) {
            try {
                String query = "select * from account where Username = '"+tflbl.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfname.setText(rs.getString("Name"));
                    security.select(rs.getString("Security"));
                }
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else if (ae.getSource() == Retrieve){
            try {
                String query = "select * from account where Answer = '"+tfans.getText()+"' AND Username = '"+tflbl.getText()+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Your Password is "+ rs.getString("Password"));
                setVisible(false);
                new Login();
                }
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
            
        }
    }
    public static void main(String[] args) {
        new ForgotPassword();
    }
}
