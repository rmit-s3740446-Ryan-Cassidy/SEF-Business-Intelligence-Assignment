package main;

public class Product {

	String productId;
	String productName;
	String category;
	double price;
	int bulkSalesAmt;
	int discountPercent;
	int stockLevel;
	int replenishLevel;
	int reorderQuantity;
	Supplier supplier;

	public Product(String productId, String productName, String category, double price, int bulkSalesAmt,
			int discountPercent, int stockLevel, int replenishLevel, int reorderQuantity) {
		// , Supplier supplier) {//vineet commented for simplicity added category in
		// constrctor

		this.productId = productId;
		this.productName = productName;
		this.category = category;// vineet added
		this.price = price;
		this.bulkSalesAmt = bulkSalesAmt;
		this.discountPercent = discountPercent;
		this.stockLevel = stockLevel;
		this.replenishLevel = replenishLevel;
		this.reorderQuantity = reorderQuantity;
		this.supplier = supplier;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getBulkSalesAmt() {
		return bulkSalesAmt;
	}

	public void setBulkSalesAmt(int amt) {
		this.bulkSalesAmt = amt;
	}

	public int getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(int stockLevel) {
		this.stockLevel = stockLevel;
	}

	public int getReplenishLevel() {
		return replenishLevel;
	}

	public void setReplenishLevel(int replenishLevel) {
		this.replenishLevel = replenishLevel;
	}

	public int getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public String getCategory() {
		return category;
	}

	// Use ":" as delimiter between variables
	@Override
	public String toString() {
		return productId + ":" + productName + ":" + price + ":" + bulkSalesAmt + ":" + discountPercent + ":"
				+ stockLevel + ":" + replenishLevel + ":" + reorderQuantity + ":" + supplier.getSupplierID();
	}

}
