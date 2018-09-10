package edu.smith.cs.csc212;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;

public class ChessBoard extends GFX {

	@Override
	public void draw(Graphics2D g) {
		int size = 50;
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				int cell = y + x;
				if (cell % 2 == 0) {
					g.setColor(Color.white);
				} else {
					g.setColor(Color.red);
				}
				g.fillRect(x*size, y*size, size, size);
			}
		}
	}

	public static void main(String[] args) {
		GFX app = new ChessBoard();
		app.start();
	}
}
