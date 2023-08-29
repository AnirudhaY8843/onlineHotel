package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class UserDAO {
	
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
	public boolean logIn(UserDTO dto) {
		
		Statement stmt;
		ResultSet rs;
		
		boolean login=false;
		String username=dto.getUsername();
		String password=dto.getPassword();
		String query="select username,password from user_info";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				String dbUser=rs.getString(1);
				String dbPassword=rs.getString(2);
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
	
	
	
	//signup method
	public boolean signingUp(UserDTO dto) {
		PreparedStatement pstmt;
		ResultSet rs;
		
		boolean signup=false;
		String query1="select username,password from user_info where username=?";
		
		String query="insert into user_info(username,contact,email,password) values(?,?,?,?)";
		
		String username=dto.getUsername();
		String password=dto.getPassword();
		long cno=dto.getContact();
		String email=dto.getEmail();
		String pass=dto.getPassword();
		String cpass=dto.getCpass();
		
		try {
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			System.out.println(rs.next());
			if(!rs.next() && pass.equals(cpass)) {			
				pstmt=con.prepareStatement(query);
				pstmt.setString(1, username);
				pstmt.setLong(2, cno);
				pstmt.setString(3, email);
				pstmt.setString(4, password);
				pstmt.executeUpdate();
				signup=true;
			}
			System.out.println(signup);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signup;
		
		
	}

	

}
