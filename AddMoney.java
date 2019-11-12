package cab;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;

public class AddMoney extends JFrame implements ActionListener{

	
	Container container = getContentPane();
	JLabel card = new JLabel("Credit/Debit Card No");
	JLabel cvv = new JLabel("CVV ");
	JLabel amt = new JLabel("Amount ");
	JTextField cardNo = new JTextField();
	JTextField amount = new JTextField();
	JButton addMoney = new JButton("Add Money");
	JPasswordField cvvNo = new JPasswordField();
	private String userName;
	
	public AddMoney(String user) {
		userName = user;
		setBounds(10, 10, 370, 600);
		container.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		card.setBounds(30, 150, 200, 30);
		cvv.setBounds(70, 220, 100, 30);
		cardNo.setBounds(170, 150, 150, 30);;
		cvvNo.setBounds(170, 220, 150, 30);
		amt.setBounds(70, 290, 150, 30);
		amount.setBounds(170, 290, 150, 30);
		addMoney.setBounds(120, 400, 150, 30);
		
		addMoney.addActionListener(this);
		
		container.add(card);
		container.add(cvv);
		container.add(cardNo);
		container.add(cvvNo);
		container.add(amt);
		container.add(amount);
		container.add(addMoney);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addMoney) {
			if(String.valueOf(cvvNo.getPassword()).equals("123"))
			{
				try{
					int j = Inter.parseInt(cardNo.getText());
				try{
					int i = Integer.parseInt(amount.getText());
				
				 try {
	    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
	    			    PreparedStatement stmt=(PreparedStatement) con.prepareStatement("UPDATE userdetails SET Balance=Balance + ? WHERE UserName=?");
	    			    stmt.setString(1,Integer.toString(Integer.parseInt(amount.getText())));
	    			    stmt.setString(2,userName);
	    			    stmt.execute();
	    			    stmt.close();
	    			    con.close();
	    			    BookCab newBookCabFrame = new BookCab(userName);
	    			    this.setVisible(false);
	    			    newBookCabFrame.setVisible(true);
	    				}
	                catch (SQLException e1) {
	    				// TODO Auto-generated catch block
	    				e1.printStackTrace();
	    			}
				}
				catch (NumberFormatException e2){
					JOptionPane.showMessageDialog(this, "Please enter a valid Amount");
				}
				}
				catch (NumberFormatException e3){
					JOptionPane.showMessageDialog(this, "Please enter a valid Card Number!");
				}
			
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid CVV");
			}
		}
		
	}

}
