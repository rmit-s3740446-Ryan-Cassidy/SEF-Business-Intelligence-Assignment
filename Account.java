package main;


import java.util.ArrayList;
import java.util.Scanner;

public class Account {
	
	//mock object variables here
	//Arrays
	private ArrayList <Employee> eArray = new ArrayList<>();
	private ArrayList <Customer> cArray = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	

//Account menu should be moved to BISystem
	public void createStaffMenu() {
		String id, name, password, type="";
		System.out.print("Enter employee ID: ");
		id = sc.nextLine();
		System.out.print("Enter employee name");
		name = sc.nextLine();
		System.out.print("Enter employee password");
		password = sc.nextLine();
		System.out.println("Employee type:");
		System.out.println("1. Manager");
		System.out.println("2. Sales");
		System.out.println("3. Warehouse");
		switch(sc.nextInt()) {
		case 1: type = "Manager";
		case 2: type = "Sales";
		case 3: type = "Warehouse";
		}
		if (register(id, name, password, type) == false) {
			System.out.println("Employee already registered");
		}
		else {
			System.out.println("Employee "+ name +" registered");
		}
	}
	//Account menu should be moved to BISystem
	public void createCustomerMenu() {
		String id, name, postcode;
		System.out.print("Enter customer ID: ");
		id = sc.nextLine();
		System.out.print("Enter customer name: ");
		name = sc.nextLine();
		System.out.print("Enter customer postcode: ");
		postcode = sc.nextLine();
		if (register(id, name, postcode) == false) {
			System.out.println("Customer already registered");
		}
		else {
			System.out.println("Customer "+ name +" registered");
		}
	}
	
	//register() overloaded method (customer)
	//Method takes strings, searches array for matching customerId
	//If customerId is not present, create new customer object
	//Add customer object to array, return true
	//Else if customerId is present, return false
	public boolean register(String customerId, String name, String postcode) {
		if (checkArray(customerId) == true) {
			return false;
		}
		else {
			Customer c = new Customer(customerId, name, postcode);
			cArray.add(c);
			return true;
		}
	}
	
	//register() overloaded method (employee)
	//Method takes strings, searches array for matching employeeId
	//If employeeId is not present, create new employee object with ID + pass
	//Maybe consider employee type as an input string (Manager/Sales/Warehouse)
	//Add employee to array, return true
	//Else if employeeId is present, return false
	public boolean register(String employeeId, String employeeName, String employeePass, String employeeType) {
		if (checkArray(employeeId) == true) {
			return false;
		}
		else {
			if (employeeType == "Manager") {
				Manager m = new Manager(employeeId, employeeName, employeePass);
				eArray.add(m);
			}
			else if (employeeType == "Sales") {
				SalesStaff s = new SalesStaff(employeeId, employeeName, employeePass);
				eArray.add(s);
			}
			else if (employeeType == "Warehouse") {
				WarehouseStaff w = new WarehouseStaff(employeeId, employeeName, employeePass);
				eArray.add(w);
			}
			return true;
		}
		
	}
	//validate() overloaded method (customer)
	//Method must take strings, search array with getcustomerId
	//If customerId is there, return it, else return null
	public Customer validate(String customerId) {
		for (int i = 0; i < cArray.size(); i++) {
			if(cArray.get(i).getCustomerID().equals(customerId)) {
				Customer c = cArray.get(i);
				return c;
			}
		}
	return null;
	}
	
	//validate() overloaded method (employee)
	//Method must take strings, search array with getemployeeId
	//If employeeId is there, check password string with get passwordId
	//If password is valid then return employee, else return null
	public Employee validate(String employeeId, String employeePass) {
		for (int i = 0; i < eArray.size(); i++) {
			if (eArray.get(i).getEmployeeId().equals(employeeId)) {
				if(eArray.get(i).getEmployeePass().equals(employeePass)) {
					Employee e = eArray.get(i);
					return e;
				}
			}
		}
		return null;
	}
	//Method for checking array for IDs
	public boolean checkArray(String userId) {
		for (int i = 0; i < eArray.size(); i++) {
			if (eArray.get(i).getEmployeeId().contentEquals(userId)) {
				return true;
			}
		}
		for (int i = 0; i < cArray.size(); i++) {
			if (cArray.get(i).getCustomerID().contentEquals(userId)) {
				return true;
			}
		}
		return false;
	}
	//Method for updating customer array with current user (SCRAP THIS)
	public void updateCustomer(Object currentUser) {
		for (int i = 0; i < cArray.size(); i++) {
			if (((Customer) currentUser).getCustomerID() == cArray.get(i).getCustomerID()) {
				cArray.set(i, ((Customer) currentUser));
			}
		}
		
	}
	
	//Method for updating employee array with current user (SCRAP THIS)
	public void updateEmployee(Object currentUser) {
		for (int i = 0; i < eArray.size(); i++) {
			//Maybe check for instance of (Manager, sales warehouse)
			if (currentUser instanceof Manager) {
				if (((Manager) currentUser).getEmployeeId() == eArray.get(i).getEmployeeId()) {
					eArray.set(i, ((Manager) currentUser));
				}	
			}
			else if (currentUser instanceof SalesStaff) {
				if (((SalesStaff) currentUser).getEmployeeId() == eArray.get(i).getEmployeeId()) {
					eArray.set(i, ((SalesStaff) currentUser));
				}
			}
			else if (currentUser instanceof WarehouseStaff) {
					if (((WarehouseStaff) currentUser).getEmployeeId() == eArray.get(i).getEmployeeId()) {
						eArray.set(i, ((WarehouseStaff) currentUser));
				}
			}
		}
	}
	
	public ArrayList<Customer> getcArray() {
		return cArray;
	}
	
	public ArrayList<Employee> geteArray() {
		return eArray;
	}
}
