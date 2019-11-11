import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CabBooked extends JFrame implements ActionListener{

	Container container = getContentPane();
	private int pickUpLocationFrame, dropOffLocationFrame;
	JLabel driver;
	JLabel approxFareL;
	JLabel ratingL;
	JButton done = new JButton("Done!");
	public CabBooked(String driverName, String rating) {
		
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
		
		int fare=300;
		
		approxFareL = new JLabel("Approximate Fare is: " + fare);
		approxFareL.setFont(new Font("Arial", Font.PLAIN, 30)); 
        approxFareL.setSize(500, 40); 
        approxFareL.setLocation(75, 110); 
        container.add(approxFareL);
        
        done.setFont(new Font("Arial", Font.BOLD, 15));
        done.setSize(150, 100); 
        done.setLocation(125, 200);
        done.addActionListener(this);
        
        container.add(done);
		
		//Subtract money from wallet
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==done) {
			System.exit(0);
		}
		
	}
	

}
