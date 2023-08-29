package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class OrderDAO {
	
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
	
	
	public ArrayList<BillDTO> placeOrder(FoodDTO dto, String user) {
		
		PreparedStatement pstmt;
		
		ResultSet rs;
		
		ArrayList<BillDTO> bill=new ArrayList<BillDTO>();
		
		String query1="select * from food_info where food_name=?";
		
		String query2="select * from user_info where username=?";
		
		String query3="insert into order_info(order_no,user_fk,no_of_dish) values(?,?,?)";
		
		String query5="select * from order_info where order_no=?";
		
		String query4="insert into food_order values(?,?)";
		
		int foodId=0;
		int orderId=0;
		int orderNo=0;
		int resRandom=0;
		String dishName="";
		double price=0;
		
		
		try {
			pstmt=con.prepareStatement(query1);
			pstmt.setString(1, dto.getDishName());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				foodId=rs.getInt(1);
				dishName=rs.getString(2);
				price=rs.getDouble(3);
				pstmt=con.prepareStatement(query2);
				pstmt.setString(1, user);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					int userid=rs.getInt(1);
					Random rand = new Random();
			        resRandom = rand.nextInt(9000) + 1000;
				         System.out.println(resRandom);
				         
				         
					pstmt=con.prepareStatement(query3);
					pstmt.setInt(1,resRandom);
					pstmt.setInt(2, userid);
					pstmt.setInt(3, dto.getNoofdish());
					pstmt.executeUpdate();
				}
			}
			pstmt=con.prepareStatement(query5);
			pstmt.setInt(1, resRandom);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				orderId=rs.getInt(1);
				orderNo=rs.getInt(2);
				System.out.println(orderId);
				pstmt=con.prepareStatement(query4);
				pstmt.setInt(1, foodId);
				pstmt.setInt(2, orderId);
				pstmt.executeUpdate();
			}
			
			BillDTO data=new BillDTO();
			data.setDishName(dishName);
			data.setOrderId(orderNo);
			data.setUser(user);
			data.setPrice(price);
			
			bill.add(data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bill;
	}
	
	
	
	public boolean deleteOrder(int orderNo) {
		
		PreparedStatement pstmt;
		ResultSet rs;
		
		boolean order=false;
		String query1="select * from order_info where order_no=?";
		String query2="delete from order_info where order_no=?";
		
		String query="delete from order_in";
		String query3="delete from food_order where order_fk=?";
		int orderId=0;
		
		try {
			
			pstmt=con.prepareStatement(query1);
			
			pstmt.setInt(1, orderNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				orderId=rs.getInt(1);
				con.setAutoCommit(false);
//				pstmt=con.prepareStatement(query3);
//				pstmt.setInt(1, orderId);
//				pstmt.executeUpdate();
				pstmt=con.prepareStatement(query2);
				pstmt.setInt(1, orderNo);
				pstmt.executeUpdate();
				
				con.commit();
				order=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	
	
	//method for bill
	public ArrayList<BillDTO> getBill(OrderDTO dto,String user) {
		PreparedStatement pstmt;
		ResultSet rs;
		

		
		String query="select * from order_info where order_no=? and user_fk IN(select user_id from user_info where username=?)";
		
		String query2="select * from food_order where order_fk=?";
		String query3="select * from food_info where food_id=?";
		
		ArrayList<BillDTO> bill=new ArrayList<BillDTO>();
		
		int orderId=0;
		int dishId=0;
		int noOfDish=0;
		
		try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, dto.getOrderNo());
			pstmt.setString(2, user);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				orderId=rs.getInt(1);
				noOfDish=rs.getInt(4);
				pstmt=con.prepareStatement(query2);
				pstmt.setInt(1, orderId);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					dishId=rs.getInt(1);
					pstmt=con.prepareStatement(query3);
					pstmt.setInt(1, dishId);
					rs=pstmt.executeQuery();
					while(rs.next()) {
						BillDTO data=new BillDTO();
						data.setDishName(rs.getString(2));
						data.setPrice(rs.getDouble(3));
						data.setUser(user);
						data.setOrderId(dto.getOrderNo());
						data.setNo_dish(noOfDish);
						bill.add(data);
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bill;
	}


}
