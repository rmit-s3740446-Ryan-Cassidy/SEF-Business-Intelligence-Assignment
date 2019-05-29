package main;


import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	Scanner sc = new Scanner(System.in);
	ArrayList<Product> pArray;
	Customer customer;
	Transaction shoppingCart = new Transaction();
	int option;
	
	public Shop(ArrayList <Product> pArray, Customer currentCustomer) {
		this.pArray = pArray;
		this.customer = currentCustomer;
	}
	
	public void customerMenu() {
		do {
		System.out.println("Welcome " +customer.getName());
		System.out.println("You have "+customer.getSwipeCard().getCredit() +" credits");
		System.out.println("1. Add credits");
		System.out.println("2. Browse Store");
		System.out.println("3. Logout");
		option = sc.nextInt();
		
		switch (option) {
		case 1:
			creditMenu();
			break;
			
		case 2:
			shopMenu();
			break;
			
		case 3:
			break;
		}
		}while(option != 3);
	}
	
	public void creditMenu() {
		int credits;
		System.out.println("Enter credit amount");
		credits = sc.nextInt();
		customer.getSwipeCard().addCredit(credits);
		System.out.println("Thank you for your patronage");
	}
	public void shopMenu() {
		do {
		System.out.println("Welcome " +customer.getName());
		System.out.println("You have "+customer.getSwipeCard().getCredit() +" credits");
		System.out.println("1. Browse Products by Category");
		System.out.println("2. Search for Product by ID");
		System.out.println("3. Display shopping cart");
		System.out.println("4. Purchase shopping cart");
		System.out.println("5. Clear shopping cart");
		System.out.println("6. Back");
		option = sc.nextInt();
	switch (option) {
	case 1: 
		browseCategory();
		break;
	
	case 2: 
		searchProductID();
		break;
	
	case 3: 
		displayCart();
		break;
	
	case 4: 
		purchaseCart();
		break;
	
	case 5: 
		clearCart();
		break;
	
	case 6: 
		break;
	}
	}while(option != 6);
	}
	
	public void browseCategory() {
		String category = null;
		ArrayList<Product> categoryList = new ArrayList<Product>();
		System.out.println("Categories");
		System.out.println("1. Vegetables");
		System.out.println("2. Fruit");
		System.out.println("3. Frozen");
		System.out.println("4. Deli");
		System.out.println("5. Snacks");
		System.out.println("6. Back to shop menu");
		option = sc.nextInt();
		switch (option) {
		case 1: category = "Vegetables";
		break;
		
		case 2: category = "Fruit";
		break;
		
		case 3: category = "Frozen";
		break;
		
		case 4: category = "Deli";
		break;
		
		case 5: category = "Snacks";
		break;
		
		case 6: break;
		}
		if(category != null) {
			for (Product product:pArray) {
				if(product.getCategory() == category) {
					categoryList.add(product);
				}
			}
//			for (int i = 0; i < pArray.size(); i++) {
//				if (pArray.get(i).getCategory() == category) {
//					categoryList.add(pArray.get(i));
//				}
//			}
			if(!categoryList.isEmpty()) {
				System.out.println("Select an item");
			for (int i = 0; i < categoryList.size(); i++) {
				System.out.println((i+1) + ".:" + categoryList.get(i).getProductName());
			}
			option = sc.nextInt();
			sc.nextLine();
			productDetailsMenu(categoryList.get(option - 1));
			}
			else {
				System.out.println("No items under this category");
			}
		}
		
	}
	
	public void searchProductID() {
		try {
		String id;
		System.out.println("Enter product ID");
		id = sc.next();
		productDetailsMenu(getProduct(id));
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Method for displaying shopping cart
	public void displayCart() {
		if(shoppingCart.getItemsBought().isEmpty()) {
			System.out.println("Cart Empty");
		}
		else {
		shoppingCart.getTransactionDetails();
		sc.nextLine();
		}
	}
	
	public void productDetailsMenu(Product product) {
		try {
		int quantity;
		System.out.println("Item: " +product.getProductName());
		System.out.println("Price: "+product.getPrice());
		if(product.getBulkSalesAmt() > 0) {
		System.out.println("Bulk Discount: "+product.getBulkSalesAmt());
		}
		System.out.println();
		System.out.println("Add to cart?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.print("Enter quantity: ");
			quantity = sc.nextInt();
			if(quantity > 0) {
				addLineItem(product, quantity);
				System.out.println(quantity + "" + product.getProductName() + " added to cart");
			}
			else {
				System.out.println("Canceled");
			}
			break;
		case 2:
			break;	
		}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//Method for adding transaction to currentCustomer
	public void purchaseCart() {
		if(shoppingCart.getTotalPrice() < customer.getSwipeCard().getCredit()) {
			customer.addTransaction(shoppingCart);
			shoppingCart.getItemsBought().clear();
			System.out.println("Shopping cart purchased");	
		}
		else {
			System.out.println("Not enough credit to purchase cart.");
		}
	}
	//Method for clearing Cart line items
	public void clearCart() {
		shoppingCart.getItemsBought().clear();
		System.out.println("Cart Emptied");
	}
	//Method for adding LineItem to shopping cart object
	public void addLineItem(Product product, int quantity) {
		shoppingCart.addItem(product.createLineItem(quantity));
		shoppingCart.calcTotalPrice();
		shoppingCart.calcPurchasePoints();
		System.out.println(quantity + product.getProductName()+ " added to cart");
	}
	
	//implement CustomException
	public Product getProduct(String id) throws ProductNotFoundException {
		for (int i = 0; i < pArray.size(); i++) {
			if(pArray.get(i).getProductId() == id) {
				return pArray.get(i);
			}
		}
		throw new ProductNotFoundException();
	}
}
