package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Management { // vineet added class
	private Scanner sc = new Scanner(System.in);
	ArrayList<Product> pArray = new ArrayList<>();

	public ArrayList<Supplier> manageSuppliersMenu(ArrayList<Supplier> sArray) {

		System.out.println("1. Add a new supplier");
		System.out.println("2. Remove an existing supplier");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("Enter supplier id");
			String supplierID = sc.next();
			System.out.println("Enter supplier name");
			String name = sc.next();
			System.out.println("Enter supplier address");
			String address = sc.next();
			System.out.println("Enter supplier phoneNo");
			String phoneNo = sc.next();
			Supplier s = new Supplier(supplierID, name, address, phoneNo);
			sArray.add(s);
			break;

		case 2:

			System.out.println("Enter supplier id");
			String supplierToBeRemoved = sc.next();

			for (int i = 0; i <= sArray.size() - 1; i++) {
				if (sArray.get(i).getSupplierID().equals(supplierToBeRemoved)) {
					sArray.remove(i);
				}
			}
			break;

		}
		return sArray;

	}

	public Product selectProduct() {

		System.out.println("Enter product id");
		String id = sc.next();

		for (int i = 0; i <= pArray.size() - 1; i++) {

			if (pArray.get(i).getProductId().equals(id)) {
				return pArray.get(i);
			}

		}
		return null;

	}

	public int manageProductsForWarehouse(Employee e, ArrayList<Product> pArray) {
		this.pArray = pArray;
		System.out.println("Enter desired stock levels");
		int stockLevels = sc.nextInt();
		return stockLevels;

	}

	public void manageProductsForManager(Employee e, ArrayList<Product> pArray) {

		Product p;
		this.pArray = pArray;
		System.out.println("1. OverRide price");
		System.out.println("2. Offer discounts");
		System.out.println("3. Place order for products below replenish level");
		System.out.println("4. Replenish Stock Levels");

		int option = sc.nextInt();

		switch (option) {
		case 1:
			p = selectProduct();
			System.out.println("Enter the desired promotional price");
			((Manager) e).promoPriceOverride(p, sc.nextInt());

			break;

		case 2:
			p = selectProduct();
			System.out.println("Enter the desired discount percent");
			((Manager) e).setBulkDiscounts(p, sc.nextInt());
			break;
		case 3:

			((Manager) e).placeOrder(pArray);
			break;

		case 4:
			p = selectProduct();
			System.out.println("Enter the desired stock levels");
			((Manager) e).replenishStock(p, sc.nextInt());
			break;

		}

	}
}