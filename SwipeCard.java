import java.util.ArrayList;

public class SwipeCard {

	private int loyaltyPoints = 0; 
	private String cardID; 
	private Customer member; 
	private ArrayList<Transaction> transactions = new ArrayList<Transaction>(); 
	
	public SwipeCard (String cardID, int loyaltyPoints) {
		this.cardID = cardID; 
		this.loyaltyPoints = loyaltyPoints; 
		
	}
	
	public void increasePoints () {
		double totalPrice = transactions.get(transactions.size()-1).getTotalPrice();
		if (totalPrice >= 1000) {
			loyaltyPoints += 1500 ; 
		} else if (totalPrice >= 800) {
			loyaltyPoints += 800;
		} else if (totalPrice >= 500) {
			loyaltyPoints += 500;
		} else if (totalPrice >= 300) {
			loyaltyPoints += 300;
		} else if (totalPrice >= 100) {
			loyaltyPoints += 100;
		} else if (totalPrice >= 80) {
			loyaltyPoints += 80; 
		} else if (totalPrice >= 60) {
			loyaltyPoints += 60;
		} else if (totalPrice >= 40) {
			loyaltyPoints += 40;
		} else if (totalPrice >= 20) {
			loyaltyPoints += 20;
		} else if (totalPrice >= 10) {
			loyaltyPoints += 10;
		} else {
			loyaltyPoints += 0;
		}
	}


//	public int increasePoints () {
//		double totalPrice = transactions.get(transactions.size()-1).getTotalPrice();
//		if (totalPrice >= 1000) {
//			loyaltyPoints += 1500 ; 
//		} else if (totalPrice >= 800) {
//			loyaltyPoints += 800;
//		} else if (totalPrice >= 500) {
//			loyaltyPoints += 500;
//		} else if (totalPrice >= 300) {
//			loyaltyPoints += 300;
//		} else if (totalPrice >= 100) {
//			loyaltyPoints += 100;
//		} else if (totalPrice >= 80) {
//			loyaltyPoints += 80; 
//		} else if (totalPrice >= 60) {
//			loyaltyPoints += 60;
//		} else if (totalPrice >= 40) {
//			loyaltyPoints += 40;
//		} else if (totalPrice >= 20) {
//			loyaltyPoints += 20;
//		} else if (totalPrice >= 10) {
//			loyaltyPoints += 10;
//		} else {
//			loyaltyPoints += 0;
//		}
//		return loyaltyPoints;
//	}
	
	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}


	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}


	public String getCardID() {
		return cardID;
	}


	public void setCardID(String cardID) {
		this.cardID = cardID;
	}


	public Customer getMember() {
		return member;
	}


	public void setMember(Customer member) {
		this.member = member;
	}


	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	
}
