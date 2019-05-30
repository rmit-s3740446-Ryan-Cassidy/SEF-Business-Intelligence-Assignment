package main;

import java.util.ArrayList;

public class Transaction {

	private String transactionID;
	private String transactionDate = "date";
	private ArrayList <LineItem> itemsBought = new ArrayList<>();
	private double totalPrice = 0;
	private double discountPrice = 0;
	private int purchasePoints = 0;
	
	//New transaction constructor
	public Transaction() {
	}
	
	//Database transaction constructor
	public Transaction(String transactionID, String transactionDate,
						double totalPrice, double discountPrice, int purchasePoints) {
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.totalPrice = totalPrice;
		this.discountPrice = discountPrice;
		this.purchasePoints = purchasePoints;
	}
	
	//Method for adding items to transaction
	public void addItem(LineItem item) {
		if(itemsBought.isEmpty()) {
			item.setLineID(transactionID + "_" +String.valueOf(1));
			itemsBought.add(item);
		}
		else {
			item.setLineID(transactionID + "_" +String.valueOf(itemsBought.size()+1));
			itemsBought.add(item);
		}
	}
	//Method for listing items in transaction
	public void getTransactionDetails() {
		for(int i = 0; i < itemsBought.size(); i++) {
			LineItem item = itemsBought.get(i);
			String line = (i+1) + ".: " + item.getItem()+ " " 
			+ item.getQuantity() +" " + item.getCost();
			System.out.println(line);
		}
	}
	
	//Removes items from transaction
	public void removeLineItem(int index) {
		itemsBought.remove(index);
	}
	
	//Method for calculating total price of transaction
	//Sum of every LineItem within transaction
	public void calcTotalPrice() {
		double total = 0;
		for(LineItem item:itemsBought) {
			total += item.getCost();
		}
		totalPrice = total;
	}
	
	//Method for calculating discount points from price of transaction
	public void calcPurchasePoints() {
		int points = 0;
		double price = totalPrice;
		Math.round(price);
		points = (int)price / 10;
		purchasePoints = points;
	}
	
	public void setDiscountPrice(double discount) {
		this.discountPrice = totalPrice - discount;
	}
	
	public void setTransactionID(String id) {
		transactionID = id;
	}
	
	public void setTransactionDate(String date) {
		transactionDate = date;
	}
	
	public String getTransactionID() {
		return transactionID;
	}
	
	public String getDate() {
		return transactionDate;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	public double getDiscountPrice() {
		return discountPrice;
	}
	
	public int getPurchasePoints() {
		return purchasePoints;
	}
	
	public ArrayList<LineItem> getItemsBought(){
		return itemsBought;
	} 
	
	//Use ":" as delimiter between variables
	public String toString() {
		return transactionID + ":" + transactionDate + ":" 
				+ totalPrice + ":" + discountPrice + ":"
				+ purchasePoints;
	}
}
