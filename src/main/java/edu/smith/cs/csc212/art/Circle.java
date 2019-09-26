package edu.smith.cs.csc212.art;

import java.awt.geom.Ellipse2D;

public class Circle extends ArtShape {
	public Circle() {
		int x = rand.nextInt(500);
		int y = rand.nextInt(500);
		int radius = 20 + rand.nextInt(50);
		this.shape = new Ellipse2D.Double(x - radius, y - radius, radius * 2, radius * 2);
	}
}
