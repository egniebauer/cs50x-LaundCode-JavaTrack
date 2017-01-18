package ClassStudios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTester {
	
	private BaseballPlayer playerNew;
	private BaseballPlayer playerSeasoned;
	
	@Before
	public void setUp() throws Exception {
		this.playerNew = new BaseballPlayer("Whiffle McNewb", 00, "right");
		this.playerSeasoned = new BaseballPlayer("Homer McL33t", 54, "switch", 1000, 10000, 100000);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
