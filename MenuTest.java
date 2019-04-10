package mypackage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuTest {

	@Test
	public void testdoesProductExist() {
		Menu menu = new Menu();
		assertEquals(0, menu.displayManagerScreen(5));

	}

}
