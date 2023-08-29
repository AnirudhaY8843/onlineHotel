package model;

public class BillDTO {
	
	private String user;
	private int orderId;
	private String dishName;
	private double price;
	private int no_dish;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNo_dish() {
		return no_dish;
	}
	public void setNo_dish(int no_dish) {
		this.no_dish = no_dish;
	}
	
	

}
