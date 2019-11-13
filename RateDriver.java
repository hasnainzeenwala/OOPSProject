package cab;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class RateDriver extends JFrame implements ActionListener{
	Container container = getContentPane();
	String myDriver;
	double oldRating;
	double rating;
	JButton done = new JButton("Done!");
	JLabel msg = new JLabel("Rate Your Trip");
	JComboBox ratingC;
	private String ratings[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	
	RateDriver(String driverName, double rating){
		
		oldRating = rating;
		
		JLabel title = new JLabel("Thank You!"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(75, 30); 
        container.add(title);
		
		myDriver = driverName;
		container.setLayout(null);
		setBounds(10, 10, 370, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		ratingC = new JComboBox(ratings);
		ratingC.setBounds(150, 150, 150, 30);
		container.add(ratingC);
		
		msg.setBounds(10, 150, 150, 30);
		msg.setFont(new Font("Arial", Font.BOLD, 15)); 
		container.add(msg);
		
		done.setBounds(50, 300, 100, 30);
		done.addActionListener(this);
		container.add(done);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == done) {
			rating = Integer.parseInt((String)ratingC.getSelectedItem());
			double finalRating = (9*oldRating+rating)/10;;
			
			//Database code to update the rating
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
			    PreparedStatement stmt=(PreparedStatement) con.prepareStatement("UPDATE driverdetails SET Rating=? WHERE Name=?");
			    stmt.setDouble(1,finalRating);
			    stmt.setString(2,myDriver);
			    stmt.execute();
			    stmt.close();
			    con.close();
			   
			}
            catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//work done
			System.exit(0);
		}
		
	}
}

