package Robot;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RobotTest {
	
	private Robot bb8;
	private Robot r2d2;

	@Before
	public void setUp() throws Exception {
		this.bb8 = new Robot("BB-8", 0, 0, 8, "north");
		this.r2d2 = new Robot("R2D2", 3, 2, 4, "west");
	}

	@Test
	public void testMoveSpacesY() {
		assertTrue("Error in instantiating location y", bb8.getY() == 0);
		bb8.move(4);
		assertTrue("Error in determining y-axis spaces to move", bb8.getY() == 32);
	}
	@Test
	public void testMoveSpacesX() {
		assertTrue("Error in instantiating location x", r2d2.getX() == 3);
		r2d2.move(4);
		assertTrue("Error in determining x-axis spaces to move", r2d2.getX() == -13);
	}
}
