package cab;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.mysql.jdbc.PreparedStatement;

public class CabBooked extends JFrame implements ActionListener{

	Container container = getContentPane();
	private int pickUpLocationFrame, dropOffLocationFrame;
	JLabel driver;
	JLabel approxFareL;
	JLabel ratingL;
	JButton done = new JButton("Done!");
	public CabBooked(String userName, String driverName, double rating, int tripFare) {
		
		container.setLayout(null);
		setBounds(10, 10, 500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		driver = new JLabel("Your Driver is " + driverName);
		driver.setFont(new Font("Arial", Font.PLAIN, 30)); 
        driver.setSize(500, 40); 
        driver.setLocation(75, 30); 
        container.add(driver);
        
        ratingL = new JLabel("His rating is: " + rating);
        ratingL.setFont(new Font("Arial", Font.PLAIN, 30)); 
        ratingL.setSize(500, 40); 
        ratingL.setLocation(75, 70); 
        container.add(ratingL);
		

		approxFareL = new JLabel("Approximate Fare is: " + tripFare);
		approxFareL.setFont(new Font("Arial", Font.PLAIN, 30)); 
        approxFareL.setSize(500, 40); 
        approxFareL.setLocation(75, 110); 
        container.add(approxFareL);
        
        done.setFont(new Font("Arial", Font.BOLD, 15));
        done.setSize(150, 100); 
        done.setLocation(125, 200);
        done.addActionListener(this);
        
        container.add(done);
		
		
       //Subtract money from wallet work starts
        try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
		    PreparedStatement stmt=(PreparedStatement) con.prepareStatement("UPDATE userdetails SET Balance=Balance - ? WHERE UserName=?");
		    stmt.setString(1,String.valueOf(tripFare));
		    stmt.setString(2,userName);
		    stmt.execute();
		    stmt.close();
		    con.close();
			}
        catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //wok ends
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			System.exit(0);
		}
		
	}
	

}
