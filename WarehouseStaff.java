package main;


public class WarehouseStaff extends Employee {
	
	//New WarehouseStaff constructor
	public WarehouseStaff(String employeeName, String employeePass) {
	super (employeeName, employeePass);
	}
	
	//DB constructor
	public WarehouseStaff(String employeeId, String employeeName, String employeePass) {
		super (employeeId,employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Warehouse Staff";
	}
	
	public void replenishStock(Product p, int quantity) {
		p.setReplenishLevel(quantity);
}

}
