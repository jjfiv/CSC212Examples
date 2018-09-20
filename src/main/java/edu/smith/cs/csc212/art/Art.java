package edu.smith.cs.csc212.art;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import me.jjfoley.gfx.GFX;
import me.jjfoley.gfx.IntPoint;

public class Art extends GFX {
  List<Drawable> theDrawableList = new LinkedList<>();
  
  public Art() {
    for (int i=0; i<1; i++) {
      Circle each = new Circle();
      theDrawableList.add(each);
    }
  }
  
  public static void main(String[] args) {
    Art app = new Art();
    app.start();
  }
  
  public class ObjectWrappersForPrimitives {
    Integer x = (int) 7;
    Double y = (double) 3.5;
    Boolean b = (boolean) true;
    Float f = (float) 3.5f;
    Character c = (char) 'z';
  }

  @Override
  public void draw(Graphics2D g) {
    if (this.processKey(KeyEvent.VK_C)) {
      theDrawableList.add(new Circle());
    }
    if (this.processKey(KeyEvent.VK_R)) {
      theDrawableList.add(new RoundedRectangle());
    }
    
    IntPoint click = this.processClick();
    if (click != null) {
      List<Drawable> deleteMe = new ArrayList<>();
      //int deleteMe = -1;
      for (int i=0; i<this.theDrawableList.size(); i++) {
        Drawable c = this.theDrawableList.get(i);
        if (c.shape.contains(click)) {
          deleteMe.add(c);
          System.out.println("ShouldDelete: "+i);
        }
      }
      for (Drawable overlap : deleteMe) {
        this.theDrawableList.remove(overlap);
      }
      
      System.out.println(click.x + "," + click.y);
    }
    
    for (Drawable r : this.theDrawableList) {
      r.draw(g);
    }
  }

}
