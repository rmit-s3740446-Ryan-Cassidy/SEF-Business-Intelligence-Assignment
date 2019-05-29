package main;

public class Product {

	private String productId;
	private String productName;
	private String category;
	private double price;
	private int bulkSalesAmt;
	private int discountPercent;
	private int stockLevel;
	private int replenishLevel;
	private int reorderQuantity;
	private double wholesaleCost;
	private Supplier supplier;
	
	//New product constructor
	public Product(String productID, String productName, String category,
					double price, double wholeSaleCost, int stockLevel, Supplier supplier) {
		this.productId = productID;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.wholesaleCost = wholeSaleCost;
		this.stockLevel = stockLevel;
		this.supplier = supplier;
		bulkSalesAmt = 0;
		discountPercent = 0;
		replenishLevel = 0;
		reorderQuantity = 0;
	}
	
	//DB Constructor
	public Product(String productId, String productName, String category, double price, 
			int bulkSalesAmt, int discountPercent, int stockLevel, 
			int replenishLevel, int reorderQuantity, double wholesaleCost, Supplier supplier) {

		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.price = price;
		this.bulkSalesAmt = bulkSalesAmt;
		this.discountPercent = discountPercent;
		this.stockLevel = stockLevel;
		this.replenishLevel = replenishLevel;
		this.reorderQuantity = reorderQuantity;
		this.wholesaleCost = wholesaleCost;
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
		this.stockLevel += stockLevel;
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
	
	public double getWholesaleCost() {
		return wholesaleCost;
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
	
	public Order createOrder(int quantity, String date) {
		double cost = wholesaleCost * quantity;
		Order order = new Order(productName, quantity, cost, date);
		return order;
	}
	
	public LineItem createLineItem(int quantity) {
		double discountPrice;
		if (bulkSalesAmt > 0) {
			if(quantity > bulkSalesAmt) {
				discountPrice = price * 100 / discountPercent;
				LineItem item = new LineItem(productName, quantity, discountPrice);
				return item;
			}
		}
		LineItem item = new LineItem(productName, quantity, price);
		return item;
	}

	//Use ":" as delimiter between variables
	@Override
	public String toString() {
		return productId + ":" + productName + ":" + category+ ":" + price + ":"
				+bulkSalesAmt + ":" + discountPercent + ":" + stockLevel + ":"
				+ replenishLevel + ":" + reorderQuantity+":" + wholesaleCost + ":" + supplier.getSupplierID();
	}

}
