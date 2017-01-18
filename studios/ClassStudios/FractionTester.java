package ClassStudios;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FractionTester {
	
	Fraction fracOne;
	Fraction fracTwo;
	
	@Before
	public void setUp() throws Exception {
		this.fracOne = new Fraction(24, 36);
		this.fracTwo = new Fraction(1, 3);
	}

	@Test
	public void testAddFractions() {
		Fraction addTest = fracOne.addFractions(fracTwo.getNumerator(), fracTwo.getDenominator());
		assertTrue("Error in common denominator", addTest.getDenominator() == 108);
		assertTrue("Error in addition of numerators", addTest.getNumerator() == 108);
	}
	
	@Test
	public void testAddFractions2() {
		Fraction addTest2 = fracOne.addFractions(fracTwo);
		assertTrue("Error in common denominator", addTest2.getDenominator() == 108);
		assertTrue("Error in addition of numerators", addTest2.getNumerator() == 108);
	}

	@Test
	public void testMultiplyFractions() {
		Fraction multiplyTest = fracOne.multiplyFractions(fracTwo.getNumerator(), fracTwo.getDenominator());
		assertTrue("Error in common denominator", multiplyTest.getDenominator() == 108);
		assertTrue("Error in multiplication of fractions", multiplyTest.getNumerator() == 24);
	}

	@Test
	public void testMultiplyFractions2() {
		Fraction multiplyTest2 = fracOne.multiplyFractions(fracTwo);
		assertTrue("Error in common denominator", multiplyTest2.getDenominator() == 108);
		assertTrue("Error in multiplication of fractions", multiplyTest2.getNumerator() == 24);
	}

	@Test
	public void testReciprocal() {
		Fraction recipTest = fracTwo.reciprocal();
		assertTrue("Error in reciprocal denominator", recipTest.getDenominator() == fracTwo.getNumerator());
		assertTrue("Error in reciprocal numerator", recipTest.getNumerator() == fracTwo.getDenominator());
	}

	@Test
	public void testSimplify() {
		Fraction simpTest1 = fracOne.simplify();
		Fraction addFrac = fracOne.addFractions(fracTwo.getNumerator(), fracTwo.getDenominator());
		Fraction simpTest2 = addFrac.simplify();
		assertTrue("AssertionError Comment", simpTest1.getNumerator() == 2);
		assertTrue("AssertionError Comment", simpTest1.getDenominator() == 3);
		assertTrue("AssertionError Comment", simpTest2.getNumerator() == 1);
		assertTrue("AssertionError Comment", simpTest2.getDenominator() == 1);
	}

}
