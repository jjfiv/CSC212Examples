package edu.smith.cs.csc212;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class MyDrawing extends GFX{
	@Override
	public void draw(Graphics2D g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, 200, 200);
	}

	public static void main(String[] args) {
		MyDrawing app = new MyDrawing();
		app.start();
	}
}
