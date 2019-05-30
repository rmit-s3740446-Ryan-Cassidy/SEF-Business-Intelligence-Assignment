package main;

import java.util.ArrayList;
import java.util.Scanner;

public class BISystem {
	private ArrayList<Product> pArray = new ArrayList<>();
	private ArrayList<Supplier> sArray = new ArrayList<>();
	private Customer currentCustomer = null;
	private Employee currentEmployee = null;
	private Scanner sc = new Scanner(System.in);
	Account account = Account.getInstance();
	Storage storage = new Storage();
	private int option;
	
	//Main starts here
	public static void main(String[] args) {
		BISystem system = new BISystem();
		system.DB();
		system.start();

	}
	//Method for pulling from DB
	public void DB() {
		storage.dbExists();
		storage.fillArray(account.getcArray(), account.geteArray(), sArray, pArray);
	}
	
	//Start menu
	public void start() {
		do {
		try {
			System.out.println("----Welcome to BISystem----");
			System.out.println("1. Customer Login");
			System.out.println("2. Employee Login");
			System.out.println("3. Save to Database");
			System.out.println("4. Quit");
		option = sc.nextInt();
		
		switch (option) {
		case 0 : start();
		break;
		
		case 1 : customerLogin();
		break;
		
		case 2 : employeeLogin();
		break;
		
		case 3 :storage.updateDBAll(account.getcArray(), account.geteArray(), sArray, pArray);
		System.out.println("Database Saved");
		break;
		
		case 4 : break;
		}
		} catch (Exception e) {
			option = 0;
			System.out.println(e.getMessage());
			sc.nextLine();
			continue;
		}
		}while (option != 4);
	}
	
	public void customerLogin() {
		try {
		String customerDetails;
		System.out.print("Enter customer id: ");
		customerDetails = sc.next();
		currentCustomer = account.validate(customerDetails);
		Shop shop = new Shop(pArray, currentCustomer);
		shop.customerMenu();
		start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			start();
		}
	}
	
	public void employeeLogin() {
		try {
		String id, pass;
		System.out.print("Enter employee id: ");
		id = sc.next();
		System.out.print("Enter employee password: ");
		pass = sc.next();
		currentEmployee = account.validate(id, pass);
		if (currentEmployee != null) {
			//check employee type
			if (currentEmployee instanceof Manager) {
				Management management = new Management(pArray, sArray, currentEmployee);
				management.managerMenu();
			}
			if (currentEmployee instanceof SalesStaff) {
				Management management = new Management(pArray, sArray, currentEmployee);
				management.salesMenu();
			}
			if (currentEmployee instanceof WarehouseStaff) {
				Management management = new Management(pArray, sArray, currentEmployee);
				management.warehouseMenu();
			}
		}
		else {
			//return to login
			System.out.println("Incorrect username or password");
			return;
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
	}
	
	public ArrayList<Product> getPArray(){
		return pArray;
	}
	
	public Customer getCurrentCustomer() {
		return currentCustomer;
	}
	
	public Employee getCurrentEmployee() {
		return currentEmployee;
	}

}
