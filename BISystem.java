package mypackage;

import java.util.*;

public class BISystem {

	private ArrayList<Product> product = new ArrayList<>();
	private int currentProductIndex;

	public ArrayList<Product> getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product.add(product);

	}

	public boolean doesProductExist(int id) {
		boolean ProductExists = false;
		for (int i = 0; i <= product.size() - 1; i++) {
			if (product.get(i) != null) {
				if (product.get(i).getProductId() == id) {
					ProductExists = true;
					currentProductIndex = i;
					break;
				} else
					ProductExists = false;
			}
		}
		return ProductExists;
	}

	public void displayAllProducts() {

		for (int i = 0; i <= product.size() - 1; i++) {
			System.out.println(product.get(i));
		}
	}

	Menu menu = new Menu();

	public void bootSystem() {
		String choice = menu.displayStartUpMenu();
		int customerSubChoice;
		String employeeChoice;

		if (choice.equals("C")) {
			switch (customerSubChoice = menu.displayCustomerMenu()) {
			case 1:
				displayAllProducts();
				break;
			case 2:

				break;
			case 3:

				break;
			default:
				System.out.println("Input a number between one and three");
				break;
			}

		}

		else if (choice.equals("E")) {

			switch (employeeChoice = menu.displayEmployeeMenu()) {
			case "M":
				switch (menu.displayManagerMenu()) {
				case 1:
					if (doesProductExist(menu.selectProduct())) {
						Manager.overrideStandardPrice(product.get(currentProductIndex), menu.displayManagerScreen(1));
					}
				case 2:

				}
				break;
			case "W":

				if (doesProductExist(menu.selectProduct())) {
					WarehouseStaff.replenishStock(product.get(currentProductIndex), menu.displayWareHouseStaffScreen());
					displayAllProducts();
				}

				break;
			case "S":

				break;
			default:
				System.out.println("Input either M,W or E");
				break;
			}

		}

		else {

			System.out.println("Input either C or E");

		}
	}
}