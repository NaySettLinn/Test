package spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ojt","root","root");
		}catch(ClassNotFoundException e) {
			System.out.println("Class Not Fount"+ e);
			
		}catch(SQLException e) {
			System.out.println("SQL Exception"+ e);	
		}
		return con;
	}

}
