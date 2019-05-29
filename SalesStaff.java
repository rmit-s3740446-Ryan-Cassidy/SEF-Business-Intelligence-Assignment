package main;


public class SalesStaff extends Employee {
	
	//New SalesStaff constructor
	public SalesStaff(String employeeName, String employeePass) {
		super (employeeName, employeePass);
	}
	//DB constructor
	public SalesStaff(String employeeId, String employeeName, String employeePass) {
		super (employeeId, employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Sales Staff";
	}

}
