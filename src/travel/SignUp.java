package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener{

    JButton Create, Back;
    JTextField tflbl, tfname, tfpass, tfans;
    Choice security;

    SignUp(){
        setSize(800, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JPanel p1= new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        JLabel lbl = new JLabel("Username:");
        lbl.setBounds(40, 40, 100, 25);
        lbl.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(lbl);

        tflbl = new JTextField();
        tflbl.setBounds(150, 40, 225, 25);
        tflbl.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tflbl);

        JLabel name = new JLabel("Name:");
        name.setBounds(40, 80, 100, 25);
        name.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(name);

        tfname = new JTextField();
        tfname.setBounds(150, 80, 225, 25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(40, 120, 100, 25);
        pass.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(pass);

        tfpass = new JTextField();
        tfpass.setBounds(150, 120, 225, 25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpass);

        JLabel sec = new JLabel("Security Question:");
        sec.setBounds(40, 160, 100, 25);
        sec.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(sec);

        security = new Choice();
        security.add("Who is your favorite historical figure?");
        security.add("Who is your favourite Marvel Character?");
        security.add("What is your lucky number?");
        security.add("What is your favourite movie?");
        security.setBounds(150, 160, 225, 25);
        p1.add(security);

        JLabel answer = new JLabel("Answer:");
        answer.setBounds(40, 200, 100, 25);
        answer.setFont(new Font("SANS SERIF", Font.BOLD, 18));
        p1.add(answer);

        tfans = new JTextField();
        tfans.setBounds(150, 200, 225, 25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        Create = new JButton("Create");
        Create.setBackground(Color.WHITE);
        Create.setForeground(new Color(133, 193, 233));
        Create.setBounds(80, 250, 130, 30);
        Create.addActionListener(this);
        p1.add(Create);

        Back = new JButton("Back");
        Back.setBackground(Color.WHITE);
        Back.setForeground(new Color(133, 193, 233));
        Back.setBounds(250, 250, 130, 30);
        Back.addActionListener(this);
        p1.add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(new Rectangle(480,120, 200,200));
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Create) {
            String username = tflbl.getText();
            String name = tfname.getText();
            String password = tfpass.getText();
            String question = security.getSelectedItem();
            String answer = tfans.getText();

            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false);
                new Login();
                
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else if(ae.getSource() == Back) {
            setVisible(false);
            new Login();
            
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
