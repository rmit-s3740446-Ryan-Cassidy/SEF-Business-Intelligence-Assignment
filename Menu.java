package mypackage;

import java.util.*;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public int displayRegistrationLoginOption() {
		System.out.println("Enter 1 to login 1  and 2 to register as a cutomer and 3 to register as a employee");
		return sc.nextInt();

	}

	public String[] displayValidateUserMenu() {
		String[] userDetails = new String[2];
		System.out.println("Enter user id");
		userDetails[0] = sc.next();
		if (userDetails[0].contains("E")) {
			System.out.println("Enter password");
			userDetails[1] = sc.next();
		}

		return userDetails;

	}

	public String[] displayCustomerRegistrationMenu() {
		String[] registrationDetails = new String[3];
		System.out.println("Enter customer id");
		registrationDetails[0] = sc.next();
		System.out.println("Enter your name");
		registrationDetails[1] = sc.next();
		System.out.println("Enter your postcode");
		registrationDetails[2] = sc.next();
		return registrationDetails;

	}

	public String[] displayEmployeeRegistrationMenu() {
		String[] registrationDetails = new String[3];
		System.out.println("Enter employee id");
		registrationDetails[0] = sc.next();
		System.out.println("Enter your desired password");
		registrationDetails[1] = sc.next();
		System.out.println("Enter 0 if you are a maneger 1 if salesstaff and 2 if warehousestaff");
		registrationDetails[2] = sc.next();
		return registrationDetails;

	}

	public int displayCustomerMenu() {

		System.out.println("\n" + "Welcome\n" + "\n" + "Press 1 to display all products\n"
				+ "Press 2 to select a product to view its price\n" + "Press 3 to buy products\n");
		return sc.nextInt();

	}

	public String selectProduct() {

		System.out.println("Enter product id");
		String id = sc.next();
		return id;

	}

	public int displayWareHouseStaffScreen() {

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
