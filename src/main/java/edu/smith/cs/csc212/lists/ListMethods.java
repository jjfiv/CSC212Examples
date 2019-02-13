package edu.smith.cs.csc212.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListMethods {
  public static void main(String[] args) {
    List<String> items = new ArrayList<>();
    
    items.add("A");
    items.add("B");
    items.add("C");
    System.out.println(items);
    System.out.println(items.size());

    items.add(0, "Z");
    System.out.println(items);

    items.remove(1);
    System.out.println(items);
    
    items.remove("Z");
    System.out.println(items);
    
    Random rand = new Random();
    items.get(rand.nextInt(items.size()));
    items.add(0, "A");
    items.get(2);
    items.add("D");
    items.add("E");
    
    System.out.println(items);
    Collections.shuffle(items);
    System.out.println(items);
    System.out.println("E@"+items.indexOf("E"));
    
    System.out.println(items.contains("E"));
  }
}
