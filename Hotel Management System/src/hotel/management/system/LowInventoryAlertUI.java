//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class LowInventoryAlertUI extends JFrame {

    private JPanel contentPane;

    public LowInventoryAlertUI() {
        setTitle("Low Inventory Alerts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 200, 400, 300);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel label = new JLabel("Inventory Management");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setBounds(100, 20, 250, 30);
        contentPane.add(label);

        JButton checkButton = new JButton("Check Inventory");
        checkButton.setBounds(120, 80, 150, 40);
        checkButton.setBackground(Color.BLACK);
        checkButton.setForeground(Color.WHITE);
        contentPane.add(checkButton);

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkInventoryLevels(); 
            }
        });

        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    private void checkInventoryLevels() {
       
        HashMap<String, Integer> inventory = new HashMap<>();
        inventory.put("Toilet Paper", 5);
        inventory.put("Shampoo", 15);
        inventory.put("Towels", 2);
        inventory.put("Water Bottles", 20);

        StringBuilder lowItems = new StringBuilder();

        int threshold = 10; 

        for (String item : inventory.keySet()) {
            int qty = inventory.get(item);
            if (qty < threshold) {
                lowItems.append(item).append(" (").append(qty).append(" left)\n");
            }
        }

        if (lowItems.length() > 0) {
            JOptionPane.showMessageDialog(this,
                    "Low Inventory Alert:\n" + lowItems.toString(),
                    "Alert", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                    "All inventory items are sufficiently stocked!",
                    "Inventory Status", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new LowInventoryAlertUI();
    }
}
