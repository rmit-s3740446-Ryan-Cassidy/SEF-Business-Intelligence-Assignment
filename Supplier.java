package main;

public class Supplier {
	private String supplierID;
	private String name;
	private String address;
	private String phoneNo;
	
	public Supplier(String supplierID, String name, String address, String phoneNo) {
		this.supplierID = supplierID;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	
	public String getSupplierID() {
		return supplierID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return supplierID +":" + name + ":" + address + ":" + phoneNo;
	}
}
