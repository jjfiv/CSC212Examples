package edu.smith.cs.csc212.art;

import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class RoundedRectangle extends ArtShape {
	private static final int CORNER_RADIUS = 5;

	public RoundedRectangle() {
		Random rand = new Random();
		int x = rand.nextInt(500);
		int y = rand.nextInt(500);
		int w = 20 + rand.nextInt(50);
		int h = 20 + rand.nextInt(50);
		this.shape = new RoundRectangle2D.Double(x, y, w, h, CORNER_RADIUS, CORNER_RADIUS);
	}
}
