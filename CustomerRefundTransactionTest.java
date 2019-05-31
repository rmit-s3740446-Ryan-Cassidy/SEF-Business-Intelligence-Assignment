package main;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerRefundTransactionTest
{
	private ArrayList<Transaction> mockTrans;
	private SwipeCard mockCard;
	private Customer mockCust;
	private Transaction t1;
//	private LineItem li1;
//	private ArrayList<LineItem> mockLIs;

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
//		li1 = new LineItem("LI1", "Beef", 2, 20);
//		mockLIs = new ArrayList<LineItem>();
//		mockLIs.add(li1);
//		
		// Transaction object with total price of $20, 0 discountPrice, and 4 loyalty points
		t1 = new Transaction("Trans1", "31052019", 20, 0, 2);
		mockTrans = new ArrayList<Transaction>();
		mockTrans.add(t1);
		
		// SwipeCard object with 2 loyalty points and 100 credits
		mockCard = new SwipeCard("cust_001_3000", 4, 100);
		
		// Customer object with the name "theDude", postcode of 3000, and mockCard as SwipeCard object
		mockCust = new Customer("cust_001", "theDude", "3000", mockCard);
		mockCust.addTransaction(t1);
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void test()
	{
		assertEquals(1, mockCust.getTransactions().size());
		assertEquals(2, mockCust.getTransactions().get(0).getPurchasePoints());
		mockCust.refundTransaction();
		assertEquals(2, mockCust.getSwipeCard().getLoyaltyPoints());
	}

}
