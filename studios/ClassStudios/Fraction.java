package ClassStudios;

/**
 * A class intended to represent a fraction by its numerator and denominator.
 * Can add and multiply itself to another fraction. Can provide its reciprocal.
 * Can simplify itself.
 * @author sexybeast
 *
 */
public class Fraction {
	
	//Fields
	private int numerator;
	private int denominator;
	
	//Methods
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	/**
	 * Adds itself to a second fraction.
	 * @param numerator - Numerator of second fraction to be added.
	 * @param denominator - Denominator of second fraction to be added.
	 * @return - The sum as a new Fraction object.
	 */
	public Fraction addFractions(int numerator, int denominator) {
		int commonDenominator = (this.denominator * denominator);
		
		int firstNumerator = (this.numerator * denominator);
		int secondNumerator = (numerator * this.denominator);
		
		int newNumerator = (firstNumerator + secondNumerator);
		
		Fraction sum = new Fraction(newNumerator, commonDenominator);
		return sum;
	}
	/**
	 * Adds itself to a second fraction.
	 * @param otherFraction - Fraction object to be added
	 * @return - The sum as a new Fraction object.
	 */
	public Fraction addFractions(Fraction otherFraction) {
		int commonDenominator = (this.denominator * otherFraction.denominator);
		
		int firstNumerator = (this.numerator * otherFraction.denominator);
		int secondNumerator = (otherFraction.numerator * this.denominator);
		
		int newNumerator = (firstNumerator + secondNumerator);
		
		Fraction sum = new Fraction(newNumerator, commonDenominator);
		return sum;
	}
	
	/**
	 * Multiplies itself to a second fraction.
	 * @param numerator - Numerator of second fraction to be multiplied.
	 * @param denominator - Denominator of second fraction to be multiplied.
	 * @return - The product as a new Fraction object.
	 */
	public Fraction multiplyFractions(int numerator, int denominator) {
		int newNumerator = (this.numerator * numerator);
		int newDenominator = (this.denominator * denominator);
		
		Fraction product = new Fraction(newNumerator, newDenominator);
		return product;
	}

	/**
	 * Multiplies itself to a second fraction.
	 * @param otherFraction - Fraction object to be multiplied.
	 * @return
	 */
	public Fraction multiplyFractions(Fraction otherFraction) {
		int newNumerator = (this.numerator * otherFraction.numerator);
		int newDenominator = (this.denominator * otherFraction.denominator);
		
		Fraction product = new Fraction(newNumerator, newDenominator);
		return product;
	}

	/**
	 * Provides the reciprocal of itself.
	 * @return - The reciprocal as a new Fraction object.
	 */
	public Fraction reciprocal() {
		Fraction reciprocal = new Fraction(this.denominator, this.numerator);
		return reciprocal;
	}
	
	private int greatestCommonDivisor (int n, int d) {
		int gcd = 1;
		
		for (int x = this.numerator; x > 0; x--) {
			if (this.numerator % x == 0) {
				if (this.denominator % x == 0) {
					gcd = x;
					x = 0;
				}
			}
		}
		
		return gcd;
	}
	
	/**
	 * Provides a simplification of itself.
	 * @return - The simplified fraction as a new Fraction object.
	 */
	public Fraction simplify() {
		int gcd = greatestCommonDivisor(this.numerator, this.denominator);
		
		int newNumerator = this.numerator/gcd;
		int newDenominator = this.denominator/gcd;
		
		Fraction simplification = new Fraction(newNumerator, newDenominator);
		return simplification;
	}
	
	public String toString() {
		return "Numerator: " + this.numerator + ", Denominator: " + this.denominator + ".";
	}
	
	//Instance
	public static void main(String[] args) {
		Fraction robert = new Fraction(7, 7);
		System.out.println("Robert toString: " + robert);
		
		Fraction liz = new Fraction(3, 20);
		System.out.println("Liz toString: " + liz);
		
		Fraction robertLizProduct = robert.multiplyFractions(liz.numerator, liz.denominator);
		System.out.println("robertLizProduct toString: " + robertLizProduct);
		
		Fraction robertLizSum = robert.addFractions(liz.numerator, liz.denominator);
		System.out.println("robertLizSum toString: " + robertLizSum);
		
		System.out.println("robertLizProduct simplify: " + robertLizProduct.simplify());
		System.out.println("robertLizSum simplify: " + robertLizSum.simplify());
		
		Fraction simple = new Fraction(5, 15);
		System.out.println("simple Fraction (5/15) simplify: " + simple.simplify());
	}
}
