import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class increasePointsTest {

	Transaction mockTransaction;
	SwipeCard mockCard;
	
	
	@Before
	public void setUp() throws Exception {
		mockTransaction = new Transaction (120.90, "6553718", null);
		mockCard = new SwipeCard ("001", 10);
		mockCard.getTransactions().add(mockTransaction);

	}
	

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		mockCard.increasePoints();
		assertEquals(110, mockCard.getLoyaltyPoints());
	}

}
