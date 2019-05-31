package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagementSetBulkDiscountTest
{
	private Manager m1;
	private Product p1;

	@Before
	public void setUp() throws Exception
	{
		// Manager object with username of "name" and password of "pass"
		m1 = new Manager("name", "pass");

		// product object Apple with a price of $1, bulk sales amount of 10 with
		// 10% discount, and wholesale price of $0.50 each.
		p1 = new Product("F01", "Apple", "Fruit", 1, 10, 10, 200, 20, 200, 0.5, null);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testSetBulkDiscounts()
	{
		m1.setBulkDiscounts(p1, 15, 20);
		assertEquals(15, p1.getBulkSalesAmt());
		assertEquals(20, p1.getDiscountPercent());
	}

}
