package model;

public class FoodDTO {
	
	private int dishId;
	private String dishName;
	private double dishPrice;
	
	private int noofdish;
	
	
	public int getNoofdish() {
		return noofdish;
	}
	public void setNoofdish(int noofdish) {
		this.noofdish = noofdish;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public double getDishPrice() {
		return dishPrice;
	}
	public void setDishPrice(double dishPrice) {
		this.dishPrice = dishPrice;
	}
	
	

}
