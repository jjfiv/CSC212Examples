package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;

import me.jjfoley.gfx.GFX;

public class SwimmingAquarium extends GFX {

	int fish1X = getWidth() + 100;
	int fish2X = -100;

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());

		// Draw the fish!
		AquariumCreatures.drawFishFacingLeft(g, Color.yellow, fish1X, 200);
		AquariumCreatures.drawFishFacingRight(g, Color.green, fish2X, 300);

		// What if we wanted this little fish to swim, too?
		AquariumCreatures.drawSmallFishFacingLeft(g, Color.red, 200, 100);

		
		// Move the fish!
		fish1X -= 1;
		fish2X += 2;
	}

	public static void main(String[] args) {
		boolean saveToFile = false;

		if (saveToFile) {
			// This command runs the simulation to a file.
			GFX forGIF = new SwimmingAquarium();
			forGIF.playToGIF(new File("aquarium.gif"), 700);
		} else {
			// This command runs the simulation interactively.
			GFX app = new SwimmingAquarium();
			app.start();
		}
	}

}
