package cab;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BookCab extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	private JLabel title;
	private JLabel pickUp;
	private JLabel dropOff;
    	private JComboBox pick; 
    	private JComboBox drop;
    	private String walletBalance;
    	private JLabel balance;
    	private JButton bookCab;
    	private JButton addMoney;
    	private String user;
	final int noLocations = 6;
    	private String locations[] = {"Mahalaxmi Nagar", "Khatiwala Tank", "Sapna Sangeeta Road", "Manik Bagh Road", "Saket Nagar", "Thumkunta"};
	
	public BookCab(String userName) {
		user = userName;
		setLayoutManager();
		set_title(userName);
		setBounds(10, 10, 400, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pickUp = new JLabel("Pick Up:"); 
        pickUp.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pickUp.setSize(100, 20); 
        pickUp.setLocation(50, 100); 
        container.add(pickUp);
        
        pick = new JComboBox(locations); 
        pick.setFont(new Font("Arial", Font.PLAIN, 15)); 
        pick.setSize(200, 20); 
        pick.setLocation(150, 100); 
        container.add(pick); 
		
        dropOff = new JLabel("Drop Off:"); 
        dropOff.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dropOff.setSize(100, 20); 
        dropOff.setLocation(50, 150); 
        container.add(dropOff);
        
        drop = new JComboBox(locations); 
        drop.setFont(new Font("Arial", Font.PLAIN, 15)); 
        drop.setSize(200, 20); 
        drop.setLocation(150, 150); 
        container.add(drop);
        
        bookCab = new JButton("Book Cab");
        bookCab.setFont(new Font("Arial", Font.BOLD, 15));
        bookCab.setSize(150, 100); 
        bookCab.setLocation(125, 200);
        container.add(bookCab);
        
        addMoney = new JButton("Add Money To Wallet");
        addMoney.setFont(new Font("Arial", Font.BOLD, 15));
        addMoney.setSize(200, 20); 
        addMoney.setLocation(100, 350);
        addMoney.addActionListener(this);
        container.add(addMoney);
        int success=0;
        try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
		    Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery("SELECT * FROM userdetails;");
		    while(rs.next() && success==0)
		    {String user=rs.getString("UserName");
		     if (userName.equals(user) )
		    	{walletBalance=rs.getString("Balance");
		    	 success=1;
		    	}
		        
		    }
		    rs.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        balance = new JLabel("Current Wallent Balance: " + walletBalance);
        balance.setFont(new Font("Arial", Font.PLAIN, 20));
        balance.setSize(300, 20);
        balance.setLocation(100, 500);
        container.add(balance);
        
	
	}
	
	public void set_title(String userName){
		title = new JLabel("Welcome " + userName); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(75, 30); 
        container.add(title);
	}
	
	public void setLayoutManager() {
		container.setLayout(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==addMoney) {
			this.setVisible(false);
			AddMoney addMoneyWindow = new AddMoney(user);
			addMoneyWindow.setVisible(true);
		}
		if(e.getSource()==bookCab) {
			String pickUpLocation = (String)pick.getSelectedItem();
			String dropOffLocation = (String)drop.getSelectedItem();
			int pickUpIndex=0, dropOffIndex=0;
			for(int i=0; i<noLocations; i++) {
				if(locations[i].equals(pickUpLocation)) {
					pickUpIndex = i;
				}
				if(locations[i].equals(dropOffLocation)) {
					dropOffIndex = i;
				}
			}
			if(pickUpIndex != dropOffIndex) {
				this.setVisible(false);
				CabBooked cabBookedFrame = new CabBooked("Jhaveri", "4.8");
				cabBookedFrame.setVisible(true);
			}
			else {
				 JOptionPane.showMessageDialog(this, "Please enter valid pick up and drop off locations!");
			}
		}
		
	}

}
