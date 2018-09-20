package edu.smith.cs.csc212.art;

import java.awt.Graphics2D;
import java.awt.Shape;

public abstract class Drawable {
  Shape shape;
  public abstract void draw(Graphics2D g);
}
