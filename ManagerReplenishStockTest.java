package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerReplenishStockTest
{
	private Manager m1;
	private Product p1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
		// Manager object with username of "name" and password of "pass"
		m1 = new Manager("name", "pass");

		// product object Apple with a price of $1, bulk sales amount of 10 with
		// 10% discount, and wholesale price of $0.50 each.
		p1 = new Product("F01", "Apple", "Fruit", 1, 10, 10, 200, 20, 200, 0.5, null);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		assertEquals(200, p1.getStockLevel());
		m1.replenishStock(p1, 300, "01062019");
		assertEquals(300, p1.getStockLevel());
	}

}
