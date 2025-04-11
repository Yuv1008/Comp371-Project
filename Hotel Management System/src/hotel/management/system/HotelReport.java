//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class HotelReport extends JFrame {
    private Connection conn;

    public HotelReport() {
        
        setTitle("Hotel Report");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "Yuvraj_8");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        
        JPanel panel = new JPanel(new BorderLayout());

       
        JTabbedPane tabbedPane = new JTabbedPane();

       
        JScrollPane occupancyReport = new JScrollPane(createOccupancyReport());
        tabbedPane.addTab("Room Occupancy", occupancyReport);

       
        JScrollPane reservationSummary = new JScrollPane(createReservationSummaryReport());
        tabbedPane.addTab("Reservation Summary", reservationSummary);

    
        JScrollPane financialReport = new JScrollPane(createFinancialReport());
        tabbedPane.addTab("Financial Summary", financialReport);

        panel.add(tabbedPane, BorderLayout.CENTER);
        add(panel);
    }

    private JTable createOccupancyReport() {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Room");
        columnNames.add("Total Reservations");
        columnNames.add("Occupied Rooms");
        columnNames.add("Occupancy Rate");

        String query = "SELECT room, COUNT(*) AS total_reservations, " +
                       "SUM(CASE WHEN checkintime IS NOT NULL THEN 1 ELSE 0 END) AS occupied_rooms " +
                       "FROM reservations GROUP BY room";

        try (PreparedStatement pst = conn.prepareStatement(query); 
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("room"));
                row.add(rs.getInt("total_reservations"));
                row.add(rs.getInt("occupied_rooms"));
                double occupancyRate = rs.getInt("total_reservations") == 0 ?
                        0 : (double) rs.getInt("occupied_rooms") / rs.getInt("total_reservations") * 100;
                row.add(String.format("%.2f%%", occupancyRate));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new JTable(data, columnNames);
    }

    private JTable createReservationSummaryReport() {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("ID");
        columnNames.add("Name");
        columnNames.add("Room");
        columnNames.add("Check-in Time");
        columnNames.add("Check-out Time");
        columnNames.add("Deposit");

        String query = "SELECT id, name, room, checkintime, checkouttime, deposit FROM reservations";

        try (PreparedStatement pst = conn.prepareStatement(query); 
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getInt("id"));
                row.add(rs.getString("name"));
                row.add(rs.getString("room"));
                row.add(rs.getString("checkintime"));
                row.add(rs.getString("checkouttime"));
                row.add(rs.getDouble("deposit"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new JTable(data, columnNames);
    }

    private JTable createFinancialReport() {
        Vector<Vector<Object>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Total Deposits");

        String query = "SELECT SUM(deposit) AS total_deposits FROM reservations";

        try (PreparedStatement pst = conn.prepareStatement(query); 
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getDouble("total_deposits"));
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new JTable(data, columnNames);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HotelReport frame = new HotelReport();
            frame.setVisible(true);
        });
    }
}

