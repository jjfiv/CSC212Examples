package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class WavePool extends GFX {
  
  Wave crush = new Wave();
  Wave[] waves = new Wave[10];
  
  public WavePool() {
    for (int i=0; i<waves.length; i++) {
      waves[i] = new Wave();
    }
  }
  
  @Override
  public void draw(Graphics2D g) {
    // This is the ocean.
    g.setColor(Color.blue);
    g.fillRect(0, 0, getWidth(), getHeight());
    // Draw our wave.
    crush.draw(g);
    
    // for w in waves:
    for (Wave w : this.waves) {
      w.draw(g);
    }
  }
  
  public static void main(String[] args) {
    WavePool app = new WavePool();
    app.start();
  }

}
