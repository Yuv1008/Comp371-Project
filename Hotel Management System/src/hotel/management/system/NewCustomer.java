//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class NewCustomer extends JFrame {
    private JPanel contentPane;
    private JTextField t1, t2, t3, t5, t6;
    private JComboBox<String> comboBox;
    private JRadioButton r1, r2, r3;
    private Choice c1;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                NewCustomer frame = new NewCustomer();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public NewCustomer() {
        setBounds(530, 200, 850, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);

        JLabel lblTitle = new JLabel("NEW CUSTOMER FORM");
        lblTitle.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
        lblTitle.setBounds(118, 11, 260, 53);
        contentPane.add(lblTitle);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(35, 76, 200, 14);
        contentPane.add(lblId);

        comboBox = new JComboBox<>(new String[]{"Passport", "Voter ID", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);
        contentPane.add(comboBox);

        JLabel lblNumber = new JLabel("Number :");
        lblNumber.setBounds(35, 111, 200, 14);
        contentPane.add(lblNumber);

        t1 = new JTextField();
        t1.setBounds(271, 111, 150, 20);
        contentPane.add(t1);

        JLabel lblName = new JLabel("Name :");
        lblName.setBounds(35, 151, 200, 14);
        contentPane.add(lblName);

        t2 = new JTextField();
        t2.setBounds(271, 151, 150, 20);
        contentPane.add(t2);

        JLabel lblGender = new JLabel("Gender :");
        lblGender.setBounds(35, 191, 200, 14);
        contentPane.add(lblGender);

        r1 = new JRadioButton("Male");
        r1.setBackground(Color.WHITE);
        r1.setBounds(271, 191, 80, 20);
        contentPane.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 191, 80, 20);
        contentPane.add(r2);

        r3 = new JRadioButton("Others");
        r3.setBackground(Color.WHITE);
        r3.setBounds(440, 191, 80, 20);
        contentPane.add(r3);

        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        genderGroup.add(r3);

        JLabel lblCountry = new JLabel("Country :");
        lblCountry.setBounds(35, 231, 200, 14);
        contentPane.add(lblCountry);

        t3 = new JTextField();
        t3.setBounds(271, 231, 150, 20);
        contentPane.add(t3);

        JLabel lblRoom = new JLabel("Allocated Room Number :");
        lblRoom.setBounds(35, 274, 200, 14);
        contentPane.add(lblRoom);

        c1 = new Choice();
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT roomnumber FROM room WHERE availability = 'Available'");
            while (rs.next()) {
                c1.add(rs.getString("roomnumber"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error fetching room numbers: " + e.getMessage());
            e.printStackTrace();
        }
        c1.setBounds(271, 274, 150, 20);
        contentPane.add(c1);

        JLabel lblCheckIn = new JLabel("Checked-In :");
        lblCheckIn.setBounds(35, 316, 200, 14);
        contentPane.add(lblCheckIn);

        t5 = new JTextField();
        t5.setBounds(271, 316, 150, 20);
        contentPane.add(t5);

        JLabel lblDeposit = new JLabel("Deposit :");
        lblDeposit.setBounds(35, 359, 200, 14);
        contentPane.add(lblDeposit);

        t6 = new JTextField();
        t6.setBounds(271, 359, 150, 20);
        contentPane.add(t6);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(100, 430, 120, 30);
        btnAdd.setBackground(Color.BLACK);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.addActionListener(e -> addCustomer());
        contentPane.add(btnAdd);
    }

    private void addCustomer() {
        try {
            Conn c = new Conn();
            String gender = "";
            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {
                gender = "Female";
            } else if (r3.isSelected()) {
                gender = "Others";
            }

            String query1 = "INSERT INTO customer (document, number, name, gender, country, room, checkintime, deposit) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            String query2 = "UPDATE room SET availability = 'Occupied' WHERE roomnumber = ?";

            PreparedStatement pst1 = c.c.prepareStatement(query1);
            pst1.setString(1, comboBox.getSelectedItem().toString());
            pst1.setString(2, t1.getText());
            pst1.setString(3, t2.getText());
            pst1.setString(4, gender);
            pst1.setString(5, t3.getText());
            pst1.setString(6, c1.getSelectedItem());
            pst1.setString(7, t5.getText());
            pst1.setString(8, t6.getText());

            int rowsAffected1 = pst1.executeUpdate();

            if (rowsAffected1 > 0) {
                PreparedStatement pst2 = c.c.prepareStatement(query2);
                pst2.setString(1, c1.getSelectedItem());
                int rowsAffected2 = pst2.executeUpdate();

                if (rowsAffected2 > 0) {
                    JOptionPane.showMessageDialog(null, "Customer Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Room update failed.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Customer insertion failed.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
