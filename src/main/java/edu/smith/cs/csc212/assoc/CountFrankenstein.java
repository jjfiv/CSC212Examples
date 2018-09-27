package edu.smith.cs.csc212.assoc;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFrankenstein {

  public static void main(String[] args) {
    File path = new File("src/main/resources/Frankenstein.txt");
    System.out.println("frankenstein exists?: " + path.exists());
    
    Map<String, Integer> counts = new HashMap<String, Integer>();
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path));
      
      String line;
      while(true) {
        line = reader.readLine();
        if (line == null) {
          break;
        }
        
        String[] words = line.toLowerCase().split(" ");
        
        for (String w : words) {
          if (counts.containsKey(w)) {
            int before = counts.get(w);
            counts.put(w, before + 1);
          } else {
            counts.put(w, 1);
          }
        }
        
      }
    } catch (FileNotFoundException e) {
      System.err.println("Couldn't find frankenstein.");
      System.exit(-1);
    } catch (IOException e) {
      System.err.println("Couldn't read frankenstein.");
      System.exit(-1);
    }
    
    System.out.println(counts.size());
    //for (w,c) in counts.items()
    List<WordCount> best = new ArrayList<WordCount>();
    for (Map.Entry<String, Integer> entry : counts.entrySet()) {
      best.add(new WordCount(entry.getKey(), entry.getValue()));
    }
    Collections.sort(best);
    Collections.reverse(best);
    for (int i=0; i<200; i++) {
      System.out.println(best.get(i));
    }
  }
  
  // Created this so that I can sort it.
  static class WordCount implements Comparable<WordCount> {
    String word;
    int count;
    public WordCount(String w, int c) {
      this.count = c;
      this.word = w;
    }
    
    public int compareTo(WordCount o) {
      return Integer.compare(count, o.count);
    }
    
    public String toString() {
      return this.word +":"+ this.count;
    }
  }
  


}
