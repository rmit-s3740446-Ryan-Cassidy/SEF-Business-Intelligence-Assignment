package main;
import java.util.ArrayList;

public class Transaction {

	private String transactionID;
	private String transactionDate = "date"; //IMPLEMENT DATETIME
	private ArrayList <LineItem> itemsBought = new ArrayList<>();
	private double totalPrice = 0;
	private double discountPrice = 0;
	private int purchasePoints = 0;
	
	//New transaction constructor
	public Transaction(String transactionID) {
		this.transactionID = transactionID;
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
	public void addItem() {
		
	}
	//Method for listing items in transaction
	public void getTransactionDetails() {
		
	}
	
	//Method for calculating total price of transaction
	public void calcTotalPrice() {
		
	}
	
	//Method for calculating discount points from price of transaction
	public void calcPurchasePoints() {
		
	}
	
	public void setDiscountPrice(double discount) {
		this.discountPrice = totalPrice - discount;
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
