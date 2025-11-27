package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;;
public class ViewPackage extends JFrame implements ActionListener {
    JButton Back;
    ViewPackage(String user){
        setSize(870, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel book =  new JLabel("VIEW PACKAGE");
        book.setBounds(80, 50, 300, 25);
        book.setForeground(Color.BLACK);
        book.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(book);

        JLabel lbluser =  new JLabel("Username");
        lbluser.setBounds(30, 100, 150, 25);
        add(lbluser);

        JLabel labeluser =  new JLabel();
        labeluser.setBounds(220, 100, 150, 25);
        add(labeluser);

        JLabel lblpackage =  new JLabel("Package");
        lblpackage.setBounds(30, 140, 150, 25);
        add(lblpackage); 

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 140, 150, 25);
        add(labelpackage);

        JLabel lblpeople =  new JLabel("Number of People");
        lblpeople.setBounds(30, 180, 150, 25);
        add(lblpeople);  

        JLabel tfnum = new JLabel();
        tfnum.setBounds(220, 180, 150, 25);
        add(tfnum);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 220, 150, 25);
        add(lblid);

        JLabel labelid =  new JLabel();
        labelid.setBounds(220, 220, 150, 25);
        add(labelid);

        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 260, 150, 25);
        add(lblnumber);
        
        JLabel number = new JLabel();
        number.setBounds(220, 260, 70, 25);
        add(number);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 300, 150, 25);
        add(lblphone);   

        JLabel tfphone = new JLabel();
        tfphone.setBounds(220, 300, 150, 25);
        add(tfphone);

        JLabel lbltotal =  new JLabel("Total Price");
        lbltotal.setBounds(30, 340, 150, 25);
        add(lbltotal);   

        JLabel tftotal = new JLabel();
        tftotal.setBounds(220, 340, 150, 25);
        add(tftotal);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(220, 430, 100, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
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
            ResultSet rs = conn.s.executeQuery("select * from bookpackage where Username =  '" + user + "'");
            while(rs.next()){
                labeluser.setText(rs.getString("Username"));
                labelpackage.setText(rs.getString("Package"));
                tfnum.setText(rs.getString("Number_Of_People"));
                labelid.setText(rs.getString("ID"));
                number.setText(rs.getString("Number"));
                tfphone.setText(rs.getString("Phone"));
                tftotal.setText(rs.getString("Price"));
            }
        } catch (Exception e) {
            
        }
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("");
    }
}
