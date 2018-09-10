package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * This code based on the Python fish in CSC111 labs, e.g.,
 * https://jcrouser.github.io/CSC111/labs/lab-10-animation.html
 * 
 * @author jfoley
 */
public class AquariumCreatures {
	public static void drawFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		// Draw the fish.
		g.setColor(color);
		g.fillOval(x-40, y-20, 80, 40);
		
		// draw body outline.
		g.setColor(Color.black);
		g.drawOval(x-40, y-20, 80, 40);
		
		// draw eye (still black):
		g.fillOval(x-15, y-10, 10, 10);
		
		// draw tail:
		Color tailColor = color.darker();
		g.setColor(tailColor);
		g.fillOval(x+30, y-30, 20, 60);
		
		// draw tail outline.
		g.setColor(Color.black);
		g.drawOval(x+30, y-30, 20, 60);
	}
	
	public static void drawSmallFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		// Draw the fish.
		g.setColor(color);
		g.fillOval(x-20, y-10, 40, 20);
		
		// draw body outline.
		g.setColor(Color.black);
		g.drawOval(x-20, y-10, 40, 20);
		
		// draw eye (still black):
		g.fillOval(x-7, y-5, 5, 5);
		
		// draw tail:
		Color tailColor = color.darker();
		g.setColor(tailColor);
		g.fillOval(x+15, y-15, 10, 30);
		
		// draw tail outline:
		g.setColor(Color.black);
		g.drawOval(x+15, y-15, 10, 30);
	}
}
