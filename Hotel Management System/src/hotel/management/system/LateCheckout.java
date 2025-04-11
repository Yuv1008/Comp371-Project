//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LateCheckout extends JFrame {
    private JTextField txtGuestName, txtRoomNumber, txtOriginalCheckout, txtNewCheckout;
    private JLabel lblExtraCharges;

    public LateCheckout() {
        setTitle("Late Check-Out Management");
        setBounds(450, 180, 600, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblHeader = new JLabel("Late Check-Outs");
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setBounds(150, 20, 300, 40);
        add(lblHeader);

        
        addField("Guest Name:", 80, txtGuestName = new JTextField());
        addField("Room Number:", 130, txtRoomNumber = new JTextField());
        addField("Original Checkout (yyyy-MM-dd HH:mm):", 180, txtOriginalCheckout = new JTextField());
        addField("New Checkout (yyyy-MM-dd HH:mm):", 230, txtNewCheckout = new JTextField());

      
        JButton btnCalculate = new JButton("Calculate Charges");
        btnCalculate.setBounds(60, 290, 180, 35);
        btnCalculate.setBackground(new Color(34, 139, 34));
        btnCalculate.setForeground(Color.WHITE);
        btnCalculate.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnCalculate);

     
        lblExtraCharges = new JLabel("Extra Charges: $0.00");
        lblExtraCharges.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblExtraCharges.setBounds(270, 290, 250, 35);
        add(lblExtraCharges);

       
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.setBounds(150, 340, 120, 35);
        btnConfirm.setBackground(new Color(0, 120, 215));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnConfirm);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setBounds(300, 340, 120, 35);
        btnCancel.setBackground(Color.GRAY);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        add(btnCancel);

       
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                    LocalDateTime original = LocalDateTime.parse(txtOriginalCheckout.getText(), formatter);
                    LocalDateTime updated = LocalDateTime.parse(txtNewCheckout.getText(), formatter);

                    long hoursLate = ChronoUnit.HOURS.between(original, updated);
                    double extraCharge = 0.0;

                    if (hoursLate > 0) {
                        extraCharge = hoursLate * 10.0; 
                    }

                    lblExtraCharges.setText("Extra Charges: $" + String.format("%.2f", extraCharge));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please use date format: yyyy-MM-dd HH:mm");
                }
            }
        });

        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Late check-out confirmed and charges applied.");
                dispose();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void addField(String labelText, int y, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        label.setBounds(60, y, 250, 25);
        add(label);

        textField.setBounds(310, y, 200, 25);
        textField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(textField);
    }

    public static void main(String[] args) {
        new LateCheckout().setVisible(true);
    }
}
