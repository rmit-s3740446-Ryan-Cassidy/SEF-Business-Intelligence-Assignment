package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
	Scanner sc = new Scanner(System.in);
	ArrayList <Product> pArray;
	Customer currentUser;
	Transaction shoppingCart;
	int option;
	
	public Shop(ArrayList <Product> pArray, Customer currentUser) {
		this.pArray = pArray;
		this.currentUser = currentUser;
	}
	public void shopMenu() {
		System.out.println("\n" + "Welcome " +currentUser.getName() +"\n");
		System.out.println("1. Print product array"); //Should be browse by category
		System.out.println("2. Change Product Price"); //Should be Search by product ID
		System.out.println("3. Display shopping cart[NYI]");
		System.out.println("4. Purchase shopping cart[NYI]");
		System.out.println("5. Clear shopping cart[NYI]");
		System.out.println("6. Logout");
		option = sc.nextInt();
	switch (option) {
	case 1: browseCategory();
	break;
	
	case 2: searchProductID();
	break;
	
	case 3: displayCart();
	break;
	
	case 4: purchaseCart();
	break;
	
	case 5: clearCart();
	break;
	
	case 6: break;
	}
	}
	
	public void browseCategory() {
		//NYI just printing all products
		System.out.println("Shop ARRAY INSTANCE");
		for (Product product:pArray) {
			System.out.println(product.toString());
		}
		shopMenu();
		
	}
	
	public void searchProductID() {
		shopMenu();		
	}
	//Method for displaying shopping cart
	public void displayCart() {
		
	}
	//Method for adding transaction to currentUser
	public void purchaseCart() {
		
	}
	//Method for clearing Cart items
	public void clearCart() {
		
	}
	//Method for adding LineItem to shopping cart
	public void addLineItem() {
		
	}
}
