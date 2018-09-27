package edu.smith.cs.csc212.assoc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import me.jjfoley.gfx.GFX;

/**
 * Color names in colors.csv taken from 
 * <a href="https://www.w3schools.com/colors/colors_names.asp">W3 Schools</a>
 * @author jfoley
 *
 */
public class HTMLColors extends GFX {  
  String colorName = "";
  
  public HTMLColors() {
    
    
    // fp = open('src/main/resources/colors.csv'):
    //   for line in fp:
    //      print(line)
    // fp.close()
    
    File path = new File("src/main/resources/colors.csv");
    System.out.println("Colors.csv exists?: " + path.exists());
    
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      
      String line;
      while(true) {
        line = reader.readLine();
        if (line == null) {
          break;
        }
        String[] pieces = line.split(",");
        // python: pieces[1][1:]
        int colorNumber = Integer.parseInt(pieces[1].substring(1), 16);
        this.COLORS.put(pieces[0], new Color(colorNumber));
        
        System.out.println(pieces[0]+" value='"+colorNumber+"'");
      }
    } catch (FileNotFoundException e) {
      System.err.println("Couldn't find HTML Colors CSV.");
      System.exit(-1);
    } catch (IOException e) {
      System.err.println("Couldn't read HTML Colors CSV.");
      System.exit(-1);
    }
    
    
    this.colorName = 
          JOptionPane
          .showInputDialog("What color should we use?");
  }
  class Fish implements Comparable<Fish> {
    String name;
    int x;
    int y;
    
    public boolean equals(Object other) {
      if (other instanceof Fish) {
        Fish otherFish = (Fish) other;
        return name.equals(otherFish.name) && x == otherFish.x && y == otherFish.y;
      }
      return false;
    }
    public int hashCode() {
      return Objects.hash(name, x, y);
    }
    @Override
    public int compareTo(Fish other) {
      int where = name.compareTo(other.name);
      if (where == 0) {
        where = Integer.compare(x, other.x);
        if (where == 0) {
          where = Integer.compare(y, other.y);
        }
      }
      return where;
    }
  };
  public Map<String, Color> COLORS = new TreeMap<>();
  //COLORS = {'AliceBlue': 0xf0f8ff, .}
  
  public Color fromName(String name) {
    Color maybeFromTable = this.COLORS.get(name);
    if (maybeFromTable != null) {
      return maybeFromTable;
    }
    return Color.red;
  }
  
  public Color favoriteColors(int number) {
    switch(number) {
    case 1:
      return Color.green;
    case 2:
      return COLORS.get("Teal");
    case 3:
      return COLORS.get("SpringGreen");
    default:
      return Color.green.darker();
    }
//    if (number == 1) {
//      return Color.green;
//    } else if (number == 2) {
//      return COLORS.get("Teal");
//    } else if (number == 3) {
//      return COLORS.get("SpringGreen");
//    }
    //return Color.green.darker();
  }

  public static void main(String[] args) {
    HTMLColors app = new HTMLColors();
    app.start();
  }

  @Override
  public void draw(Graphics2D g) {
    if (this.processKey(KeyEvent.VK_SPACE)) {
      this.colorName = 
          JOptionPane
          .showInputDialog("What color should we use?");
    }
    
    g.setColor(fromName(this.colorName));
    g.fillRect(0, 0, getWidth(), getHeight());    
  }

}
