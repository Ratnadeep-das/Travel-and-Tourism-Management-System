package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;;
public class ViewCustomer extends JFrame implements ActionListener {
    JButton Back;
    ViewCustomer(String user){
        setSize(870, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lbluser =  new JLabel("Username");
        lbluser.setBounds(30, 50, 150, 25);
        add(lbluser);

        JLabel labeluser =  new JLabel();
        labeluser.setBounds(220, 50, 150, 25);
        add(labeluser);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid); 

        JLabel comboid = new JLabel();
        comboid.setBounds(220, 90, 150, 25);
        add(comboid);

        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);   

        JLabel tfnum = new JLabel();
        tfnum.setBounds(220, 130, 150, 25);
        add(tfnum);

        JLabel lblname =  new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        JLabel labelname =  new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender =  new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);
        
        JLabel gender = new JLabel();
        gender.setBounds(220, 210, 70, 25);
        add(gender);

        JLabel lblcountry =  new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);   

        JLabel tfcountry = new JLabel();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdr =  new JLabel("Address");
        lbladdr.setBounds(30, 290, 150, 25);
        add(lbladdr);   

        JLabel tfaddr = new JLabel();
        tfaddr.setBounds(220, 290, 150, 25);
        add(tfaddr);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);   

        JLabel tfphone = new JLabel();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail =  new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);   

        JLabel tfemail = new JLabel();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(220, 430, 100, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(400,40, 450,420));
        add(icon);

        /*ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i4 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        JLabel icon2 = new JLabel(new ImageIcon(i4));
        icon2.setBounds(new Rectangle(400,300, 450,420));
        add(icon2);*/
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer where Username =  '" + user + "'");
            while(rs.next()){
                labeluser.setText(rs.getString("Username"));
                comboid.setText(rs.getString("ID"));
                tfnum.setText(rs.getString("Number"));
                labelname.setText(rs.getString("Name"));
                gender.setText(rs.getString("Gender"));
                tfcountry.setText(rs.getString("Country"));
                tfaddr.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewCustomer("");
    }
}
