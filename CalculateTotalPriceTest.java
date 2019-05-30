package main;
//Rio's JUnit test
import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateTotalPriceTest {

	private SwipeCard mockCard;
	private Shop mockShop; 
	private Customer mockCustomer; 
	private Product apple; 
	private ArrayList<Product> mockProductArray; 
	
	
	@Before
	public void setUp() throws Exception {
		
		
		// SwipeCard object has 0 loyaltyPoints and 100 credits
		mockCard = new SwipeCard("cust_01_3006", 0, 100); 
		
		mockCustomer = new Customer("cust_01", "Mocka", "3006", mockCard); 

		//Apple price of $1, bulk sales amount of 10 and bulk sales price of 50c
		apple = new Product("F01", "Apple", "Fruits", 1, 10, 10, 200, 200, 5, 0.5, null); 
		mockProductArray = new ArrayList<Product>(); 
		mockProductArray.add(apple);
		
		mockShop = new Shop(mockProductArray, mockCustomer); 
		
		

	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		mockShop.addLineItem(apple, 9);
		assertEquals(9, mockShop.shoppingCart.getTotalPrice(), 0.001);
	}

}
