//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Billing extends JFrame implements ActionListener {

    private JTextField customerIdField, roomChargesField, serviceChargesField, taxField, totalField;
    private JButton calculateBtn, clearBtn, backBtn;

    public Billing() {
        setTitle("Hotel Billing System");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

       
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        add(mainPanel);

       
        JLabel header = new JLabel("Hotel Billing System", JLabel.CENTER);
        header.setFont(new Font("Segoe UI", Font.BOLD, 26));
        header.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(header, BorderLayout.NORTH);

        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 16);
        Font fieldFont = new Font("Segoe UI", Font.PLAIN, 16);

        String[] labels = { "Customer ID:", "Room Charges:", "Service Charges:", "Tax (%):", "Total Amount:" };
        JTextField[] fields = {
            customerIdField = new JTextField(),
            roomChargesField = new JTextField(),
            serviceChargesField = new JTextField(),
            taxField = new JTextField(),
            totalField = new JTextField()
        };
        totalField.setEditable(false);

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            JLabel label = new JLabel(labels[i]);
            label.setFont(labelFont);
            formPanel.add(label, gbc);

            gbc.gridx = 1;
            fields[i].setFont(fieldFont);
            fields[i].setPreferredSize(new Dimension(200, 30));
            formPanel.add(fields[i], gbc);
        }

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        calculateBtn = new JButton("Calculate");
        clearBtn = new JButton("Clear");
        backBtn = new JButton("Back");

        JButton[] buttons = { calculateBtn, clearBtn, backBtn };
        Color[] colors = { new Color(0, 123, 255), new Color(108, 117, 125), new Color(40, 167, 69) };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(new Font("Segoe UI", Font.BOLD, 14));
            buttons[i].setBackground(colors[i]);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setFocusPainted(false);
            buttons[i].setPreferredSize(new Dimension(120, 35));
            buttonPanel.add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateBtn) {
            try {
                double room = Double.parseDouble(roomChargesField.getText());
                double service = Double.parseDouble(serviceChargesField.getText());
                double tax = Double.parseDouble(taxField.getText());

                double total = room + service + (tax / 100) * (room + service);
                totalField.setText(String.format("%.2f", total));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numeric values", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearBtn) {
            customerIdField.setText("");
            roomChargesField.setText("");
            serviceChargesField.setText("");
            taxField.setText("");
            totalField.setText("");
        } else if (e.getSource() == backBtn) {
            setVisible(false);
            new Reception(); 
        }
    }

    public static void main(String[] args) {
        new Billing();
    }
}
