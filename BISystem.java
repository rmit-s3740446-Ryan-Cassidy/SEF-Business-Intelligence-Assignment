package main;
import java.util.ArrayList;
import java.util.Scanner;

public class BISystem {
	private ArrayList<Product> pArray = new ArrayList<>();
	private ArrayList<Supplier> sArray = new ArrayList<>();
	private Customer currentCustomer = null;
	private Employee currentEmployee = null;
	private Scanner sc = new Scanner(System.in);
	Menu menu = new Menu();
	Account account = new Account();
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
		try {
			System.out.println("----Welcome to BISystem----");
			System.out.println("1. Customer Login");
			System.out.println("2. Employee Login");
			System.out.println("3. Print Product Array");
			System.out.println("4. Save to Database");
		option = sc.nextInt();
		
		switch (option) {
		case 0 : start();
		break;
		
		case 1 : customerLogin();
		break;
		
		case 2 : employeeLogin();
		break;
		
		case 3 : printProduct();
		break;
		
		case 4 :storage.updateDBAll(account.getcArray(), account.geteArray(), sArray, pArray);
		System.out.println("Save to Database attempted");
		start();
		break;
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//TESTING REMOVE LATER
	public void printProduct() {
		System.out.println("BISystem ARRAY INSTANCE");
		for (Product products:pArray) {
			System.out.println(products.toString());
		}
		start();
	}
	
	public void customerLogin() {
		String customerDetails;
		System.out.print("Enter customer id: ");
		customerDetails = sc.next();
		currentCustomer = account.validate(customerDetails);
		if (currentCustomer != null) {
			//Start shop class
			Shop shop = new Shop(pArray, currentCustomer);
			shop.shopMenu();
			start();
		}
		else {
			//return to login
			System.out.println("Customer not found");
			start();
		}
	}
	
	public void employeeLogin() {
		String id, pass;
		System.out.println("Enter employee id");
		id = sc.next();
		System.out.println("Enter employee password");
		pass = sc.next();
		currentEmployee = account.validate(id, pass);
		if (currentEmployee != null) {
			//check employee type
			if (currentEmployee instanceof Manager) {
				managerMenu();
			}
			else if (currentEmployee instanceof SalesStaff) {
				salesMenu();
			}
			else if (currentEmployee instanceof WarehouseStaff) {
				warehouseMenu();
			}
		}
		else {
			//return to login
			System.out.println("Incorrect username or password");
			start();
		}		
	}
	
	public void logout() {
		currentCustomer = null;
		currentEmployee = null;
		start();
	}
	
	public void salesMenu() {
		System.out.println("Hello Sales Staff " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Register Customers");
		System.out.println("2. Edit Customer Transactions[NYI]");
		System.out.println("3. Logout");
		option = sc.nextInt();
		switch(option) {
		case 1: account.createCustomerMenu();
		case 2: //Create instance of edit transaction class
		case 3: start();
		}
		salesMenu();
	}
	
	public void warehouseMenu() {
		System.out.println("Hello Warehouse Staff " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Manage Products[NYI]");
		System.out.println("2. Manage Suppliers[NYI]");
		System.out.println("3. Logout");
		option = sc.nextInt();
		switch(option) {
		case 1: //Create instance of management class, call warehouse menu
		case 2: //Create instance of management class, call warehouse menu
		case 3: start();
		}
		warehouseMenu();
		
	}
	
	public void managerMenu() {
		System.out.println("Hello manager " + currentEmployee.getEmployeeName());
		System.out.println("---------------");
		System.out.println("1. Register Customers");
		System.out.println("2. Register Staff");
		System.out.println("3. Edit Customer Transactions[NYI]");
		System.out.println("4. Manage Products[NYI]");
		System.out.println("5. Manage Suppliers[NYI]");
		System.out.println("6. Generate Reports[NYI]");
		System.out.println("7. Logout");
		option = sc.nextInt();
		
		switch(option) {
		case 1: account.createCustomerMenu();
		case 2: account.createStaffMenu();
		case 3: //Create instance of edit transaction class
		case 4: //Create instance of management class, call manager menu
		case 5: //Create instance of management class, call manager menu
		case 6: //Create instance of report class
		case 7: start();
		//Add rest of cases
		}
		managerMenu();
	}

}
