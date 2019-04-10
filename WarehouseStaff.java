package mypackage;

public class WarehouseStaff extends Employee {

	public static void replenishStock(Product product, int stockLevels) {

		product.setStockLevel(stockLevels);

	}

}
