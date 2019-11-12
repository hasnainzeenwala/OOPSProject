package cab;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Statement;
import java.awt.*; 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
class RegisterFrame
    extends JFrame 
    implements ActionListener { 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JLabel email;
    private JTextField tname; 
    private JLabel mno; 
    private JTextField tmno; 
    private JTextField temail;
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JPasswordField tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JPasswordField resadd;
    private JButton backToLogin;
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
  
    // constructor, to initialize the components 
    // with default values. 
    public RegisterFrame() 
    { 
        setTitle("Registration Form"); 
        setBounds(300, 90, 900, 700); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("Username"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(300, 100); 
        c.add(name); 
        

        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(400, 100); 
        c.add(tname); 
        
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setSize(100, 20);
        email.setLocation(300, 150);
        c.add(email);
        
        temail = new JTextField();
        temail.setFont(new Font("Arial", Font.PLAIN, 15));
        temail.setSize(190, 20);
        temail.setLocation(400, 150);
        c.add(temail);
  
        mno = new JLabel("Mobile"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(100, 20); 
        mno.setLocation(300, 200); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(400, 200); 
        c.add(tmno); 
  
        gender = new JLabel("Gender"); 
        gender.setFont(new Font("Arial", Font.PLAIN, 20)); 
        gender.setSize(100, 20); 
        gender.setLocation(300, 250); 
        c.add(gender); 
  
        male = new JRadioButton("Male"); 
        male.setFont(new Font("Arial", Font.PLAIN, 15)); 
        male.setSelected(true); 
        male.setSize(75, 20); 
        male.setLocation(400, 250); 
        c.add(male); 
  
        female = new JRadioButton("Female"); 
        female.setFont(new Font("Arial", Font.PLAIN, 15)); 
        female.setSelected(false); 
        female.setSize(80, 20); 
        female.setLocation(475, 250); 
        c.add(female); 
  
        gengp = new ButtonGroup(); 
        gengp.add(male); 
        gengp.add(female); 
  
        dob = new JLabel("DOB"); 
        dob.setFont(new Font("Arial", Font.PLAIN, 20)); 
        dob.setSize(100, 20); 
        dob.setLocation(300, 300); 
        c.add(dob); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(50, 20); 
        date.setLocation(400, 300); 
        c.add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(60, 20); 
        month.setLocation(450, 300); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(60, 20); 
        year.setLocation(520, 300); 
        c.add(year); 
  
        add = new JLabel("Password"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(300, 350); 
        c.add(add); 
  
        tadd = new JPasswordField(); 
        tadd.setSize(200, 30); 
        tadd.setLocation(400, 350);  
        c.add(tadd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(450, 20); 
        term.setLocation(350, 450); 
        c.add(term); 
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(350, 500); 
        sub.addActionListener(this); 
        c.add(sub); 
        
        backToLogin = new JButton("Return");
        backToLogin.setFont(new Font("Arial", Font.PLAIN, 15)); 
        backToLogin.setSize(100, 20); 
        backToLogin.setLocation(400, 600); 
        backToLogin.addActionListener(this); 
        c.add(backToLogin);
        backToLogin.setVisible(false);
        backToLogin.addActionListener(this);
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(470, 500); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        //c.add(tout); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(700, 25); 
        res.setLocation(100, 550); 
        c.add(res); 
  
        setVisible(true); 
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
            if (term.isSelected() && !(tname.getText().trim().isEmpty()) && !(temail.getText().trim().isEmpty()) && !(String.valueOf(tadd.getPassword()).trim().isEmpty())) { 
                
            	String user = tname.getText();
                String mobile=tmno.getText(); 
                String email=temail.getText();
                String pass = String.valueOf(tadd.getPassword()); 
                try {
    				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root", "password");
    			    PreparedStatement stmt=(PreparedStatement) con.prepareStatement("INSERT INTO userdetails (Username,Password,Mobile,Email) VALUES(?,?,?,?)");
    			    stmt.setString(1,user);
    			    stmt.setString(2,pass);
    			    stmt.setString(3,mobile);
    			    stmt.setString(4,email);
    			    stmt.execute();
    			    con.close();
    			    res.setText("Registered Successfully.."); 
                    backToLogin.setVisible(true);
    				}
                catch (SQLException e1) {
    				// TODO Auto-generated catch block
    				e1.printStackTrace();
    				JOptionPane.showMessageDialog(this, "Username/Email Already Exists!");
    			}
                
                
            }
             else { 
                res.setText("Please accept the"
                            + " terms & conditions, and don't leave any field blank"); 
            }
            
        } 
        if(e.getSource()==backToLogin) {
        	LoginFrame newLoginFrame = new LoginFrame();
        	this.setVisible(false);
        	newLoginFrame.setVisible(true);
        }
  
        if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tadd.setText(def); 
            tmno.setText(def); 
            res.setText(def); 
            tout.setText(def); 
            term.setSelected(false); 
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            resadd.setText(def); 
        } 
    } 
} 
  
