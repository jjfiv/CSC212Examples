package edu.smith.cs.csc212.gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.IntPoint;
import me.jjfoley.gfx.TextBox;

public class MoveYourMouse extends GFX {
	TextBox message;

	public MoveYourMouse() {
		message = new TextBox("Move your mouse!");
		message.color = Color.white;
		message.centerInside(windowAsRectangle());
	}

	@Override
	public void draw(Graphics2D g) {
		message.draw(g);

		IntPoint mouse = this.getMouseLocation();
		if (mouse != null) {
			g.setColor(Color.red);
			g.fillRect(mouse.x, mouse.y, 20, 20);
		}
	}

	public static void main(String[] args) {
		MoveYourMouse app = new MoveYourMouse();
		app.start();
	}
}
