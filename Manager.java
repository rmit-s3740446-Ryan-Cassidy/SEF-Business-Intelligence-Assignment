package main;

import java.util.ArrayList;

public class Manager extends Employee {

	public Manager(String employeeID, String employeeName, String employeePass) {
		super(employeeID, employeeName, employeePass);
	}

	// Use ":" as delimiter between variables
	@Override
	public String toString() {
		return getEmployeeId() + ":" + getEmployeeName() + ":" + getEmployeePass() + ":" + "Manager";
	}

	public void replenishStock(Product product, int quantity) {

		product.setStockLevel(quantity);
	}

	public void overrideTransaction(Customer customer) {

	}

	public void promoPriceOverride(Product product, int price) {
		product.setPrice(price);

	}

	public void placeOrder(ArrayList<Product> pArray) {

		for (int i = 0; i <= pArray.size() - 1; i++) {
			if (pArray.get(i).getStockLevel() < pArray.get(i).getReplenishLevel()) {
				pArray.get(i).setStockLevel(pArray.get(i).getReorderQuantity());
			}
		}

	}

	public void setBulkDiscounts(Product product, int discountPercent) {
		product.setDiscountPercent(discountPercent);
	}

	// Sales report
	public void generateSalesReport() {

	}
}
