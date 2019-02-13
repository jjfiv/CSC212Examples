package edu.smith.cs.csc212.gfx;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.jjfoley.gfx.GFX;

public class LoadImageExample extends GFX {
	BufferedImage dog;
	
	public LoadImageExample() throws IOException {
		dog = ImageIO.read(new File("buddy_wears_a_tie.jpg"));
	}

	@Override
	public void draw(Graphics2D g) {
		int centerX = (this.getWidth() - dog.getWidth()) / 2;
		g.drawImage(dog, centerX, 0, null);
	}
	
	public static void main(String[] args) throws IOException {
		LoadImageExample app = new LoadImageExample();
		app.start();
	}

}
