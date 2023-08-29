package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodDAO {
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
	
	
	public boolean addDish(FoodDTO dto) {
		PreparedStatement pstmt;
		ResultSet rs;
		
		boolean add=false;
		String query="insert into food_info(food_name,food_price) values(?,?)";
		
		String dish=dto.getDishName();
		double price=dto.getDishPrice();
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, dish);
			pstmt.setDouble(2, price);
			pstmt.executeUpdate();
			add=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return add;
	}
	
	
	public ArrayList<FoodDTO> placeOrder() {
		Statement stmt;
		ResultSet rs;
		
		ArrayList<FoodDTO> foodList=new ArrayList<>();
		String query="select * from food_info";
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				FoodDTO dto=new FoodDTO();
				dto.setDishName(rs.getString(2));
				dto.setDishPrice(rs.getDouble(3));
				foodList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodList;
	}
	
	
	
	//update food
	public boolean updateDish(FoodDTO dto) {
		PreparedStatement pstmt;
		boolean update=false;
		String query="update food_info set food_price=? where food_name=?";
		
		try {
			pstmt=con.prepareStatement(query);
			
			pstmt.setDouble(1, dto.getDishPrice());
			pstmt.setString(2, dto.getDishName());
			pstmt.executeUpdate();
			update=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return update;
		
		
	}
	
	
	public ArrayList<FoodDTO> displayDish() {
		Statement stmt;
		ResultSet rs;
		
		ArrayList<FoodDTO> menu=new ArrayList<FoodDTO>();
		String query="select * from food_info";
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString(2));
				FoodDTO data=new FoodDTO();
				data.setDishName(rs.getString(2));
				data.setDishPrice(rs.getDouble(3));
				menu.add(data);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}


}
