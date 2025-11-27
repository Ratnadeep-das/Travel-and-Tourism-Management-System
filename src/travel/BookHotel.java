package travel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class BookHotel extends JFrame implements ActionListener{

    Choice Chotel, CAC, Cfood;
    JTextField tfpeople, tfdays;
    String user;
    JLabel labeluser, labelid, number, tfphone, tftotal;
    JButton CheckPrice, BookHotel, Back;
    BookHotel(String user) {
        this.user = user;
        setSize(850, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel book =  new JLabel("BOOK HOTEL");
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

        JLabel lblpackage =  new JLabel("Select Hotel");
        lblpackage.setBounds(30, 140, 150, 25);
        add(lblpackage); 

        Chotel = new Choice();
        /*Cpackage.add("GOLD PACKAGE");
        Cpackage.add("SILVER PACKAGE");
        Cpackage.add("BRONZE PACKAGE");*/
        Chotel.setBounds(220, 140, 150, 25);
        add(Chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                Chotel.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }

        JLabel lblpeople =  new JLabel("Number of People");
        lblpeople.setBounds(30, 180, 150, 25);
        add(lblpeople);   

        tfpeople = new JTextField("1");
        tfpeople.setBounds(220, 180, 150, 25);
        add(tfpeople);

        JLabel lbldays =  new JLabel("Number of Days");
        lbldays.setBounds(30, 220, 150, 25);
        add(lbldays);   

        tfdays = new JTextField("1");
        tfdays.setBounds(220, 220, 150, 25);
        add(tfdays);

        JLabel lblac =  new JLabel("AC/Non-AC");
        lblac.setBounds(30, 260, 150, 25);
        add(lblac);   

        CAC = new Choice();
        CAC.add("AC");
        CAC.add("Non-AC");
        CAC.setBounds(220, 260, 150, 25);
        add(CAC);

        JLabel lblfood =  new JLabel("Food");
        lblfood.setBounds(30, 300, 150, 25);
        add(lblfood);   

        Cfood = new Choice();
        Cfood.add("Included");
        Cfood.add("Excluded");
        Cfood.setBounds(220, 300, 150, 25);
        add(Cfood);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 340, 150, 25);
        add(lblid);

        labelid =  new JLabel();
        labelid.setBounds(220, 340, 150, 25);
        add(labelid);

        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 380, 150, 25);
        add(lblnumber);
        
        number = new JLabel();
        number.setBounds(220, 380, 70, 25);
        add(number);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 420, 150, 25);
        add(lblphone);   

        tfphone = new JLabel();
        tfphone.setBounds(220, 420, 150, 25);
        add(tfphone);

        JLabel lbltotal =  new JLabel("Total Price");
        lbltotal.setBounds(30, 460, 150, 25);
        add(lbltotal);   

        tftotal = new JLabel();
        tftotal.setBounds(220, 460, 150, 25);
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
        CheckPrice.setBounds(80, 500, 150, 25);
        CheckPrice.addActionListener(this);
        add(CheckPrice);

        BookHotel = new JButton("Book Hotel");
        BookHotel.setBackground(Color.BLACK);
        BookHotel.setForeground(Color.WHITE);
        BookHotel.setBounds(240, 500, 150, 25);
        BookHotel.addActionListener(this);
        add(BookHotel);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(400, 500, 150, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(400,40, 450,380));
        add(icon);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == CheckPrice){
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where Name='"+Chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("Cost_Per_Person"));
                    int ac = Integer.parseInt(rs.getString("AC"));
                    int food = Integer.parseInt(rs.getString("Food"));

                    int people = Integer.parseInt(tfpeople.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String ChoiceAC = CAC.getSelectedItem();
                    String ChoiceFood = Cfood.getSelectedItem();

                    if(people * days > 0){
                        int total = 0;
                        total += ChoiceAC.equals("AC") ? ac : 0;
                        total += ChoiceFood.equals("Included") ? food : 0;
                        total += cost;
                        total = total * people * days;
                        tftotal.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter A Valid Number");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else if(ae.getSource() == BookHotel){
            try {
                Conn c = new Conn();
                c.s.executeUpdate("INSERT INTO bookhotel VALUES ('" + labeluser.getText() + "', '" + Chotel.getSelectedItem() + "', '" + tfpeople.getText() + "', '" + tfdays.getText() + "', '" + CAC.getSelectedItem() + "', '" + Cfood.getSelectedItem() + "', '" + labelid.getText() + "', '" + number.getText() + "', '" + tfphone.getText() + "', '" + tftotal.getText() + "')");
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
               e.printStackTrace(); 
            }
        } else {
            setVisible(false);
        } 
    }
    public static void main(String[] args) {
        new BookHotel("");
    }
}
