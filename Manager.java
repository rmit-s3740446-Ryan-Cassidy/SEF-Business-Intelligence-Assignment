package main;
import java.util.ArrayList;

public class Manager extends Employee {
	
	//New Manager constructor
	public Manager(String employeeName, String employeePass) {
		super (employeeName, employeePass);
	}
	
	//DB Constructor
	public Manager(String employeeID, String employeeName, String employeePass) {
		super (employeeID, employeeName, employeePass);
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return getEmployeeId() + ":" +getEmployeeName() + ":" + getEmployeePass() + ":" + "Manager";
	}
	
	public void replenishStock(Product product, int quantity, String date) {

		product.setStockLevel(quantity);
		Order o = product.createOrder(quantity, date);
		product.getSupplier().addOrder(o);
	}

	public void promoPriceOverride(Product product, int price) {
		product.setPrice(price);

	}

	public void placeOrder(ArrayList<Product> pArray, String date) {
		

		for (int i = 0; i <= pArray.size() - 1; i++) {
			if (pArray.get(i).getStockLevel() < pArray.get(i).getReplenishLevel()) {
				pArray.get(i).setStockLevel(pArray.get(i).getReorderQuantity());
				Order o = pArray.get(i).createOrder(pArray.get(i).getReorderQuantity(), date);
				pArray.get(i).getSupplier().addOrder(o);
			}
		}

	}

	public void setBulkDiscounts(Product product, int bulkSalesAmt, int discountPercent) {
		product.setBulkSalesAmt(bulkSalesAmt);
		product.setDiscountPercent(discountPercent);
	}

	// Sales report
	public void generateSalesReport() {

}
}
