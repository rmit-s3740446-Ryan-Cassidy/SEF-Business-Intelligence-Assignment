package main;

public class Manager extends Employee {
	
	public Manager(String employeeID, String employeeName, String employeePass) {
		super (employeeID, employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Manager";
	}
	
	public void replenishStock(Product product) {
		
	}
	
	public void overrideTransaction(Customer customer) {
		
	}
	
	public void promoPriceOverride(Product product) {
		
	}
	
	public void setBulkDiscounts(Product product) {
		
	}
	
	//Sales report
	public void generateSalesReport() {
		
	}
}
