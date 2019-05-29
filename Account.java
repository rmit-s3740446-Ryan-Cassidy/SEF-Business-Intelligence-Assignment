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
	public void register(String employeeName, String employeePass, String employeeType) {
			if (employeeType == "Manager") {
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
		else if (employeeType == "Sales") {
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
			else if (employeeType == "Warehouse") {
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
	//Method must take strings, search array with getcustomerId
	//If customerId is there, return it, else return null
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
	//Method must take strings, search array with getemployeeId
	//If employeeId is there, check password string with get passwordId
	//If password is valid then return employee, else return null
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
