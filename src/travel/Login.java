package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Login extends JFrame implements ActionListener{

    JButton login, signup, password;
    JLabel lbl, pass;
    JTextField tfpass, tflbl;

    Login(){
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(new Rectangle(100,120, 200,200));
        p1.add(image);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        lbl = new JLabel("Username:");
        lbl.setBounds(60, 20, 100, 25);
        lbl.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
        p2.add(lbl);

        tflbl = new JTextField();
        tflbl.setBounds(60, 60, 300, 30);
        tflbl.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tflbl);


        pass = new JLabel("Password:");
        pass.setBounds(60, 110, 100, 25);
        pass.setFont(new Font("SANS SERIF", Font.PLAIN, 20));
        p2.add(pass);

        tfpass = new JTextField();
        tfpass.setBounds(60, 150, 300, 30);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpass);

        login = new JButton("Login");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(131, 193, 233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("Sign Up");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(131, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        password = new JButton("Forgot Password");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(131, 193, 233)));
        password.addActionListener(this);
        p2.add(password);
        
        JLabel text = new JLabel("Trouble signing in?");
        text.setBounds(140, 280, 150, 20);
        text.setForeground(Color.red);
        p2.add(text);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login) {
            try {
                String username = tflbl.getText();
                String passwordString = tfpass.getText();

                String query = "select * from account where Username = '"+username+"' AND Password = '"+passwordString+"'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Loading(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username OR Password");
                }
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
            
        } else if (ae.getSource() == signup){
            setVisible(false);
            new SignUp();
        } else if (ae.getSource() == password){
            setVisible(false);
            new ForgotPassword();
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
