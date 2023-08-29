package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorityDAO {
	
	static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","128843");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//login validation method
	public boolean logInAuth(AuthorityDTO dto) {
		
		Statement stmt;
		ResultSet rs;
		
		boolean login=false;
		String username=dto.getAuthName();
		String password=dto.getPassword();
		System.out.println(username+""+password);
		String query="select auth_name,password from authority";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				String dbUser=rs.getString(1);
				String dbPassword=rs.getString(2);
				System.out.println(dbUser+""+dbPassword);
				if(username.equals(dbUser)&&password.equals(dbPassword)) {
					login=true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return login;
	}

}
