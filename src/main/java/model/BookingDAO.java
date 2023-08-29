package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class BookingDAO {
	
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
	
	public ArrayList<TableDTO> avaTable() {
		Statement stmt;
		ResultSet rs;
		
		ArrayList<TableDTO> data=new ArrayList();
		String query="SELECT * FROM table_info  t LEFT JOIN booking b ON t.b_id=b.b_id WHERE t.b_id IS NULL";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				TableDTO table=new TableDTO();
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				table.setTabllId(rs.getInt(1));
				table.setTableNo(rs.getInt(2));
				data.add(table);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public boolean bookTable(TableDTO dto ,String username,Date date) {
		
		
		int tableNo=dto.getTableNo();
		int userId=0;
		int resRandom=0;
		int bId=0;
		PreparedStatement pstmt;
		ResultSet rs;
		
		boolean table=false;
		String query="insert into booking(booking_no,user_id,b_date) values(?,?,?)";
		String query2="select * from booking where booking_no=?";
		String query3="update table_info set b_id=? where table_no=?";
		String query4="select user_id from user_info where username=?";
		
		
		try {
			pstmt=con.prepareStatement(query4);
			pstmt.setString(1, username);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				userId=rs.getInt(1);
				pstmt=con.prepareStatement(query);
				Random rand = new Random();
		        resRandom = rand.nextInt(900) + 100;
		        pstmt.setInt(1, resRandom);
		        pstmt.setInt(2, userId);
		        pstmt.setDate(3, date);
		        pstmt.executeUpdate();
		        
		        
		        pstmt=con.prepareStatement(query2);
		        pstmt.setInt(1, resRandom);
		        rs=pstmt.executeQuery();
		        if(rs.next()) {
		        	bId=rs.getInt(1);
		        	pstmt=con.prepareStatement(query3);
		        	pstmt.setInt(1, bId);
		        	pstmt.setInt(2, tableNo);
		        	pstmt.executeUpdate();
		        	table=true;
		        }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return table;
	}
	
	
	
	public boolean resetTable(Date date) {
		PreparedStatement pstmt;
		ResultSet rs;
		
		boolean up=false;
		String query="delete from booking where b_date<?";
		String query1="select * from booking where b_date<?";
		String query2="update table_info set b_id=NULL where b_id=?";
		
		System.out.println(date);
		try {
			pstmt=con.prepareStatement(query1);
			pstmt.setDate(1, date);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int bId=rs.getInt(1);
				pstmt=con.prepareStatement(query2);
				pstmt.setInt(1, bId);
				pstmt.executeUpdate();
				pstmt=con.prepareStatement(query);
				pstmt.setDate(1, date);
				pstmt.executeUpdate();
				up=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return up;
	}

}
