package main;

import java.util.*;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public int loginMenu() throws Exception {
		try {
		System.out.println("----Welcome to BI System----");
		System.out.println("1. Customer Login");
		System.out.println("2. Employee Login");
		System.out.println("3. Print Product Array"); //TESTING REMOVE LATER
		if (sc.nextInt() > 3) {
			throw new Exception();
		}
		return sc.nextInt();
		} catch (Exception e) {
			System.out.println("Please input 1 or 2");
			return 0;
		}

	}

	public String customerLoginPrompt() {
		String customerDetails;
		System.out.println("Enter customer id");
		customerDetails = sc.next();
		return customerDetails;

	}
	
	public String[] employeeLoginPrompt() {
			String[] employeeDetails = new String[2];
			System.out.println("Enter employee id");
			employeeDetails[1] = sc.next();
			System.out.println("Enter employee password");
			employeeDetails[2] = sc.next();
			return employeeDetails;
	}

	public String[] customerRegistrationMenu() {
		String[] registrationDetails = new String[3];
		System.out.println("Enter customer id");
		registrationDetails[0] = sc.next();
		System.out.println("Enter your name");
		registrationDetails[1] = sc.next();
		System.out.println("Enter your postcode");
		registrationDetails[2] = sc.next();
		return registrationDetails;

	}

	public String[] employeeRegistrationMenu() {
		String[] registrationDetails = new String[3];
		System.out.println("Enter employee id");
		registrationDetails[0] = sc.next();
		System.out.println("Enter your desired password");
		registrationDetails[1] = sc.next();
		System.out.println("Enter 0 if you are a manager 1 if salesstaff and 2 if warehousestaff");
		registrationDetails[2] = sc.next();
		return registrationDetails;

	}

	public int customerMenu(String name) {

		System.out.println("\n" + "Welcome " +name +"\n");
		
		System.out.println("1. Browse products by category");
		System.out.println("2. Search by product ID");
		System.out.println("3. Purchase shopping cart");
		System.out.println("4. Clear shopping cart");
		System.out.println("5. Logout");
		return sc.nextInt();

	}

	public String productIdPrompt() {

		System.out.println("Enter product id");
		String id = sc.next();
		return id;

	}

	public int displayWareHouseStaffMenu() {

		System.out.println("Enter desired stock levels");
		int stockLevels = sc.nextInt();
		return stockLevels;

	}

	public int displayManagerMenu() {

		System.out.println("\n" + "Welcome\n" + "\n" + "Press 1 to override the standard price for a specific product\n"
				+ "Press 2 to to offer special discounts\n"
				+ "Press 3 to place a purchase order for all items below replenishment level\n"
				+ "Press 4 to generate a sales report\n" + "Press 5 to generate a report on fast moving items\n"
				+ "Press 6 to generate a report on sales based on customer address\n"
				+ "Press 7 to generate supply report\n" + "Press 8 to list products generating the most revenue\n");
		return sc.nextInt();

	}

	public int[] displayManagerScreen(int id) {
		int[] data = null;
		switch (id) {
		case 1:
			System.out.println("Enter the new desired price");
			data[0] = sc.nextInt();
			return data;
		case 2:
			System.out.println("Enter the bulk amount for discount");
			data[0] = sc.nextInt();
			System.out.println("Enter the discount percent");
			data[1] = sc.nextInt();
			return data;
		default:
			System.out.println("Invalid input");
			return data;
		}

	}

}
