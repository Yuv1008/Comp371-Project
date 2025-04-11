//Yuvraj Singh Goraya- 300206199
//Harjap Singh- 300206219

package hotel.management.system;

import javax.swing.*;

import java.sql.*;	
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Reception extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		new Reception();
	}
	
	public Reception(){
		
                setBounds(530, 200, 850, 1000);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/reception.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 500,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(250,30,500,700);
                add(l1);
		
		JButton btnNewCustomerForm = new JButton("New Customer Form");
		btnNewCustomerForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				NewCustomer custom = new NewCustomer();
				custom.setVisible(true);
                                setVisible(false);
			}catch(Exception e1){
				e1.printStackTrace();
			}
			}
		});
		btnNewCustomerForm.setBounds(10, 30, 200, 30);
                btnNewCustomerForm.setBackground(Color.BLACK);
                btnNewCustomerForm.setForeground(Color.WHITE);
		contentPane.add(btnNewCustomerForm);
                
JButton btnGroupReservation = new JButton("Group Reservation");
btnGroupReservation.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
    
            GroupReservationUI groupReservationUI = new GroupReservationUI();
            groupReservationUI.setVisible(true);
            
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
btnGroupReservation.setBounds(10, 630, 200, 30);  
btnGroupReservation.setBackground(Color.BLACK);    
btnGroupReservation.setForeground(Color.WHITE);  
contentPane.add(btnGroupReservation);               

		
                
                
		JButton btnNewButton = new JButton("Rooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Room room = new Room();
				room.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(10, 70, 200, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);

		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Department");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Department dept = new Department();
					dept.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_1.setBounds(10, 110, 200, 30);
                btnNewButton_1.setBackground(Color.BLACK);
                btnNewButton_1.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("All Employee Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				
					EmployeeInfo em = new EmployeeInfo();
					em.setVisible(true);
					setVisible(false);
					
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton_2.setBounds(10, 150, 200, 30);                
                btnNewButton_2.setBackground(Color.BLACK);
                btnNewButton_2.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Customer Info");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Customerinfo customer = new Customerinfo();
					customer.setVisible(true);				
					setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(10, 190, 200, 30);
                btnNewButton_3.setBackground(Color.BLACK);
                btnNewButton_3.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_3);
		
		JButton btnManagerInfo = new JButton("Manager Info");
		btnManagerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				ManagerInfo mana = new ManagerInfo();
				mana.setVisible(true);
                                setVisible(false);
				}
				catch (Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnManagerInfo.setBounds(10, 230, 200, 30);
                btnManagerInfo.setBackground(Color.BLACK);
                btnManagerInfo.setForeground(Color.WHITE);

		contentPane.add(btnManagerInfo);
		
		JButton btnNewButton_4 = new JButton("Check Out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut check;
				try {
					check = new CheckOut();
					check.setVisible(true);
                                        setVisible(false);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_4.setBounds(10, 270, 200, 30);
                btnNewButton_4.setBackground(Color.BLACK);
                btnNewButton_4.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update Check Status");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				UpdateCheck update = new UpdateCheck();
				update.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_5.setBounds(10, 310, 200, 30);
                btnNewButton_5.setBackground(Color.BLACK);
                btnNewButton_5.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Update Room Status");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UpdateRoom room = new UpdateRoom();
					room.setVisible(true);
                                        setVisible(false);
				}catch(Exception s)
				{
					s.printStackTrace();
				}
			}
		});
		btnNewButton_6.setBounds(10, 350, 200, 30);
                btnNewButton_6.setBackground(Color.BLACK);
                btnNewButton_6.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_6);
		
		JButton btnPickUpSerice = new JButton("Pick up Service");
		btnPickUpSerice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				PickUp pick = new PickUp();
				pick.setVisible(true);
                                setVisible(false);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		btnPickUpSerice.setBounds(10, 390, 200, 30);
                btnPickUpSerice.setBackground(Color.BLACK);
                btnPickUpSerice.setForeground(Color.WHITE);

		contentPane.add(btnPickUpSerice);
		
		JButton btnSearchRoom = new JButton("Search Room");
		btnSearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				SearchRoom search = new SearchRoom();
				search.setVisible(true);
                                setVisible(false);
				}
				catch (Exception ss){
					ss.printStackTrace();
				}
			}
		});
		btnSearchRoom.setBounds(10, 430, 200, 30);
                btnSearchRoom.setBackground(Color.BLACK);
                btnSearchRoom.setForeground(Color.WHITE);

		contentPane.add(btnSearchRoom);
                
                JButton btnBilling = new JButton("Billing");
                btnBilling.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
		                try {
			Billing billing = new Billing(); 
			billing.setVisible(true);
			setVisible(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
   });
                  btnBilling.setBounds(10, 510, 200, 30);
                  btnBilling.setBackground(Color.BLACK);
                  btnBilling.setForeground(Color.WHITE);
                  contentPane.add(btnBilling);
                  
                
