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

	public boolean doesProductExist(String id) {
		boolean ProductExists = false;
		for (int i = 0; i <= product.size() - 1; i++) {
			if (product.get(i) != null) {
				if (product.get(i).getProductId().equals(id)) {
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
			System.out.println(product.get(i).getProductId() + " " + product.get(i).getProductName());
		}
	}

	Menu menu = new Menu();
	Account account = new Account();
	boolean registrationSuccessful = false;
	String[] registrationDetails = new String[3];

	public void bootSystem() {
		int option = menu.displayRegistrationLoginOption();
		if (option == 1)
			login();
		else if (option == 2)
			registerCustomer();
		else
			registerEmployee();

	}

	public void login() {

		String[] userDetails = menu.displayValidateUserMenu();

		int managerTaskChoice;
		String selectedProductId = null;

		if (userDetails[1] != null) {

			Employee e = account.validate(userDetails[0], userDetails[1]);

			if (e != null) {

				if (e instanceof Manager) {

					managerTaskChoice = menu.displayManagerMenu();

					if (managerTaskChoice > 0 && managerTaskChoice < 5) {

						selectedProductId = menu.selectProduct();
					}

					switch (managerTaskChoice) {
					case 1:
						if (doesProductExist(selectedProductId)) {
							((Manager) e).promoPriceOverride(product, selectedProductId,
									menu.displayManagerScreen(1)[0]);
						}
					case 2:
						if (doesProductExist(selectedProductId)) {
							((Manager) e).setBulkDiscounts(product, selectedProductId, menu.displayManagerScreen(2)[0],
									menu.displayManagerScreen(2)[1]);
						}
					case 3:
						if (doesProductExist(selectedProductId)) {
							((Manager) e).autoPurchaseBelowReplenishmentLvl(product);
						}

					}

				}

				else if (e instanceof WarehouseStaff) {

					selectedProductId = menu.selectProduct();

					if (doesProductExist(selectedProductId)) {
						System.out.println("Stock level before:" + product.get(currentProductIndex).getStockLevel());
						((WarehouseStaff) e).replenishStock(product, selectedProductId,
								menu.displayWareHouseStaffScreen());
						System.out.println("Stock level after:" + product.get(currentProductIndex).getStockLevel());
					}

				}

				else {
				}

			}

			else {

				registerEmployee();
			}

		}

		else {

			if (account.validate(userDetails[0]) != null) {

				int customerChoice = menu.displayCustomerMenu();
				switch (customerChoice) {
				case 1:
					displayAllProducts();
				case 2:
					doesProductExist(menu.selectProduct());
					System.out.println("Price is " + product.get(currentProductIndex).getPrice());
				case 3:
				}

			}

			else {

				registerCustomer();
			}

		}

	}

	public void registerEmployee() {
		registrationDetails = menu.displayEmployeeRegistrationMenu();
		registrationSuccessful = account.register(registrationDetails[0], registrationDetails[1],
				registrationDetails[2]);

		if (registrationSuccessful) {

			login();

		}
	}

	public void registerCustomer() {
		registrationDetails = menu.displayCustomerRegistrationMenu();
		registrationSuccessful = account.register(registrationDetails[0], registrationDetails[1],
				registrationDetails[2]);

		if (registrationSuccessful) {

			menu.displayCustomerMenu();
		}

	}
}
