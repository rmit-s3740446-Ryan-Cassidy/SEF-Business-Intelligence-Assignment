package main;


public abstract class Employee {

	private String employeeID;
	private String employeeName;
	private String employeePass;
	
	//New employee constructor
	public Employee(String employeeName, String employeePass) {
		this.employeeName = employeeName;
		this.employeePass = employeePass;
	}
	//DB Constructor
	public Employee(String employeeID, String employeeName, String employeePass) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.employeePass = employeePass;
	}
	
	public String getEmployeeId() {
		return employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public String getEmployeePass() {
		return employeePass;
	}
	
	public void setEmployeeID(String id) {
		employeeID = id;
	}
	
	public abstract String toString();
}