JButton btnGenerateReport = new JButton("Generate Hotel Report");
btnGenerateReport.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        
        HotelReport reportFrame = new HotelReport();
        reportFrame.setVisible(true); 
    }
});
btnGenerateReport.setBounds(10, 550, 200, 30);
btnGenerateReport.setBackground(Color.BLACK);
btnGenerateReport.setForeground(Color.WHITE);
contentPane.add(btnGenerateReport);

JButton btnSeasonalPricing = new JButton("Seasonal Pricing");
btnSeasonalPricing.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       
        SeasonalPricing seasonalPricingFrame = new SeasonalPricing();
        seasonalPricingFrame.setVisible(true); 
    }
});
btnSeasonalPricing.setBounds(10, 590, 200, 30);
btnSeasonalPricing.setBackground(Color.BLACK);
btnSeasonalPricing.setForeground(Color.WHITE);
contentPane.add(btnSeasonalPricing);

JButton btnInventoryAlerts = new JButton("Low Inventory Alerts");
btnInventoryAlerts.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
       
        JOptionPane.showMessageDialog(null, "Checking for low inventory supplies...");
        
        
    }
});
btnInventoryAlerts.setBounds(10, 670, 200, 30);
btnInventoryAlerts.setBackground(Color.BLACK);
btnInventoryAlerts.setForeground(Color.WHITE);
contentPane.add(btnInventoryAlerts);

JButton btnLateCheckout = new JButton("Late Check-Out");
btnLateCheckout.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            LateCheckout lateCheckout = new LateCheckout();
            lateCheckout.setVisible(true);
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
btnLateCheckout.setBounds(10, 710, 200, 30);
btnLateCheckout.setBackground(Color.BLACK);
btnLateCheckout.setForeground(Color.WHITE);
contentPane.add(btnLateCheckout);


JButton btnGuestHistoryAccess = new JButton("Guest History Access");
btnGuestHistoryAccess.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        try {
            
            GuestHistoryAccess guestHistoryAccessUI = new GuestHistoryAccess();
            guestHistoryAccessUI.setVisible(true);
           
            setVisible(false);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});
btnGuestHistoryAccess.setBounds(10, 750, 200, 30);  
btnGuestHistoryAccess.setBackground(Color.BLACK);    
btnGuestHistoryAccess.setForeground(Color.WHITE);    
contentPane.add(btnGuestHistoryAccess);               



		JButton btnNewButton_7 = new JButton("Log Out");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
                                    new Login().setVisible(true);
                                    setVisible(false);
                                    
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_7.setBounds(10, 470, 200, 30);
                btnNewButton_7.setBackground(Color.BLACK);
                btnNewButton_7.setForeground(Color.WHITE);

		contentPane.add(btnNewButton_7);
                getContentPane().setBackground(Color.WHITE);
                
                setVisible(true);
	}
}

