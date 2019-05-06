package main;


public class SwipeCard {

	private String swipeCardID;
	private int loyaltyPoints = 0; 
	private int credit = 0;
	
	//New customer SwipeCard constructor
	public SwipeCard(String customerID, String postCode) {
		swipeCardID = (customerID + "_" + postCode);
	}
	
	//Database SwipeCard constructor
	public SwipeCard(String swipeCardID, int loyaltyPoints, int credit) {
		this.swipeCardID = swipeCardID;
		this.loyaltyPoints = loyaltyPoints;
		this.credit = credit;
	}
	
	
	public void increasePoints() {
		//REWRITE POINTS METHOD
	}
	
	public String getSwipeCardID() {
		return swipeCardID;
	}
	
	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}


	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}

	//Use ":" as delimiter between variables
	public String toString() {
		return swipeCardID + ":" +loyaltyPoints + ":" + credit;
	}
	
	
	
}
