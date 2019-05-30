package main;

import java.util.ArrayList;

public class Customer {
	
	private String customerID;
	private String name;
	private String postCode;
	private ArrayList <Transaction> transactions;
	private SwipeCard swipeCard;
	
	//New customer constructor
	public Customer(String name, String postCode) {
		this.name = name;
		this.postCode = postCode;
		transactions = new ArrayList<>();
	}
	
	//Database customer constructor
	public Customer(String customerID, String name, String postCode, SwipeCard swipeCard) {
		this.customerID = customerID;
		this.name = name;
		this.postCode = postCode;
		transactions = new ArrayList<>();
		this.swipeCard = swipeCard;
	}
	
	public void addTransaction(Transaction transaction) {
		//Casting down to INT for credit deductions, investigate later
		int discount;
		discount = swipeCard.increasePoints(transaction.getPurchasePoints());
		swipeCard.deductCredit((int)transaction.getTotalPrice() - discount);
		if (transactions.isEmpty()) {
			transaction.setTransactionID(customerID + "_" + String.valueOf(1));
			transactions.add(0, transaction);
		}
		else {
			transaction.setTransactionID(customerID + "_" + String.valueOf(transactions.size() + 1));
			transactions.add(0, transaction);
		}
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
		return transactions;
	}
	
	//Return latest transaction inserted
	public Transaction getLatestTransaction() {
		if(transactions.isEmpty()) {
			return null;
		}
		else {
		return transactions.get(0);
		}
	}
	
	public double refundTransaction() {
		double price = transactions.get(0).getTotalPrice();
		int points = (int) price / 10;
		swipeCard.setLoyaltyPoints(swipeCard.getLoyaltyPoints() - points);
		swipeCard.addCredit((int)price);
		return price;
	}
	
	public double refundLineItem(int i) {
		double cost = transactions.get(0).getItemsBought().get(i).getCost();
		transactions.get(0).getItemsBought().remove(i);
		swipeCard.addCredit((int)cost);
		return cost;
	}
	
	public void setCustomerID(String id) {
		customerID = id;
		swipeCard = new SwipeCard(customerID, postCode);
		swipeCard.getSwipeCardID();
		
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return customerID + ":" + name + ":" + postCode;
	}
}
