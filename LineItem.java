package main;


public class LineItem {

	private String lineID;
	private String item;
	private int quantity = 0;
	private double cost = 0;
	
	//New item Constructor
	public LineItem(String item, int quantity, double price) {
		this.item = item;
		this.quantity = quantity;
		cost = quantity * price;
	}
	
	//Database constructor
	public LineItem(String lineID, String item, int quantity, double cost) {
		this.lineID = lineID;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String getItem() {
		return item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	public void setLineID(String id) {
		lineID = id;
	}
	
	//Use ":" as a delimiter between variables
	public String toString() {
		return lineID + ":" + item + ":" + quantity + ":" + cost;
	}
}
