package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BookPackage extends JFrame implements ActionListener{

    Choice Cpackage;
    JTextField tfpeople;
    String user;
    JLabel labeluser, labelid, number, tfphone, tftotal;
    JButton CheckPrice, BookPackage, Back;
    BookPackage(String user) {
        this.user = user;
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel book =  new JLabel("BOOK PACKAGE");
        book.setBounds(80, 50, 300, 25);
        book.setForeground(Color.BLACK);
        book.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(book);

        JLabel lbluser =  new JLabel("Username");
        lbluser.setBounds(30, 100, 150, 25);
        add(lbluser);

        labeluser =  new JLabel();
        labeluser.setBounds(220, 100, 150, 25);
        add(labeluser);

        JLabel lblpackage =  new JLabel("Select Package");
        lblpackage.setBounds(30, 140, 150, 25);
        add(lblpackage); 

        Cpackage = new Choice();
        Cpackage.add("GOLD PACKAGE");
        Cpackage.add("SILVER PACKAGE");
        Cpackage.add("BRONZE PACKAGE");
        Cpackage.setBounds(220, 140, 150, 25);
        add(Cpackage);

        JLabel lblpeople =  new JLabel("Number of People");
        lblpeople.setBounds(30, 180, 150, 25);
        add(lblpeople);   

        tfpeople = new JTextField("1");
        tfpeople.setBounds(220, 180, 150, 25);
        add(tfpeople);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 220, 150, 25);
        add(lblid);

        labelid =  new JLabel();
        labelid.setBounds(220, 220, 150, 25);
        add(labelid);

        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 260, 150, 25);
        add(lblnumber);
        
        number = new JLabel();
        number.setBounds(220, 260, 70, 25);
        add(number);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 300, 150, 25);
        add(lblphone);   

        tfphone = new JLabel();
        tfphone.setBounds(220, 300, 150, 25);
        add(tfphone);

        JLabel lbltotal =  new JLabel("Total Price");
        lbltotal.setBounds(30, 340, 150, 25);
        add(lbltotal);   

        tftotal = new JLabel();
        tftotal.setBounds(220, 340, 150, 25);
        add(tftotal);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer where Username =  '" + user + "'");
            while(rs.next()){
                labeluser.setText(rs.getString("Username"));
                labelid.setText(rs.getString("ID"));
                number.setText(rs.getString("Number"));
                tfphone.setText(rs.getString("Phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        CheckPrice = new JButton("Check Price");
        CheckPrice.setBackground(Color.BLACK);
        CheckPrice.setForeground(Color.WHITE);
        CheckPrice.setBounds(80, 390, 150, 25);
        CheckPrice.addActionListener(this);
        add(CheckPrice);

        BookPackage = new JButton("Book Package");
        BookPackage.setBackground(Color.BLACK);
        BookPackage.setForeground(Color.WHITE);
        BookPackage.setBounds(240, 390, 150, 25);
        BookPackage.addActionListener(this);
        add(BookPackage);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(400, 390, 150, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(400,40, 450,380));
        add(icon);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == CheckPrice){
            String chosenPackage = Cpackage.getSelectedItem();
            int cost = 0;
            if(chosenPackage.equals("GOLD PACKAGE")){
                cost += 12000;
            } else if(chosenPackage.equals("SILVER PACKAGE")){
                cost += 25000;
            } else {
                cost += 32000;
            }
            int people = Integer.parseInt(tfpeople.getText());
            cost *= people;
            tftotal.setText("Rs " + cost);
        } else if(ae.getSource() == BookPackage){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookpackage VALUES ('" + labeluser.getText() + "', '" + Cpackage.getSelectedItem() + "', '" + tfpeople.getText() + "', '" + labelid.getText() + "', '" + number.getText() + "', '" + tfphone.getText() + "', '" + tftotal.getText() + "')");
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
               e.printStackTrace(); 
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new BookPackage("");
    }
}
