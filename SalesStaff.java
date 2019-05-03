package main;

public class SalesStaff extends Employee {
	
	public SalesStaff(String employeeId, String employeeName, String employeePass) {
		super (employeeId, employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Sales Staff";
	}

}
