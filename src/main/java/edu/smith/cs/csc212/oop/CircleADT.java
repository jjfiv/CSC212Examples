package edu.smith.cs.csc212.oop;

import java.awt.Graphics2D;
import java.util.Random;

public class CircleADT {
	private double diameter;
	
	public double getRadius() {
		return this.diameter / 2.0;
	}
	public void setRadius(double radius) {
		this.diameter = radius * 2.0;
	}
	public double getDiameter() {
		return this.diameter;
	}
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	
	public static double computeArea(CircleADT circle) {
		double radius = circle.getRadius();
		return Math.PI * radius * radius;
	}
	
	class Fish {
	    int x;
	    int y;
	    // A
	    public Fish(/* B */) {
	        Random rand = new Random();
	        this.x = rand.nextInt(Aquarium.WIDTH);
	        this.y = rand.nextInt(Aquarium.WIDTH);
	        // C
	    }
	    public void draw(Graphics2D g) {
	        // D
	    }
	}
	
	static class Aquarium {
		public static int WIDTH = 500;
		public static int HEIGHT = 500;
	}

}
