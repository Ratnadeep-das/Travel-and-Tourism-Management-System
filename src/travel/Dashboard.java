package travel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame  implements ActionListener{

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, checkPackages, bookPackages, viewPackages, viewHotels, Destinations, bookHotels, viewBookedHotel, Payment, Calculator, Notepad, About, deletePersonalDetails;
    String user;
    Dashboard(String user){
        this.user = user;
        //setSize(1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 60);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(new Rectangle(5,0, 70,70));
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 60, 300, 900);
        add(p2);

        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0, 0 , 300, 40);
        addPersonalDetails.setBackground(new Color(0, 0, 102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        addPersonalDetails.setHorizontalAlignment(SwingConstants.LEFT);
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0, 40 , 300, 40);
        updatePersonalDetails.setBackground(new Color(0, 0, 102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        updatePersonalDetails.setHorizontalAlignment(SwingConstants.LEFT);
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0, 80 , 300, 40);
        viewPersonalDetails.setBackground(new Color(0, 0, 102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPersonalDetails.setHorizontalAlignment(SwingConstants.LEFT);
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0, 120 , 300, 40);
        deletePersonalDetails.setBackground(new Color(0, 0, 102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        deletePersonalDetails.setHorizontalAlignment(SwingConstants.LEFT);
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages = new JButton("Check Packages");
        checkPackages.setBounds(0, 160 , 300, 40);
        checkPackages.setBackground(new Color(0, 0, 102));
        checkPackages.setForeground(Color.WHITE);
        checkPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        checkPackages.setHorizontalAlignment(SwingConstants.LEFT);
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackages = new JButton("Book Package");
        bookPackages.setBounds(0, 200 , 300, 40);
        bookPackages.setBackground(new Color(0, 0, 102));
        bookPackages.setForeground(Color.WHITE);
        bookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookPackages.setHorizontalAlignment(SwingConstants.LEFT);
        bookPackages.addActionListener(this);
        p2.add(bookPackages);

        viewPackages = new JButton("View Package");
        viewPackages.setBounds(0, 240 , 300, 40);
        viewPackages.setBackground(new Color(0, 0, 102));
        viewPackages.setForeground(Color.WHITE);
        viewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewPackages.setHorizontalAlignment(SwingConstants.LEFT);
        viewPackages.addActionListener(this);
        p2.add(viewPackages);

        viewHotels = new JButton("View Hotel");
        viewHotels.setBounds(0, 280 , 300, 40);
        viewHotels.setBackground(new Color(0, 0, 102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewHotels.setHorizontalAlignment(SwingConstants.LEFT);
        viewHotels.addActionListener(this);
        p2.add(viewHotels);

        bookHotels = new JButton("Book Hotel");
        bookHotels.setBounds(0, 320 , 300, 40);
        bookHotels.setBackground(new Color(0, 0, 102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        bookHotels.setHorizontalAlignment(SwingConstants.LEFT);
        bookHotels.addActionListener(this);
        p2.add(bookHotels);

        viewBookedHotel = new JButton("View Booked Hotel");
        viewBookedHotel.setBounds(0, 360 , 300, 40);
        viewBookedHotel.setBackground(new Color(0, 0, 102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        viewBookedHotel.setHorizontalAlignment(SwingConstants.LEFT);
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        Destinations = new JButton("Destinations");
        Destinations.setBounds(0, 400 , 300, 40);
        Destinations.setBackground(new Color(0, 0, 102));
        Destinations.setForeground(Color.WHITE);
        Destinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Destinations.setHorizontalAlignment(SwingConstants.LEFT);
        Destinations.addActionListener(this);
        p2.add(Destinations);

        Payment = new JButton("Payment");
        Payment.setBounds(0, 440 , 300, 40);
        Payment.setBackground(new Color(0, 0, 102));
        Payment.setForeground(Color.WHITE);
        Payment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Payment.setHorizontalAlignment(SwingConstants.LEFT);
        Payment.addActionListener(this);
        p2.add(Payment);

        Calculator = new JButton("Calculator");
        Calculator.setBounds(0, 480 , 300, 40);
        Calculator.setBackground(new Color(0, 0, 102));
        Calculator.setForeground(Color.WHITE);
        Calculator.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Calculator.setHorizontalAlignment(SwingConstants.LEFT);
        Calculator.addActionListener(this);
        p2.add(Calculator);

        Notepad = new JButton("Notepad");
        Notepad.setBounds(0, 520 , 300, 40);
        Notepad.setBackground(new Color(0, 0, 102));
        Notepad.setForeground(Color.WHITE);
        Notepad.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Notepad.setHorizontalAlignment(SwingConstants.LEFT);
        Notepad.addActionListener(this);
        p2.add(Notepad);

        About = new JButton("About");
        About.setBounds(0, 560 , 300, 40);
        About.setBackground(new Color(0, 0, 102));
        About.setForeground(Color.WHITE);
        About.setFont(new Font("Tahoma", Font.PLAIN, 20));
        About.setHorizontalAlignment(SwingConstants.LEFT);
        About.addActionListener(this);
        p2.add(About);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i4 = i3.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i4));
        image.setBounds(new Rectangle(0,0, 1650,1000));
        add(image);

        JLabel text = new JLabel("Travel & Tourism Management");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN,55));
        image.add(text);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(user);
        } else if (ae.getSource() == viewPersonalDetails){
            new ViewCustomer(user); 
        } else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(user);
        } else if(ae.getSource() == checkPackages){
            new CheckPackage();
        } else if(ae.getSource() == bookPackages){
            new BookPackage(user);
        } else if(ae.getSource() == viewPackages){
            new ViewPackage(user);
        } else if(ae.getSource() == viewHotels){
            new CheckHotels();
        } else if(ae.getSource() == Destinations){
            new Destinations();
        } else if(ae.getSource() == bookHotels){
            new BookHotel(user);
        } else if(ae.getSource() == viewBookedHotel){
            new ViewHotel(user);
        } else if(ae.getSource() == Payment){
            new Payment();
        } else if(ae.getSource() == Calculator){
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else if(ae.getSource() == Notepad){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();// TODO: handle exception
            }
        } else if(ae.getSource() == About){
            new About();
        } else if(ae.getSource() == deletePersonalDetails){
            new DeleteDetails(user);
        }
    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
