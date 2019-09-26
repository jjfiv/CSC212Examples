package edu.smith.cs.csc212.art;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;

public abstract class ArtShape {
  // Every ArtShape must have a shape.
  public Shape shape;
  // Every ArtShape has a random object, but only subclasses care.
  protected Random rand = ThreadLocalRandom.current();
  // Every ArtShape has a random color (but not even subclasses care!)
  private Color color = Color.getHSBColor(rand.nextFloat(), 0.8f, 0.8f);;
  
  // Every ArtShape has the same draw method!
  public void draw(Graphics2D g) {
	  g.setColor(this.color);
	  g.fill(this.shape);
  }
}
