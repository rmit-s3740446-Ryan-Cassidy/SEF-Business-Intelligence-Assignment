package main;


import java.util.ArrayList;

public class Account {
	
	//Arrays
	private ArrayList <Employee> eArray = new ArrayList<>();
	private ArrayList <Customer> cArray = new ArrayList<>();
	private static Account instance;
	
	private Account() {
		
	}
	
	//Singleton Pattern
		public static Account getInstance() {
			if (instance == null) {
				instance = new Account();
			}
			return instance;
		}

	
	
	//Consider implementing validate method for error checking
	public void register(String name, String postcode) {
		Customer c = new Customer(name, postcode);
		if (cArray.isEmpty()) {
			c.setCustomerID(String.valueOf(1));
			cArray.add(c);	
		}
		else {
			c.setCustomerID(String.valueOf(cArray.size()+1));
			cArray.add(c);
		}
	}
	
	//Consider implementing validate method for error checking
	public void register(String employeeName, String employeePass, int employeeType) {
			if (employeeType == 1) {
				Manager m = new Manager(employeeName, employeePass);
				if(eArray.isEmpty()) {
					m.setEmployeeID(String.valueOf(1));
					eArray.add(m);
				}
				else {
					m.setEmployeeID(String.valueOf(eArray.size()+1));
					eArray.add(m);
				}
			}
		else if (employeeType == 2) {
				SalesStaff s = new SalesStaff(employeeName, employeePass);
				if(eArray.isEmpty()) {
					s.setEmployeeID(String.valueOf(1));
					eArray.add(s);
				}
				else {
					s.setEmployeeID(String.valueOf(eArray.size()+1));
					eArray.add(s);
				}
			}
			else if (employeeType == 3) {
				WarehouseStaff w = new WarehouseStaff(employeeName, employeePass);
				if (eArray.isEmpty()) {
					w.setEmployeeID(String.valueOf(1));
					eArray.add(w);
				}
				else {
					w.setEmployeeID(String.valueOf(eArray.size()+1));
					eArray.add(w);
				}
			}
		}
	//validate() overloaded method (customer)
	public Customer validate(String customerId) throws InvalidCustomerException {
		for (int i = 0; i < cArray.size(); i++) {
			if(cArray.get(i).getCustomerID().equals(customerId)) {
				Customer c = cArray.get(i);
				return c;
			}
		}
	throw new InvalidCustomerException();
	}
	
	//validate() overloaded method (employee)
	public Employee validate(String employeeId, String employeePass) throws InvalidEmployeeException {
		for (int i = 0; i < eArray.size(); i++) {
			if (eArray.get(i).getEmployeeId().equals(employeeId)) {
				if(eArray.get(i).getEmployeePass().equals(employeePass)) {
					Employee e = eArray.get(i);
					return e;
				}
			}
		}
		throw new InvalidEmployeeException();
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
	
	public ArrayList<Customer> getcArray() {
		return cArray;
	}
	
	public ArrayList<Employee> geteArray() {
		return eArray;
	}
}
