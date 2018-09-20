package edu.smith.cs.csc212.art;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;

public class RoundedRectangle extends Drawable {
  private Color color;
  
  public RoundedRectangle() {
    Random rand = new Random();
    this.color = Circle.choices[rand.nextInt(Circle.choices.length)].darker();
    this.shape = new RoundRectangle2D.Double(rand.nextInt(500), rand.nextInt(500), 
        20 + rand.nextInt(50), 
        20 + rand.nextInt(50),
        5, 5);
  }
  
  public void draw(Graphics2D g) {
    g.setColor(this.color);
    g.fill(this.shape);
  }
}
