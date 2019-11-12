package cab;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginFrame extends JFrame implements ActionListener{
	Container container = getContentPane();
	JLabel userLabel = new JLabel("USERNAME");
	JLabel passwordLabel = new JLabel("PASSWORD");
	JLabel title;
	JTextField userTextField = new JTextField();
	JPasswordField passwordField = new JPasswordField();
	JButton loginButton = new JButton("LOGIN");
	JButton resetButton = new JButton("RESET");
	JButton registerButton = new JButton("NEW USER");
	JCheckBox showPassword = new JCheckBox("SHOW PASSWORD");
	RegisterFrame registerForm;
	BookCab bookCab;
	int tripFare =(int)(Math.random()*((700)+1))+300;
	
	public LoginFrame(){
		
		setLayoutManager();
		set_title();
		setLocationAndSize();
		addComponentToContainer();
		addActionEvent();
		setTitle("Login");
		setVisible(true);
		setBounds(10, 10, 370, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void set_title(){
		title = new JLabel("Swoosher Cabs"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(75, 30); 
        container.add(title);
	}
	
	public void setLayoutManager()
	{
		container.setLayout(null);
	}
	
	public void setLocationAndSize() {
		
		userLabel.setBounds(50, 150, 100, 30);
		passwordLabel.setBounds(50, 220, 100, 30);
		userTextField.setBounds(150, 150, 150, 30);;
		passwordField.setBounds(150, 220, 150, 30);
		showPassword.setBounds(150, 250, 150, 30);
		loginButton.setBounds(50, 300, 100, 30);
		resetButton.setBounds(200, 300, 100, 30);
		registerButton.setBounds(75, 400, 200, 30);
		
	}
	
	public void addComponentToContainer() {
		container.add(userLabel);
		container.add(passwordLabel);
		container.add(userTextField);
		container.add(passwordField);
		container.add(loginButton);
		container.add(resetButton);
		container.add(showPassword);
		container.add(registerButton);
		
	}
	
	public void addActionEvent(){
		loginButton.addActionListener(this);
		resetButton.addActionListener(this);
		showPassword.addActionListener(this);
		registerButton.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginButton) {
			String userText;
			String pwdText;
			userText = userTextField.getText();
			pwdText = String.valueOf(passwordField.getPassword());	
			//my work starts
			int success=0;
			
			
			try {
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
			    Statement stmt=con.createStatement();
			    ResultSet rs=stmt.executeQuery("SELECT * FROM userdetails;");
			    while(rs.next() && success==0)
			    {String user=rs.getString("UserName");
			     String pass=rs.getString("Password");
			     if (userText.equals(user) && pwdText.contentEquals(pass))
			    	success=1;
			        
			    }
			    rs.close();
				stmt.close();
				con.close();
				if(success==1) {
					JOptionPane.showMessageDialog(this, "Login Successful");
					this.setVisible(false);
					bookCab = new BookCab(userText);
					bookCab.setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Invalid Username or Password");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			//my work end
			
		}
		if(e.getSource() == resetButton) {
			userTextField.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource() == showPassword) {
			if(showPassword.isSelected()) {
				passwordField.setEchoChar((char) 0);
				
			}
			else {
				passwordField.setEchoChar('*');
			}
		}
		
		if(e.getSource() == registerButton) {
			this.setVisible(false);
			registerForm = new RegisterFrame();
			registerForm.setVisible(true);
		}
		
	}
	
	

}
