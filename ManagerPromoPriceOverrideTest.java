package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManagerPromoPriceOverrideTest
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
		p1 = new Product("M01", "Beef", "Meat", 10, 3, 10, 100, 20, 150, 6, null);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	public void testPromoPriceOverride()
	{
		m1.promoPriceOverride(p1, 7);
		assertEquals(7, p1.getPrice());
	}
}
