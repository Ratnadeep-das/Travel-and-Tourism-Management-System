package travel;

import java.awt.*;
import javax.swing.*;
public class CheckPackage extends JFrame {

    CheckPackage() {
        setSize(850, 550);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(Color.WHITE);

        String[] package1 = new String[]{"GOLD PACKAGE","6 days and 7 Nights", "Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "@Summer Special", "Rs 12000 only", "package1.jpg"};
        String[] package2 = new String[]{"SILVER PACKAGE","4 days and 3 Nights", "Toll & Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "@Winter Special", "Rs 25000 only", "package2.jpg"};
        String[] package3 = new String[]{"BRONZE PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "@Winter Special", "Rs 32000 only", "package3.jpg"};
      
        JTabbedPane tab = new JTabbedPane();

        JPanel p1 = CreatePackage(package1);
        tab.addTab("Package 1", null, p1);

        JPanel p2 = CreatePackage(package2);
        tab.addTab("Package 2", null, p2);

        JPanel p3 = CreatePackage(package3);
        tab.addTab("Package 3", null, p3);
        
        
        add(tab);

        setVisible(true);
    }
    
    public JPanel CreatePackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);

        JLabel gold =  new JLabel(pack[0]);
        gold.setBounds(80, 50, 300, 25);
        if(pack[0].equals("GOLD PACKAGE"))
            gold.setForeground(Color.YELLOW);
        else if(pack[0].equals("SILVER PACKAGE"))
            gold.setForeground(Color.LIGHT_GRAY);
        else
            gold.setForeground(Color.DARK_GRAY);
        gold.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(gold);

        JLabel f1 =  new JLabel(pack[1]);
        f1.setBounds(20, 120, 300, 25);
        f1.setForeground(Color.RED);
        f1.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f1);

        JLabel f2 =  new JLabel(pack[2]);
        f2.setBounds(20, 160, 300, 25);
        f2.setForeground(Color.BLUE);
        f2.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f2);

        JLabel f3 =  new JLabel(pack[3]);
        f3.setBounds(20, 200, 300, 25);
        f3.setForeground(Color.RED);
        f3.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f3);

        JLabel f4 =  new JLabel(pack[4]);
        f4.setBounds(20, 240, 300, 25);
        f4.setForeground(Color.BLUE);
        f4.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f4);

        JLabel f5 =  new JLabel(pack[5]);
        f5.setBounds(20, 280, 300, 25);
        f5.setForeground(Color.RED);
        f5.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f5);

        JLabel f6 =  new JLabel(pack[6]);
        f6.setBounds(20, 320, 300, 25);
        f6.setForeground(Color.BLUE);
        f6.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f6);

        JLabel f7 =  new JLabel(pack[7]);
        f7.setBounds(20, 360, 300, 25);
        f7.setForeground(Color.RED);
        f7.setFont(new Font("Tahoma", Font.BOLD, 20));
        p1.add(f7);

        JLabel book =  new JLabel(pack[8]);
        book.setBounds(80, 430, 300, 50);
        book.setForeground(Color.BLACK);
        book.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(book);

        JLabel discount =  new JLabel(pack[9]);
        discount.setBounds(260, 430, 300, 50);
        discount.setForeground(Color.MAGENTA);
        discount.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(discount);

        JLabel price =  new JLabel(pack[10]);
        price.setBounds(580, 430, 300, 50);
        price.setForeground(Color.CYAN);
        price.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(price);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/" + pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(new Rectangle(320,120, 500,300));
        p1.add(image);

        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
