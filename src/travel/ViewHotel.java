package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;;
public class ViewHotel extends JFrame implements ActionListener {
    JButton Back;
    ViewHotel(String user){
        setSize(870, 625);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel book =  new JLabel("VIEW BOOKED HOTEL");
        book.setBounds(80, 50, 400, 25);
        book.setForeground(Color.BLACK);
        book.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(book);

        JLabel lbluser =  new JLabel("Username");
        lbluser.setBounds(30, 100, 150, 25);
        add(lbluser);

        JLabel labeluser =  new JLabel();
        labeluser.setBounds(220, 100, 150, 25);
        add(labeluser);

        JLabel lblpackage =  new JLabel("Hotel");
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

        JLabel lbldays =  new JLabel("Number of Days");
        lbldays.setBounds(30, 220, 150, 25);
        add(lbldays);  

        JLabel tfdays = new JLabel();
        tfdays.setBounds(220, 220, 150, 25);
        add(tfdays);

        JLabel lblac =  new JLabel("AC/Non-AC");
        lblac.setBounds(30, 260, 150, 25);
        add(lblac);  

        JLabel tfac = new JLabel();
        tfac.setBounds(220, 260, 150, 25);
        add(tfac);

        JLabel lblfood =  new JLabel("Food");
        lblfood.setBounds(30, 300, 150, 25);
        add(lblfood);  

        JLabel tffood = new JLabel();
        tffood.setBounds(220, 300, 150, 25);
        add(tffood);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 340, 150, 25);
        add(lblid);

        JLabel labelid =  new JLabel();
        labelid.setBounds(220, 340, 150, 25);
        add(labelid);

        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 380, 150, 25);
        add(lblnumber);
        
        JLabel number = new JLabel();
        number.setBounds(220, 380, 70, 25);
        add(number);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 420, 150, 25);
        add(lblphone);   

        JLabel tfphone = new JLabel();
        tfphone.setBounds(220, 420, 150, 25);
        add(tfphone);

        JLabel lbltotal =  new JLabel("Total Price");
        lbltotal.setBounds(30, 460, 150, 25);
        add(lbltotal);   

        JLabel tftotal = new JLabel();
        tftotal.setBounds(220, 460, 150, 25);
        add(tftotal);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(220, 500, 100, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(400,80, 450,420));
        add(icon);

        /*ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i4 = i1.getImage().getScaledInstance(500, 200, Image.SCALE_DEFAULT);
        JLabel icon2 = new JLabel(new ImageIcon(i4));
        icon2.setBounds(new Rectangle(400,300, 450,420));
        add(icon2);*/
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bookhotel where Username =  '" + user + "'");
            while(rs.next()){
                labeluser.setText(rs.getString("Username"));
                labelpackage.setText(rs.getString("Name"));
                tfnum.setText(rs.getString("Number_Of_People"));
                tfdays.setText(rs.getString("Number_Of_Days"));
                tfac.setText(rs.getString("AC"));
                tffood.setText(rs.getString("Food"));
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
        new ViewHotel("");
    }
}
