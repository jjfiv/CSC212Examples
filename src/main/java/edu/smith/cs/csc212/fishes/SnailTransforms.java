package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class SnailTransforms extends GFX {

	@Override
	public void draw(Graphics2D g) {
		// By making a new Graphics2D object, we can move everything that gets drawn to it.
		Graphics2D onBottom = (Graphics2D) g.create();
		onBottom.translate(100, getHeight()-51);
		AquariumCreatures.drawSnail(onBottom, Color.red, Color.white, Color.black);
		// It's OK if you forget this, Java will eventually notice, but better to have it!
		onBottom.dispose();
		
		// On bottom and backwards:
		Graphics2D onBottom2 = (Graphics2D) g.create();
		onBottom2.translate(300, getHeight()-51);
		onBottom2.scale(-1, 1);
		AquariumCreatures.drawSnail(onBottom2, Color.red, Color.white, Color.black);
		// It's OK if you forget this, Java will eventually notice, but better to have it!
		onBottom2.dispose();
		
		Graphics2D onRight = (Graphics2D) g.create();
		onRight.translate(getWidth()-51, 200);
		// Oh no, radians.
		onRight.rotate(-Math.PI/2);
		AquariumCreatures.drawSnail(onRight, Color.red, Color.white, Color.black);
		onRight.dispose();
		
		Graphics2D onLeft= (Graphics2D) g.create();
		onLeft.translate(+51, 200);
		// Oh, cool, we can use degrees if we want:
		onLeft.rotate(Math.toRadians(90));
		AquariumCreatures.drawSnail(onLeft, Color.red, Color.white, Color.black);
		onLeft.dispose();
	}
	
	public static void main(String[] args) {
		SnailTransforms gfx = new SnailTransforms();
		gfx.start();
	}

	
}
