package main;

public class WarehouseStaff extends Employee {
	
	public WarehouseStaff(String employeeId, String employeeName, String employeePass) {
		super (employeeId,employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Warehouse Staff";
	}

}
