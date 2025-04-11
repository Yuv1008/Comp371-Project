//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GroupReservationUI extends JFrame {
    private JPanel contentPane;
    private JTextField customerNameField;
    private JTextField numOfRoomsField;
    private JCheckBox sharedBillingCheckBox;
    private ArrayList<JPanel> roomPanels;
    private JTabbedPane tabbedPane;
    
    public GroupReservationUI() {
        setTitle("Group Reservation");
        setBounds(600, 250, 750, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

       
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(10, 10));

       
        JLabel lblTitle = new JLabel("Group Reservation", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 26));
        lblTitle.setForeground(new Color(0, 51, 102));
        contentPane.add(lblTitle, BorderLayout.NORTH);

        
        tabbedPane = new JTabbedPane();
        contentPane.add(tabbedPane, BorderLayout.CENTER);

      
        JPanel customerPanel = createCustomerPanel();
        tabbedPane.addTab("Customer Info", customerPanel);

       
        JPanel roomPanel = createRoomPanel();
        tabbedPane.addTab("Room Details", roomPanel);

       
        JPanel billingPanel = createBillingPanel();
        tabbedPane.addTab("Billing Options", billingPanel);

        
        JPanel actionPanel = createActionPanel();
        contentPane.add(actionPanel, BorderLayout.SOUTH);

        
        setVisible(true);
    }

  
    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblCustomerName = new JLabel("Customer Name: ");
        lblCustomerName.setFont(new Font("Arial", Font.PLAIN, 14));
        customerNameField = new JTextField();
        customerNameField.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel lblNumOfRooms = new JLabel("Number of Rooms: ");
        lblNumOfRooms.setFont(new Font("Arial", Font.PLAIN, 14));
        numOfRoomsField = new JTextField();
        numOfRoomsField.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(lblCustomerName);
        panel.add(customerNameField);
        panel.add(lblNumOfRooms);
        panel.add(numOfRoomsField);

        return panel;
    }

    
    private JPanel createRoomPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        
        JButton btnAddRoom = new JButton("Add Room");
        btnAddRoom.setFont(new Font("Arial", Font.BOLD, 14));
        btnAddRoom.setBackground(new Color(0, 153, 76));
        btnAddRoom.setForeground(Color.WHITE);
        btnAddRoom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addRoomPanel(panel);
            }
        });

       
        panel.add(btnAddRoom);

        return panel;
    }

    
    private JPanel createBillingPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

        JLabel lblBillingOption = new JLabel("Billing Option: ");
        lblBillingOption.setFont(new Font("Arial", Font.PLAIN, 14));

        sharedBillingCheckBox = new JCheckBox("Shared Billing");
        sharedBillingCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(lblBillingOption);
        panel.add(sharedBillingCheckBox);

        return panel;
    }

   
    private JPanel createActionPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton btnSave = new JButton("Save Reservation");
        btnSave.setFont(new Font("Arial", Font.BOLD, 14));
        btnSave.setBackground(new Color(0, 153, 76));
        btnSave.setForeground(Color.WHITE);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveReservation();
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Arial", Font.BOLD, 14));
        btnCancel.setBackground(Color.RED);
        btnCancel.setForeground(Color.WHITE);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        panel.add(btnSave);
        panel.add(btnCancel);

        return panel;
    }

   
    private void addRoomPanel(JPanel container) {
        JPanel roomPanel = new JPanel();
        roomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        roomPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JLabel lblRoomDetails = new JLabel("Room " + (roomPanels.size() + 1) + " - People Count: ");
        JTextField numPeopleField = new JTextField(5);
        roomPanel.add(lblRoomDetails);
        roomPanel.add(numPeopleField);

       
        roomPanels.add(roomPanel);
        container.add(roomPanel);
        container.revalidate();
        container.repaint();
    }

 
    private void saveReservation() {
        String customerName = customerNameField.getText();
        int numRooms = Integer.parseInt(numOfRoomsField.getText());
        boolean sharedBilling = sharedBillingCheckBox.isSelected();

        
        ArrayList<Integer> roomDetails = new ArrayList<>();
        for (JPanel roomPanel : roomPanels) {
            JTextField numPeopleField = (JTextField) roomPanel.getComponent(1);
            roomDetails.add(Integer.parseInt(numPeopleField.getText()));
        }

        
        String message = "Reservation Details:\n" +
                         "Customer: " + customerName + "\n" +
                         "Number of Rooms: " + numRooms + "\n" +
                         "Shared Billing: " + (sharedBilling ? "Yes" : "No") + "\n" +
                         "Room Details: \n";

        for (int i = 0; i < roomDetails.size(); i++) {
            message += "Room " + (i + 1) + ": " + roomDetails.get(i) + " people\n";
        }

        JOptionPane.showMessageDialog(this, message, "Reservation Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new GroupReservationUI();
    }
}
