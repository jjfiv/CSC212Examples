package edu.smith.cs.csc212.gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class RectangleExample extends GFX {

    @Override
    public void update(double dt) { }

    @Override
    public void draw(Graphics2D g) {
        int margin = 30;
        g.setColor(Color.blue);
        g.fillRect(margin, margin, getWidth()-(margin*2), getHeight() - (margin*2));
    }

    public static void main(String[] args) {
        RectangleExample gfx = new RectangleExample();
        gfx.start();
    }
}
