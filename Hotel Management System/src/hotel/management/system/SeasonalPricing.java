//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeasonalPricing extends JFrame {

    private JPanel contentPane;

    public SeasonalPricing() {
       
        setTitle("Seasonal Pricing Management");
        setBounds(600, 250, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

       
        JLabel lblTitle = new JLabel("Seasonal Pricing", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setForeground(new Color(0, 51, 102));
        contentPane.add(lblTitle, BorderLayout.NORTH);

       
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.add(formPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        
        JLabel lblBasePrice = new JLabel("Base Price ($): ");
        lblBasePrice.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblBasePrice, gbc);

        JTextField basePriceField = new JTextField();
        basePriceField.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(basePriceField, gbc);

        // Peak Season Multiplier Label and Spinner
        JLabel lblPeakMultiplier = new JLabel("Peak Season Multiplier: ");
        lblPeakMultiplier.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(lblPeakMultiplier, gbc);

        SpinnerNumberModel peakModel = new SpinnerNumberModel(1.0, 1.0, 5.0, 0.1);
        JSpinner peakSpinner = new JSpinner(peakModel);
        peakSpinner.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(peakSpinner, gbc);

        
        JLabel lblEventMultiplier = new JLabel("Local Event Multiplier: ");
        lblEventMultiplier.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(lblEventMultiplier, gbc);

        SpinnerNumberModel eventModel = new SpinnerNumberModel(1.0, 1.0, 5.0, 0.1);
        JSpinner eventSpinner = new JSpinner(eventModel);
        eventSpinner.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 1;
        formPanel.add(eventSpinner, gbc);

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JButton btnSave = new JButton("Save Pricing");
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));
        btnSave.setBackground(new Color(0, 153, 76));
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String basePrice = basePriceField.getText();
                double peakMultiplier = (double) peakSpinner.getValue();
                double eventMultiplier = (double) eventSpinner.getValue();

                
                JOptionPane.showMessageDialog(SeasonalPricing.this,
                        "Seasonal pricing saved successfully!\n" +
                                "Base Price: $" + basePrice + "\n" +
                                "Peak Season Multiplier: " + peakMultiplier + "\n" +
                                "Local Event Multiplier: " + eventMultiplier);
            }
        });
        buttonPanel.add(btnSave);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              
                dispose();
            }
        });
        buttonPanel.add(btnCancel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new SeasonalPricing();
    }
}
