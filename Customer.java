import java.util.*;  

public class Customer {

	private String name; 
	private String custID;
	private String postCode; 
	
	
	 //test customer & card
	static Customer rio = new Customer("Rio", "C00001", "3000");
	SwipeCard card = new SwipeCard("00001", 0); 
	
	public static void main(String[] args)
	{
		rio.buy();
	}
	
	
	public Customer (String name, String custID, String postCode) {
		this.name = name; 
		this.custID = custID; 
		this.postCode = postCode;
		
	}
	
	Scanner console = new Scanner(System.in);
	
	public void buy() {
		
		
		ArrayList<Product> tempShoppingCart = new ArrayList<Product>(); 
	
		String buyMenu = "**** Product Category ****\n"
							+ "****      Fruits      ****\n" 
						    + "Apple                  (1)\n"
						    + "Orange                 (2)\n"
						    + "Pear                   (3)\n\n"
						    + "****    Vegetables    ****\n" 
				            + "Lettuce                (4)\n"
				            + "Cabbage                (5)\n"
				            + "Spinach                (6)\n\n"
				            + "****       Meat       ****\n" 
		                    + "Beef (1kg)             (7)\n"
		                    + "Chicken (1kg)          (8)\n"
		                    + "Pork (1kg)             (9)\n\n"
		                    + "Complete Transaction:  (0)\n"
		                    + "Exit:                (100)\n\n"		                    
		                    + "Enter your choice: ";
		
		int productChoice; 
		int productQty; 
		int option; 
		while (true) {
			System.out.print(buyMenu);
			
			option = console.nextInt(); 
			
			switch (option) {
		
				case 1: 					
					System.out.println("Enter the quantity of apples you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(apple);
						}
					}				
					
					System.out.println("Added " + productQty + " apple(s) into your shopping cart");	
					
					break; 
				case 2: 
					System.out.println("Enter the quantity of oranges you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(orange);
						}
					}
										
					System.out.println("Added " + productQty + " orange(s) into your shopping cart");	
					
					break; 
				case 3:
					System.out.println("Enter the quantity of pear you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(pear);
						}
					}
										
					System.out.println("Added " + productQty + " pear(s) into your shopping cart");	
					
					break; 
					
				case 4: 
					System.out.println("Enter the quantity of lettuce you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(lettuce);
						}
					}
										
					System.out.println("Added " + productQty + " lettuce(s) into your shopping cart");	
					
					break; 
				case 5: 
					System.out.println("Enter the quantity of cabbage you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(cabbage);
						}
					}
										
					System.out.println("Added " + productQty + " cabbage(s) into your shopping cart");	
					
					break; 
				
				case 6: 
					System.out.println("Enter the quantity of spinach you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(spinach);
						}
					}
										
					System.out.println("Added " + productQty + " spinach into your shopping cart");	
					
					break; 
					
				case 7: 
					System.out.println("Enter the quantity of beef you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(beef);
						}
					}
										
					System.out.println("Added " + productQty + "kg of beef into your shopping cart");	
					
					break; 
				case 8: 
					System.out.println("Enter the quantity of chicken you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(chicken);
						}
					}
										
					System.out.println("Added " + productQty + "kg of chicken into your shopping cart");	
					
					break; 
					
				case 9: 
					System.out.println("Enter the quantity of pork you want to buy: ");
					productQty = console.nextInt(); 
						
					if (productQty < 0) {
						System.out.println("Invalid quantity. Please enter again: ");
						productQty = console.nextInt(); 
					} else {
						for (int i = 0; i < productQty; i++) {
							tempShoppingCart.add(pork);
						}
					}
										
					System.out.println("Added " + productQty + "kg of pork into your shopping cart");	
					
					break; 
				case 0: 
					//complete transaction
					Transaction receipt = new Transaction (0.0, "T0000", null); 
					double tempPrice = 0; 
					
					for (int i = 0; i < tempShoppingCart.size(); i++) {
						tempPrice += tempShoppingCart.get(i).getPrice();
					}
					
					receipt.setTotalPrice(tempPrice);
					receipt.setProductsBought(tempShoppingCart);
					card.getTransactions().add(receipt);
					card.increasePoints();
					System.out.println("Total Price: $" + receipt.getTotalPrice());
					System.out.println("Total Loyalty Points earned: " + card.getLoyaltyPoints() + " points");
					break;
					
				case 100: 
					System.out.println("Thank you for shopping with the Fresh Foods People");
					System.exit(0);
					
				default: 
					
					System.out.println("Invalid entry. Returning to main menu... ");
					
					break; 
			
		
			}
		}
		
	}
	
	
	//temporary hard-coded products 
	Product apple = new Product ("F001", "Apple", 1.00, 0, 100, 20, 100);
	Product orange = new Product ("F002", "Orange", 1.20, 0, 100, 20, 100);
	Product pear = new Product ("F003", "Pear", 1.50, 0, 100, 20, 100);
	
	Product lettuce = new Product ("V001", "Lettuce", 3.00, 0, 100, 20, 100);
	Product cabbage = new Product ("V002", "Cabbage", 2.50, 0, 100, 20, 100);
	Product spinach = new Product ("V003", "Spinach", 2.00, 0, 100, 20, 100);
	
	Product beef = new Product ("M001", "Beef", 15.00, 0, 100, 20, 100);
	Product chicken = new Product ("M002", "Chicken", 9.00, 0, 100, 20, 100);
	Product pork = new Product ("M003", "Pork", 10.00, 0, 100, 20, 100);
	
	
	//Getters and Setters 
	public String getName() {
		return name; 
	}
	
	public void setName(String name) {
		this.name = name; 
	}
	
	
	public String getPostCode() {
		return postCode; 
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode; 
	}
	
	public SwipeCard getCard(){
		return card; 
	}
	
	public void setCard(SwipeCard card) {
		this.card = card; 
	}
	
	
	
}
