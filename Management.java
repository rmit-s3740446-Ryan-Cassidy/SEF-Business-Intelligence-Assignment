package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Management { // vineet added class
	private Scanner sc = new Scanner(System.in);
	ArrayList<Product> pArray;
	ArrayList<Supplier> sArray;
	Account account = Account.getInstance();
	Employee currentEmployee;
	int option;
	
	public Management(ArrayList <Product> pArray, ArrayList <Supplier> sArray, 
						Employee currentEmployee) {
		this.pArray = pArray;
		this.sArray = sArray;
		this.currentEmployee = currentEmployee;
	}
	
	public void managerMenu() {
		do {
		System.out.println("Hello Manager " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Register Customers");
		System.out.println("2. Register Staff");
		System.out.println("3. Edit Customer Transactions[NYI]");
		System.out.println("4. Manage Products");
		System.out.println("5. Manage Suppliers");
		System.out.println("6. Generate Reports[NYI]");
		System.out.println("7. Logout");
		option = sc.nextInt();
		
		switch(option) {
		case 1: 
			createCustomerMenu();
			break;
		case 2: 
			createEmployeeMenu();
			break;
		case 3: break;//Create instance of edit transaction class 
		case 4:
			manageProductsForManager();
			break;
		case 5: 
			manageSuppliersMenu();
			break;
		case 6: break;//Create instance of report class
		case 7: break;
		//Add rest of cases
		} 
		} while(option != 7);
	}
	
	public void salesMenu() {
		do {
		System.out.println("Hello Sales Staff " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Register Customers");
		System.out.println("2. Edit Customer Transactions[NYI]");
		System.out.println("3. Logout");
		option = sc.nextInt();
		switch(option) {
		case 1: createCustomerMenu();
		case 2: //Create instance of edit transaction class
		case 3: return;
		}
		} while(option != 3);
		
	}
	
	public void warehouseMenu() {
		do {
		System.out.println("Hello Warehouse Staff " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Manage Products");
		System.out.println("2. Manage Suppliers");
		System.out.println("3. Logout");
		option = sc.nextInt();
		switch(option) {
		case 1: 
			manageProductsForWarehouse();
			break;
		case 2: 
			manageSuppliersMenu();
			break;
		case 3: break;
		}
		}while (option != 3);
	}

	public void manageSuppliersMenu() {

		System.out.println("1. Add a new supplier");
		System.out.println("2. Remove an existing supplier");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			String supplierID, name, address, phoneNo;
			sc.next();
			System.out.println("Enter supplier name");
			name = sc.next();
			System.out.println("Enter supplier address");
			address = sc.next();
			System.out.println("Enter supplier phoneNo");
			phoneNo = sc.next();
			if(sArray.isEmpty()) {
				supplierID = String.valueOf(1);
			}
			else {
				supplierID = String.valueOf(sArray.size() + 1);
			}
			Supplier s = new Supplier(supplierID, name, address, phoneNo);
			sArray.add(s);
			System.out.println("Supplier " + name + " added");
			return;

		case 2:

			System.out.println("Enter supplier id");
			String supplierToBeRemoved = sc.next();

			for (int i = 0; i <= sArray.size() - 1; i++) {
				if (sArray.get(i).getSupplierID().equals(supplierToBeRemoved)) {
					sArray.remove(i);
				}
			}
			return;

		}

	}

	public Product selectProduct() {
		sc.nextLine();

		System.out.println("Enter product id");
		String id = sc.next();

		for (int i = 0; i <= pArray.size() - 1; i++) {

			if (pArray.get(i).getProductId().equals(id)) {
				return pArray.get(i);
			}

		}
		return null;

	}

	public int manageProductsForWarehouse() {
		sc.nextLine();
		System.out.println("Enter desired stock levels");
		int stockLevels = sc.nextInt();
		return stockLevels;

	}

	public void manageProductsForManager() {
		sc.nextLine();
		String date;
		int quantity, discountPercent, bulkSalesAmt;
		Product p;
		System.out.println("1. Add new product");
		System.out.println("2. Override price");
		System.out.println("3. Offer discounts");
		System.out.println("4. Place order for products below replenish level");
		System.out.println("5. Replenish product stock");
		System.out.println("6. Back to manager menu");

		int option = sc.nextInt();

		switch (option) {
		case 1: 
			addProduct();
			break;
		case 2:
			p = selectProduct();
			System.out.print("Enter the desired promotional price: ");
			((Manager) currentEmployee).promoPriceOverride(p, sc.nextInt());
			break;

		case 3:
			p = selectProduct();
			System.out.print("Enter bulk sales amount: ");
			bulkSalesAmt = sc.nextInt();
			System.out.print("Enter discount percent: ");
			discountPercent = sc.nextInt();
			((Manager) currentEmployee).setBulkDiscounts(p, bulkSalesAmt, discountPercent);
			break;
			
		case 4:
			System.out.print("Enter date: ");
			date = sc.next();
			((Manager) currentEmployee).placeOrder(pArray, date);
			System.out.println("All stock replenished");
			break;

		case 5:
			p = selectProduct();
			System.out.println("Enter the desired stock level: ");
			quantity = sc.nextInt();
			System.out.println("Enter date: ");
			date = sc.next();
			((Manager) currentEmployee).replenishStock(p, quantity, date);
			System.out.println("All " + p.getProductName() + " stock replenished");
			break;
			
		case 6:
			break;
		}
		

	}
	
	public void addProduct() {
		String productID, productName, category = "";
		double price, wholesaleCost;
		int stockLevel;
		Supplier supplier;
		if (sArray.isEmpty()) {
			System.out.println("Please add suppliers");
		}
		else {
			System.out.print("Enter product name: ");
			productName = sc.next();
			System.out.println("Select category: ");
			System.out.println("1. Vegetables");
			System.out.println("2. Fruit");
			System.out.println("3. Frozen");
			System.out.println("4. Deli");
			System.out.println("5. Snacks");
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
			}
			System.out.print("Enter price: ");
			price = sc.nextDouble();
			System.out.print("Enter wholesale cost: ");
			wholesaleCost = sc.nextDouble();
			System.out.print("Enter stock level: ");
			stockLevel = sc.nextInt();
			System.out.println("Select a supplier: ");
			for(int i = 0; i < sArray.size(); i++) {
				System.out.println(i+1 + " "+ sArray.get(i).getName());
			}
			option = sc.nextInt();
			supplier = sArray.get(option - 1);
			if(pArray.isEmpty()) {
				productID = String.valueOf(1);
			}
			else {
				productID = String.valueOf(pArray.size()+1);
			}
			Product product = new Product(productID, productName, category, 
											price, wholesaleCost,stockLevel, supplier);
			Order o = product.createOrder(stockLevel, "today");
			pArray.add(product);
			supplier.addOrder(o);
			System.out.println(product.getProductName() + " added.");
		}
		
	}
	
	public void createCustomerMenu() {
		sc.nextLine();
		String name, postcode;
		System.out.print("Enter customer name: ");
		name = sc.nextLine();
		System.out.print("Enter customer postcode: ");
		postcode = sc.nextLine();
		account.register(name, postcode);
		System.out.println("Customer " + name + " registered");
}
	
	public void createEmployeeMenu() {
		sc.nextLine();
		String name, password, type = "";
		System.out.print("Enter employee name");
		name = sc.nextLine();
		System.out.print("Enter employee password");
		password = sc.nextLine();
		System.out.println("Employee type:");
		System.out.println("1. Manager");
		System.out.println("2. Sales");
		System.out.println("3. Warehouse");
		switch (sc.nextInt()) {
		case 1:
			type = "Manager";
		case 2:
			type = "Sales";
		case 3:
			type = "Warehouse";
		}
		account.register(name, password, type);
		System.out.println("Employee " + name + " registered");
	}
}
