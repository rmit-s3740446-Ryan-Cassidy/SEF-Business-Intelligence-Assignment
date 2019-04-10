package mypackage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.easymock.EasyMock;
import static org.easymock.EasyMock.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.BeforeClass;
import org.junit.Test;

public class BISystemTest {

	@Test
	public void testdoesProductExist() {
		BISystem system = new BISystem();
		Product p1 = new Product(1, "Apples", 10, 10, 1000, 500, 500);
		system.setProduct(p1);
		assertTrue(system.doesProductExist(1));

	}

}
