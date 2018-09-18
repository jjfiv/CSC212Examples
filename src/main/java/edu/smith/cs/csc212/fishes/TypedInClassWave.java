package edu.smith.cs.csc212.fishes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Random;

public class TypedInClassWave {
	int x;
	int y; // where on the screen to wave
	double sinY = 0; // what part of the wave are we on?
	public TypedInClassWave() {
		Random rand = new Random();
		this.x = rand.nextInt(500);
		this.y = rand.nextInt(500);
	}
	public void draw(Graphics2D win) {
		move();
		
		int pixelY = (int) (this.y + this.sinY);
		
		Font font = win.getFont();
		win.setFont(font.deriveFont(44.35f));
		win.setColor(Color.WHITE);
		win.drawString("~", this.x, pixelY);
	}
	private void move() {
		this.x -= 5;
		if (this.x < 500 - 10) {
			this.x = 500 + 10;
		}
		double A = 30.0;
		double w = 100.0;
		this.sinY = A * Math.sin(x / w);
	}
}
