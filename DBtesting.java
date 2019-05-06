package main;

import java.util.ArrayList;

import main.*;

//This class is just a rough main class I wrote to test DB inserting and retrieving
//Check it out if you want to see what the arrays will look like on startup
public class DBtesting {

	DBtesting() {
		// Initialize Arrays
		ArrayList<Customer> cArray = new ArrayList<>();
		ArrayList<Employee> eArray = new ArrayList<>();
		ArrayList<Supplier> sArray = new ArrayList<>();
		ArrayList<Product> pArray = new ArrayList<>();
		// Inserting objects for DB insert testing
		// Create objects
		// Employees
//		Manager m = new Manager("001", "ryan", "pass1");
//		SalesStaff s = new SalesStaff("002", "kim", "pass2");
//		WarehouseStaff w = new WarehouseStaff("003", "tom", "pass3");
//		eArray.add(m);
//		eArray.add(s);
//		eArray.add(w);
//		//Customers
		Customer c1 = new Customer("001", "dale", "3045");
//		Customer c2 = new Customer("002", "eric", "3098");
//		//Customer Transaction
//		Transaction t1 = new Transaction("001");
//		Transaction t2 = new Transaction("002");
//		//Customer Transaction LineItem
//		LineItem l1 = new LineItem("0001", "apple", 1);
//		LineItem l2 = new LineItem("0002", "banana", 2);
//		t1.getItemsBought().add(l1);
//		t2.getItemsBought().add(l2);
//		c1.getTransactions().add(t1);
//		c2.getTransactions().add(t2);
		cArray.add(c1);
//		cArray.add(c2);
//		//Suppliers
//		Supplier s1 = new Supplier("001", "Jims", "somewheresville", "12345678");
//		Supplier s2 = new Supplier("002", "Janes","overtherelane", "87654321");
//		sArray.add(s1);
//		sArray.add(s2);
//		//Products
//		Product apple = new Product("001", "apple", 10.5, 5, 20, 10, 5, 6, s1);
//		Product banana = new Product("002", "banana", 15.0, 10, 30, 10, 5, 8, s2);
//		pArray.add(apple);
//		pArray.add(banana);
		// Test DB
		Storage storage = new Storage();
		// storage.createDB();
		// storage.updateDBAll(cArray, eArray, sArray, pArray);
		storage.fillArray(cArray, eArray, sArray, pArray);
		// Loops for testing array contents
//		for (Customer customer:cArray) {
//			for (Transaction transaction:customer.getTransactions()) {
//				for (LineItem item:transaction.getItemsBought()) {
//					System.out.println(item.toString());
//				}
//			}
//			System.out.println(customer.toString());
//			System.out.println(customer.getSwipeCard().toString());
//		}

//		for (Employee employee:eArray) {
//			System.out.println(employee.toString());
//		}

//		for (Supplier supplier:sArray) {
//			System.out.println(supplier.toString());
//		}

//		for (Product product:pArray) {
//			System.out.println(product.toString());
//		}

	}

}
