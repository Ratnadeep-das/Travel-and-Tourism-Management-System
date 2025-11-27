package travel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class UpdateCustomer extends JFrame  implements ActionListener{
    
    JLabel labeluser, labelname;
    JComboBox comboid;
    JTextField tfnum, tfcountry, tfaddr, tfphone, tfemail, tfgender;
    JRadioButton rmale, rfemale;
    JButton Update, Back;
    String user;

    UpdateCustomer(String user){
        this.user = user;

        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lbluser =  new JLabel("Username");
        lbluser.setBounds(30, 50, 150, 25);
        add(lbluser);

        labeluser =  new JLabel();
        labeluser.setBounds(220, 50, 150, 25);
        add(labeluser);

        JLabel lblid =  new JLabel("ID");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);   
        
        comboid = new JComboBox<>(new String []{"Passport", "Aadhar card", "PAN Card", "Voter ID", "Driving License"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid); 
        
        JLabel lblnumber =  new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);   

        tfnum = new JTextField();
        tfnum.setBounds(220, 130, 150, 25);
        add(tfnum);

        JLabel lblname =  new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname =  new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel lblgender =  new JLabel("Gender");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);
        
        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel lblcountry =  new JLabel("Country");
        lblcountry.setBounds(30, 250, 150, 25);
        add(lblcountry);   

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel lbladdr =  new JLabel("Address");
        lbladdr.setBounds(30, 290, 150, 25);
        add(lbladdr);   

        tfaddr = new JTextField();
        tfaddr.setBounds(220, 290, 150, 25);
        add(tfaddr);

        JLabel lblphone =  new JLabel("Phone");
        lblphone.setBounds(30, 330, 150, 25);
        add(lblphone);   

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel lblemail =  new JLabel("Email");
        lblemail.setBounds(30, 370, 150, 25);
        add(lblemail);   

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        Update = new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setBounds(70, 430, 100, 25);
        Update.addActionListener(this);
        add(Update);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(220, 430, 100, 25);
        Back.addActionListener(this);
        add(Back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(400,40, 450,420));
        add(icon);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where Username =  '" + user + "'");
            while (rs.next()){
                labeluser.setText(rs.getString("Username"));
                labelname.setText(rs.getString("Name"));
                comboid.setSelectedItem(rs.getString("ID"));
                tfnum.setText(rs.getString("Number"));
                String gender = rs.getString("Gender");
                if (gender.equalsIgnoreCase("Male")) {
                    rmale.setSelected(true);
                } else if (gender.equalsIgnoreCase("Female")) {
                    rfemale.setSelected(true);
                }
                tfcountry.setText(rs.getString("Country"));
                tfaddr.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == Update) {
            String username = labeluser.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfnum.getText();
            String name = labelname.getText();
            String gender = "";
            if (rmale.isSelected()) 
                gender = "Male";
            else if (rfemale.isSelected()) 
                gender = "Female";
            String country = tfcountry.getText();
            String addr = tfaddr.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "update customer set ID = '"+id+"', Number = '"+number+"', Name = '"+name+"', Gender = '"+gender+"', Country = '"+country+"', Address ='"+addr+"', Phone = '"+phone+"', Email = '"+email+"'"+ " WHERE Username = '" + username + "'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}