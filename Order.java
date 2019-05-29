package main;

public class Order {

	private String orderID;
	private String item;
	private int quantity;
	private double cost;
	private String date;
	
	//DB constructor
	public Order(String orderID, String item, int quantity, double cost, String date) {
		this.orderID = orderID;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
		this.date = date;
	}
	
	//Product constructor
	public Order(String item, int quantity, double cost, String date) {
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
		this.date = date;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getCost() {
		return cost;
	}
	public String getDate() {
		return date;
	}
	
	
	public void setOrderID(String id) {
		orderID = id;
	}
	
	public String toString() {
		return orderID + ":" + item + ":" + quantity + ":" + cost + ":" + date;
	}
}
