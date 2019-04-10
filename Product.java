package mypackage;

public class Product {

	int productId;
	String productName;
	int price;
	int discountPercent;
	int stockLevel;
	int replenishLevel;
	int reorderQuantity;
	Supplier supplier;

	public Product(int productId, String productName, int price, int discountPercent, int stockLevel,
			int replenishLevel, int reorderQuantity) {

		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.discountPercent = discountPercent;
		this.stockLevel = stockLevel;
		this.replenishLevel = replenishLevel;
		this.reorderQuantity = reorderQuantity;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
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
