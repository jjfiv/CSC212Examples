package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class StaticAquarium extends GFX {

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);;
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Draw the fish!
		AquariumCreatures.drawFishFacingLeft(g, Color.yellow, 100, 200);
		AquariumCreatures.drawFishFacingLeft(g, Color.green, 300, 300);
	}

	public static void main(String[] args) {
		StaticAquarium app = new StaticAquarium();
		app.start();
	}
}
