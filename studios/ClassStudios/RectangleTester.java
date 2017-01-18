package ClassStudios;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTester {
	
	private Rectangle testRec;
	private Rectangle square;

	@Before
	public void setUp() throws Exception {
		this.testRec = new Rectangle(5, 10);
		this.square = new Rectangle(10, 10);
	}

	@Test
	public void testCompareSame() {
		String compRec = testRec.compare(5, 10);
		assertTrue("Error with rectangle of the same size", compRec.equals("same"));
	}
	
	@Test
	public void testCompareLarger() {
		String compRec = testRec.compare(3, 7);
		assertTrue("Error with rectangle of larger size", compRec.equals("larger"));
	}
	
	@Test
	public void testCompareSmaller() {
		String compRec = testRec.compare(7, 13);
		assertTrue("Error with rectangle of smaller size", compRec.equals("smaller"));
	}
	
	@Test
	public void testSquareTrue() {
		assertTrue("Error with getArea()", square.getArea() == 100);
		assertTrue("Error with square() return", square.square() == true);
	}


}
