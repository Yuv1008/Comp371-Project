//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    Dashboard() {
        setBounds(0, 0, 1550, 1000);
        setLayout(null);

      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Hello.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 30, 1550, 1000);
        add(image);

      
        JLabel text = new JLabel("THE TAJ HOTELS WELCOMES YOU");
        text.setFont(new Font("Tahoma", Font.PLAIN, 46));
        text.setForeground(Color.WHITE);

       
        int x = (getWidth() - text.getPreferredSize().width) / 2;
        int y = (getHeight() - text.getPreferredSize().height) / 4; 
        text.setBounds(x, y, text.getPreferredSize().width, text.getPreferredSize().height);
        
        image.add(text);

     
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1550, 30);
        add(mb);

   
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.BLACK);
        mb.add(hotel);

        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);

      
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.BLUE);
        mb.add(admin);

        JMenuItem addemployee = new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem rooms = new JMenuItem("ADD ROOMS");
        rooms.addActionListener(this);
        admin.add(rooms);

        JMenuItem drivers = new JMenuItem("ADD DRIVERS");
        drivers.addActionListener(this);
        admin.add(drivers);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        } else if (command.equals("ADD ROOMS")) {
            new AddRooms().setVisible(true);
        } else if (command.equals("ADD DRIVERS")) {
            new AddDriver().setVisible(true);
        } else if (command.equals("RECEPTION")) {
            new Reception().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
