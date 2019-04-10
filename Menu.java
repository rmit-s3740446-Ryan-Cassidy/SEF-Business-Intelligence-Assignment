package mypackage;

import java.util.*;

public class Menu {

	Scanner sc = new Scanner(System.in);

	public String displayStartUpMenu() {

		System.out.println("\r\nPress C if you are a customer and E if an employee");

		return sc.next();

	}

	public int displayCustomerMenu() {

		System.out.println("\n" + "Welcome\r\n" + "\n" + "Press 1 to display all products\r\n"
				+ "Press 2 to select a product to view its price\r\n" + "Press 3 to buy products\r\n");
		return sc.nextInt();

	}

	public String displayEmployeeMenu() {

		System.out.println("Press M if you are a Manager, W if WareHouseStaff and S for SalesStaff");

		return sc.next();

	}

	public int selectProduct() {

		System.out.println("Enter product id");
		int id = sc.nextInt();
		return id;

	}

	public int displayWareHouseStaffScreen() {

		System.out.println("Enter desired stock levels");
		int stockLevels = sc.nextInt();
		return stockLevels;

	}

	public int displayManagerMenu() {

		System.out.println("\n" + "Welcome\r\n" + "\n"
				+ "Press 1 to override the standard price for a specific product\r\n"
				+ "Press 2 to to offer special discounts\r\n"
				+ "Press 3 to place a purchase order for all items below replenishment level\r\n"
				+ "Press 4 to generate a sales report\r\n" + "Press 5 to generate a report on fast moving items\r\n"
				+ "Press 6 to generate a report on sales based on customer address\r\n"
				+ "Press 7 to generate supply report\r\n" + "Press 8 to list products generating the most revenue\r\n");
		return sc.nextInt();

	}

	public int displayManagerScreen(int id) {
		switch (id) {
		case 1:
			System.out.println("Enter the new desired price");
			int price = sc.nextInt();
			return price;
		case 2:
			System.out.println("Enter the discount percent");
			int percent = sc.nextInt();
			return percent;
		default:
			System.out.println("Invalid input");
			return 0;
		}

	}

}
