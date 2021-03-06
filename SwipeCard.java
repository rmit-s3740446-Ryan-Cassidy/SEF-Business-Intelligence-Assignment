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
	
	
	public int increasePoints(int points) {
		int discount = 0;
		loyaltyPoints += points;
		while(loyaltyPoints >= 20) {
			discount += 5;
			loyaltyPoints -= 20;
		}
		return discount;
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
	
	public int getCredit() {
		return credit;
	}
	
	public void addCredit(int amount) {
		credit += amount;
	}
	
	public void deductCredit(int amount) {
		credit -= amount;
	}

	//Use ":" as delimiter between variables
	public String toString() {
		return swipeCardID + ":" +loyaltyPoints + ":" + credit;
	}
	
	
	
}
