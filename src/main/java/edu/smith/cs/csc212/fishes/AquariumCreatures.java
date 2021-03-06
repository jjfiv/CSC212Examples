package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class AquariumCreatures {
	/**
	 * Kudos to Group 7, (Fall 2018).
	 * @param g The graphics object to draw with.
	 * @param bodyColor The color of the snail body.
	 * @param shellColor The color of the snail shell.
	 * @param eyeColor The color of the snail eye.
	 */
	public static void drawSnail(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor) {
		Shape body = new Rectangle2D.Double(0,0,40,50);
		Shape tentacleL = new Rectangle2D.Double(0,-20,5,20);
		Shape eyeWhiteL = new Ellipse2D.Double(-4, -28, 12, 12);
		Shape eyePupilL = new Ellipse2D.Double(-2, -26, 4, 4);
		
		g.setColor(bodyColor);
		g.fill(body);
		g.fill(tentacleL);
		g.setColor(Color.white);
		g.fill(eyeWhiteL);
		g.setColor(eyeColor);
		g.fill(eyePupilL);
		
		Shape tentacleR = new Rectangle2D.Double(35,-20,5,20);
		Shape eyeWhiteR = new Ellipse2D.Double(35-4, -28, 12, 12);
		Shape eyePupilR = new Ellipse2D.Double(35+2, -26+4, 4, 4);
		
		g.setColor(bodyColor);
		g.fill(tentacleR);
		g.setColor(Color.white);
		g.fill(eyeWhiteR);
		g.setColor(eyeColor);
		g.fill(eyePupilR);
		
		Shape shell3 = new Ellipse2D.Double(45, 20, 10, 10);
		Shape shell2 = new Ellipse2D.Double(35, 10, 30, 30);
		Shape shell1 = new Ellipse2D.Double(25, 0, 50, 50);
		
		g.setColor(shellColor);
		g.fill(shell1);
		g.setColor(Color.black);
		g.draw(shell1);
		g.setColor(shellColor);
		g.fill(shell2);
		g.setColor(Color.black);
		g.draw(shell2);
		g.setColor(shellColor);
		g.fill(shell3);
		g.setColor(Color.black);
		g.draw(shell3);
		
	}
	
	public static void drawSnailXY(Graphics2D g, Color bodyColor, Color shellColor, Color eyeColor, int x, int y) {
	  Graphics2D translated = (Graphics2D) g;
	  translated.translate(x, y);
	  drawSnail(translated, bodyColor, shellColor, eyeColor);
	  translated.dispose();
	}
	
	/**
	 * This code based on the Python fish in CSC111 labs, e.g.,
	 * https://jcrouser.github.io/CSC111/labs/lab-10-animation.html
	 * 
	 * @author jfoley
	 */
	public static void drawFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		// Draw the fish.
		g.setColor(color);
		
		Shape body = new Ellipse2D.Double(x-40, y-20, 80, 40);
		Shape tail = new Ellipse2D.Double(x+30, y-30, 20, 60);
		Shape eye = new Ellipse2D.Double(x-15, y-10, 10, 10);
		
		g.fill(body);
		
		// draw body outline.
		g.setColor(Color.black);
		g.draw(body);
		
		// draw eye (still black):
		g.fill(eye);
		
		// draw tail:
		Color tailColor = color.darker();
		g.setColor(tailColor);
		g.fill(tail);
		
		// draw tail outline.
		g.setColor(Color.black);
		g.draw(tail);
	}
	/**
	 * This method is implemented by creating a new Graphics "world" located at x,y
	 * that is scaled in a "backwards" X world.
	 * 
	 * @param g the original graphics world.
	 * @param color the color of the fish!
	 * @param x the x-coordinate of the position to draw the fish.
	 * @param y the y-coordinate of the position to draw the fish.
	 */
	public static void drawFishFacingRight(Graphics2D g, Color color, int x, int y) {
		Graphics2D flipped = (Graphics2D) g.create();
		flipped.translate(x, y);
		flipped.scale(-1, 1);
		drawFishFacingLeft(flipped, color, 0, 0);
		flipped.dispose();
	}

	/**
	 * This method is implemented by creating a new Graphics "world" located at x,y
	 * that is half the size of a regular one and calling our regular Fish method.
	 * 
	 * @param g the original graphics world.
	 * @param color the color of the fish!
	 * @param x the x-coordinate of the position to draw the fish.
	 * @param y the y-coordinate of the position to draw the fish.
	 */
	public static void drawSmallFishFacingLeft(Graphics2D g, Color color, int x, int y) {
		Graphics2D halfSize = (Graphics2D) g.create();
		halfSize.translate(x, y);
		halfSize.scale(0.5, 0.5);
		drawFishFacingLeft(halfSize, color, 0, 0);
		halfSize.dispose();
	}
}
