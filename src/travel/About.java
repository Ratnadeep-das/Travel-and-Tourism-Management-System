package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class About extends JFrame implements ActionListener{
    
    About(){
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel about =  new JLabel("ABOUT");
        about.setBounds(80, 50, 300, 25);
        about.setForeground(Color.RED);
        about.setFont(new Font("Tahoma", Font.BOLD, 30));
        add(about);

        String s = "                                    About Project          \n" + //
                        "----------------------------------------------------------------------------------------------------------- \r\n" + //
                        "\n" + //
                        "The objective of the Travel and Tourism Management System\r\n" + //
                        "project is to develop a system that automates the processes\r\n" + //
                        "and activities of a travel and the purpose is to design a\r\n" + //
                        "system using which one can perform all operations related to\r\n" + //
                        "traveling.\n" + //
                        "\n" + //
                        "\r\n" + //
                        "This application will help in accessing the information related\r\n" + //
                        "to the travel to the particular destination with great ease.\r\n" + //
                        "The users can track the information related to their tours with\r\n" + //
                        "great ease through this application. The travel agency information\r\n" + //
                        "can also be obtained through this application.\n" + //
                        "\n" + //
                        "\r\n" + //
                        "Advantages of Project:\r\n" + //
                        "                \n" + //
                        "Gives accurate information\r\n" + //
                        "" + //
                        "Simplifies the manual work\r\n" + //
                        "" + //
                        "It minimizes the documentation related work\r\n" + //
                        "" + //
                        "Provides up to date information\r\n" + //
                        "" + //
                        "Friendly Environment by providing warning messages.\r\n" + //
                        "" + //
                        "Travelers details can be provided\r\n" + //
                        "" + //
                        "Booking confirmation notification";

        TextArea area = new TextArea(s,10, 40, Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20, 100, 450, 300);
        add(area);

        JButton Back = new JButton();
        Back.setBounds(200, 480, 100, 25);
        Back.addActionListener(this);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
