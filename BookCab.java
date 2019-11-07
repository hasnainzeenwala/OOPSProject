import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookCab extends JFrame implements ActionListener{
	
	Container container = getContentPane();
	private JLabel title;
	private JLabel pickUp;
	private JLabel dropOff;
    private JComboBox pick; 
    private JComboBox drop;
    private String walletBalance = "100";
    private JLabel balance;
    private JButton bookCab;
    private JButton addMoney;
    
    private String locations[] = {"Mahalaxmi Nagar", "Khatiwala Tank", "Sapna Sangeeta Road", "Manik Bagh Road"};
	
	public BookCab(String userName) {
		setLayoutManager();
		set_title(userName);
		setBounds(10, 10, 370, 600);
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
        container.add(addMoney);
        
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
		// TODO Auto-generated method stub
		
	}

}
