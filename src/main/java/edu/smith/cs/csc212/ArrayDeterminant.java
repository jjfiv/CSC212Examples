package edu.smith.cs.csc212;

public class ArrayDeterminant {

	public static double determinant(double a, double b, double c) {
		double bSquared = b * b;
		return bSquared - 4 * a * c;
	}
	
	// This is what the computer sees.
	public static double method0(double x1, double x2, double x3) {
		return x2 * x2 - 4.0 * x1 * x3;
	}
}
