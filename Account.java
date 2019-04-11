package main;

import java.util.ArrayList;

public class Account {
	
	//mock object variables here
	//Arrays
	private ArrayList <Employee> eArray;
	private ArrayList <Customer> cArray;
	
	public Account() {
		eArray = new ArrayList<Employee>();
		cArray = new ArrayList<Customer>();
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
	public boolean register(String employeeId, String employeePass, int employeeType) {
		if (checkArray(employeeId) == true) {
			return false;
		}
		else {
			if (employeeType == 0) {
				Manager m = new Manager(employeeId, employeePass);
				eArray.add(m);
			}
			else if (employeeType == 1) {
				SalesStaff s = new SalesStaff(employeeId, employeePass);
				eArray.add(s);
			}
			else if (employeeType == 2) {
				WarehouseStaff w = new WarehouseStaff(employeeId, employeePass);
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
			if(cArray.get(i).getCustomerId().equals(customerId)) {
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
				if(eArray.get(i).getPass().equals(employeePass)) {
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
			if (cArray.get(i).getCustomerId().contentEquals(userId)) {
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
