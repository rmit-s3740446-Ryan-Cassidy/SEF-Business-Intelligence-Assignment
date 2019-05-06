package main;

public class LineItem {

	private String productID;
	private String item;
	private int quantity = 0;
	private double cost = 0; //INT?
	
	//New item Constructor
	public LineItem(String productID, String item, int quantity) {
		this.productID = productID;
		this.item = item;
		this.quantity = quantity;
	}
	
	//Database constructor
	public LineItem(String productID, String item, int quantity, double cost) {
		this.productID = productID;
		this.item = item;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public double totalCost() {
		double totalCost = cost * quantity;
		return totalCost;
	}
	
	//Use ":" as a delimiter between variables
	public String toString() {
		return productID + ":" + item + ":" + quantity + ":" + cost;
	}
}
