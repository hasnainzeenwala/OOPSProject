import java.sql.*;  
import java.text.SimpleDateFormat;  
import java.util.Date;    

public class Connector{  
 public static ResultSet rs;
 
 
 //user table
 
public static void DBConnectupdate(String query){  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/users","root","swapnil69");  
//here sonoo is database name, root is username and password  
Statement stmt=con.createStatement();  
stmt.executeUpdate(query);   
con.close();  
}catch(Exception e){ System.out.println(e);}  
} 

public static String[] DBConnectgetname()
{
	String arr[]=new String[10];
	int i=0;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/users","root","swapnil69");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement(); 
		String que = "select name from users;";
		rs = stmt.executeQuery(que); 
		while(rs.next())  
			arr[i++]=rs.getString("name");
		con.close();
		}
		catch(Exception e)
			{
				System.out.println(e);
			}  
	return arr;
} 

public static String[] DBConnectgetpassword()
{
	String arr[]=new String[10];
	int i=0;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/users","root","swapnil69");  
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement(); 
		String que = "select password from users;";
		rs = stmt.executeQuery(que); 
		while(rs.next())  
			arr[i++]=rs.getString("password");
		con.close();
		}catch(Exception e){ System.out.println(e);}  
	return arr;
} 
