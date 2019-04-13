
public class Product {

	String productId;
	String productName;
	double price;
	int bulkSalesAmt;
	int discountPercent;
	int stockLevel;
	int replenishLevel;
	int reorderQuantity;
	Supplier supplier;

	public Product(String productId, String productName, double price, int discountPercent, int stockLevel, int replenishLevel, int reorderQuantity) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.discountPercent = discountPercent;
		this.stockLevel = stockLevel;
		this.replenishLevel = replenishLevel;
		this.reorderQuantity = reorderQuantity;
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
	
	public int getBulkSalesAmt()
	{
		return bulkSalesAmt;
	}
	
	public void setBulkSalesAmt(int amt)
	{
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

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", discountPercent=" + discountPercent + ", stockLevel=" + stockLevel + ", replenishLevel="
				+ replenishLevel + ", reorderQuantity=" + reorderQuantity + ", supplier=" + supplier + "]";
	}

}