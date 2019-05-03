package main;
import java.util.ArrayList;

public class Customer {
	
	private String customerID;
	private String name;
	private String postCode;
	private ArrayList <Transaction> Transactions;
	private SwipeCard swipeCard;
	
	//New customer constructor
	public Customer(String customerID, String name, String postCode) {
		this.customerID = customerID;
		this.name = name;
		this.postCode = postCode;
		Transactions = new ArrayList<>();
		swipeCard = new SwipeCard(customerID, postCode);
	}
	
	//Database customer constructor
	public Customer(String customerID, String name, String postCode, SwipeCard swipeCard) {
		this.customerID = customerID;
		this.name = name;
		this.postCode = postCode;
		Transactions = new ArrayList<>();
		this.swipeCard = swipeCard;
	}
	
	public void addTransaction() {
		//Method for adding transactions
		//Discount transaction with SwipeCard points
		//Deduct credit from SwipeCard
		//Add points to SwipeCard based on transaction
		//Add transaction to Transactions ArrayList
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public SwipeCard getSwipeCard() {
		return swipeCard;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return Transactions;
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return customerID + ":" + name + ":" + postCode;
	}
}
