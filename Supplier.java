package main;

import java.util.ArrayList;

public class Supplier {
	private String supplierID;
	private String name;
	private String address;
	private String phoneNo;
	private ArrayList<Order> oArray;
	
	public Supplier(String supplierID, String name, String address, String phoneNo) {
		this.supplierID = supplierID;
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		oArray = new ArrayList<Order>();
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
	
	public ArrayList<Order> getoArray(){
		return oArray;
	}
	
	//Add orders to supplier collection and assign unique ID
	public void addOrder(Order order) {
		if(oArray.isEmpty()) {
			order.setOrderID(supplierID +"_"+ String.valueOf(1));
			oArray.add(order);
		}
		else {
			order.setOrderID(supplierID +"_" +String.valueOf(oArray.size()+1));
			oArray.add(order);
		}
	}
	
	//Use ":" as delimiter between variables
	public String toString() {
		return supplierID +":" + name + ":" + address + ":" + phoneNo;
	}
}
