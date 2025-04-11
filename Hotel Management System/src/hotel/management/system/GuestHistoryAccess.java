//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;


public class GuestHistoryAccess extends JFrame {
    private JPanel contentPane;
    private JTextField searchTextField;
    private JTable guestHistoryTable;

 
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
    private static final String USER = "root";
    private static final String PASSWORD = "Yuvraj_8";

    public static void main(String[] args) {
        new GuestHistoryAccess();
    }

    public GuestHistoryAccess() {
        setTitle("Guest History Access");
        setBounds(300, 100, 800, 600);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSearch = new JLabel("Enter Guest Name or ID:");
        lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSearch.setBounds(20, 20, 160, 25);
        contentPane.add(lblSearch);

        searchTextField = new JTextField();
        searchTextField.setBounds(180, 20, 200, 25);
        contentPane.add(searchTextField);

        JButton searchButton = new JButton("Search History");
        searchButton.setBounds(400, 20, 150, 30);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        contentPane.add(searchButton);

        
        guestHistoryTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(guestHistoryTable);
        scrollPane.setBounds(20, 70, 740, 400);
        contentPane.add(scrollPane);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchQuery = searchTextField.getText();
                if (!searchQuery.isEmpty()) {
                    searchGuestHistory(searchQuery);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a guest name or ID");
                }
            }
        });

        setVisible(true);
    }

   
    private void searchGuestHistory(String searchQuery) {
        
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "SELECT * FROM GuestHistory WHERE name LIKE ? OR guestID = ?";
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + searchQuery + "%");
            pst.setString(2, searchQuery);

            rs = pst.executeQuery();

            
            guestHistoryTable.setModel(buildTableModel(rs));

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error retrieving data from the database");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

       
        Vector<String> columnNames = new Vector<>();
        for (int i = 1; i <= columnCount; i++) {
            columnNames.add(metaData.getColumnName(i));
        }

        
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }
}
