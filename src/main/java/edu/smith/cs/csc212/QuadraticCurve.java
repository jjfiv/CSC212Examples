package edu.smith.cs.csc212;

/**
 * Represent a Quadratic Polynomial Curve in (ax^2 + bx + c) form.
 */
public class QuadraticCurve {
	public double a;
	public double b;
	public double c;

	/**
	 * We could use this method to plot our Quadratic Curve.
	 * 
	 * @param x the input.
	 * @return ax^2 + bx + c
	 */
	public double evaluate(double x) {
		return a * Math.pow(x, 2) + b * x + c;
	}

	/**
	 * Calculate the discriminant, which allows us to describe the roots of the
	 * quadratic polynomial.
	 * 
	 * @return b^2 - 4ac
	 */
	public double discriminant() {
		return b * b - 4 * a * c;
	}

	/**
	 * Because the quadratic formula has +/- in it, we have two methods for the two
	 * roots.
	 * 
	 * @return -b + sqrt(b^2 - 4ac) / 2a
	 */
	public double positiveRoot() {
		return (-b + Math.sqrt(discriminant())) / (2 * a);
	}

	/**
	 * Because the quadratic formula has +/- in it, we have two methods for the two
	 * roots.
	 * 
	 * @return -b - sqrt(b^2 - 4ac) / 2a
	 */
	public double negativeRoot() {
		return (-b - Math.sqrt(discriminant())) / (2 * a);
	}
}
