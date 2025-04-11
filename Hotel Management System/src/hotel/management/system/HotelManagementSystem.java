//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

    public HotelManagementSystem() {
        setTitle("Welcome | Taj Hotels");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 565);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

       
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/cover.jpg"));
        JLabel background = new JLabel(bgIcon);
        background.setLayout(new GridBagLayout()); 
        add(background, BorderLayout.CENTER);

      
        JPanel overlayPanel = new JPanel();
        overlayPanel.setLayout(new BoxLayout(overlayPanel, BoxLayout.Y_AXIS));
        overlayPanel.setOpaque(false);

       
        JLabel title = new JLabel("WELCOME TO TAJ HOTELS");
        title.setFont(new Font("Serif", Font.BOLD, 48));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(new EmptyBorder(20, 20, 20, 20));

       
        JButton nextBtn = new JButton("Enter");
        nextBtn.setFont(new Font("SansSerif", Font.BOLD, 22));
        nextBtn.setBackground(new Color(255, 255, 255));
        nextBtn.setForeground(new Color(30, 30, 30));
        nextBtn.setFocusPainted(false);
        nextBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        nextBtn.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));

       
        nextBtn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                nextBtn.setBackground(new Color(200, 200, 200));
            }
            public void mouseExited(MouseEvent e) {
                nextBtn.setBackground(Color.WHITE);
            }
        });

        nextBtn.addActionListener(this);

     
        overlayPanel.add(Box.createVerticalStrut(150));
        overlayPanel.add(title);
        overlayPanel.add(Box.createVerticalStrut(30));
        overlayPanel.add(nextBtn);

        background.add(overlayPanel); 

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login(); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HotelManagementSystem::new);
    }
}
