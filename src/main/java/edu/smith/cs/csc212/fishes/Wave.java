package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class Wave {
  int x;
  int y;
  int wiggle;
  Random rand = new Random();

  public Wave() {
    this.x = rand.nextInt(500);
    this.y = rand.nextInt(500);
    this.wiggle = 0;
  }
  
  public void draw(Graphics2D win) {
    Font f = win.getFont();
    win.setFont(f.deriveFont(40.23f));
    win.setColor(Color.white);
    win.drawString("~", this.x, this.y + this.wiggle);
    
    animate();
  }
  
  public void animate() {
    this.x -= 6;
    if (this.x < -150) {
      // off the screen
      this.x = 550;
      this.y = rand.nextInt(500);
    }
    // (int) tells Java that we don't care about the fraction we're losing.
    this.wiggle = (int) (30.0 * Math.sin(this.x / 60.0));
  }
}
