package edu.smith.cs.csc212.art;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Circle extends Drawable {
  public static Color[] choices = new Color[] {
      Color.blue,
      Color.white,
      Color.red,
      Color.green
  };
  
  Color color;
  
  public Circle() {
    Random rand = new Random();
    int x = rand.nextInt(500);
    int y = rand.nextInt(500);
    int radius = 20 + rand.nextInt(50);
    this.color = choices[rand.nextInt(choices.length)];
    this.shape = new Ellipse2D.Double(x-radius, y-radius, radius*2, radius*2);
  }
  
  @Override
  public void draw(Graphics2D g) {
    g.setColor(this.color);    
    g.fill(this.shape);
  }
}
