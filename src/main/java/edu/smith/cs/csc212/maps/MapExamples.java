package edu.smith.cs.csc212.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExamples {
  
  public static void main(String[] args) {
    Map<String, Integer> counts = new HashMap<>();
    String[] data = {"a", "b", "a", "a", "b", "c", "d"};
    for (String item : data) {
      int before = counts.getOrDefault(item, 0);
      counts.put(item, before + 1);
    }
    System.out.println(counts);



  }
}
