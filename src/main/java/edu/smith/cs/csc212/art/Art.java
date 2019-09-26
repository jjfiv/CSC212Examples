package edu.smith.cs.csc212.art;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.IntPoint;

public class Art extends GFX {
	List<ArtShape> theDrawableList = new ArrayList<>();

	public static void main(String[] args) {
		Art app = new Art();
		app.start();
	}

	@Override
	public void draw(Graphics2D g) {
		if (this.processKey(KeyEvent.VK_C)) {
			theDrawableList.add(new Circle());
		}
		if (this.processKey(KeyEvent.VK_R)) {
			theDrawableList.add(new RoundedRectangle());
		}

		for (ArtShape sh : this.theDrawableList) {
			sh.draw(g);
		}
		
		deleteClickedShape();
	}
	
	// ... more ...

	public void deleteClickedShape() {
		IntPoint click = this.processClick();
		if (click != null) {
			List<ArtShape> keep = new ArrayList<>();
			for (ArtShape sh : this.theDrawableList) {
				if (!sh.shape.contains(click)) {
					keep.add(sh);
				}
			}
			this.theDrawableList = keep;
		}
	}

}
