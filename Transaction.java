import java.util.Date;
import java.util.ArrayList;

public class Transaction {

	private double totalPrice; 
	private String transactionID; 
	private Date transactionDate; 
	private ArrayList<Product> productsBought = new ArrayList<Product>(); 
	
	public Transaction (double totalPrice, String transactionID, Date transactionDate) { 
		this.totalPrice = totalPrice; 
		this.transactionID = transactionID; 
		this.transactionDate = transactionDate; 
	}
	
	
	
	//Getters and Setters 
	
	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public ArrayList<Product> getProductsBought() {
		return productsBought;
	}

	public void setProductsBought(ArrayList<Product> productsBought) {
		this.productsBought = productsBought;
	}
	
	
				
	
}
