package edu.smith.cs.csc212.arrays;

import java.util.ArrayList;
import java.util.List;

public class Statistics {
  
  public static double max(List<Double> xs, double whenEmpty) {
    if (xs.isEmpty()) {
      return whenEmpty;
    }
    double maximum = xs.get(0);
    for (int i=1; i<xs.size(); i++) {
      double current = xs.get(i);
      if (current > maximum) {
        maximum = current;
      }
    }
    return maximum;
  }
  
  public static double min(List<Double> xs, double whenEmpty) {
    if (xs.isEmpty()) {
      return whenEmpty;
    }
    double minimum = xs.get(0);
    for (int i=1; i<xs.size(); i++) {
      double current = xs.get(i);
      if (current < minimum) {
        minimum = current;
      }
    }
    return minimum;
  }
  
  public static double mean(List<Double> xs) {
    double sum = 0.0;
    for (double x : xs) {
      sum += x;
    }
    return sum / xs.size();
  }
  
  public static double stddev(List<Double> xs) {
    
    // summation of (xi - mean(xs))**2
    double sum = 0.0;
    double xbar = mean(xs);
    for (double xi : xs) {
      double differenceFromMean = xi - xbar;
      sum += differenceFromMean * differenceFromMean;
    }
    return Math.sqrt(sum / (xs.size() - 1));
  }
  
  public static List<Double> makeNullsZero(List<Double> mixed) {
    List<Double> cleaned = new ArrayList<Double>();
    for (Double x : mixed) {
      if (x == null) {
        cleaned.add(0.0);
      } else {
        cleaned.add(x);
      }
    }
    return cleaned;
  }

  public static void main(String[] args) {
    List<Double> data = new ArrayList<Double>();
    data.add(10.0);
    data.add(20.0);
    data.add(30.0);
    data.add(40.0);
    data.add(50.0);
    System.out.println(max(makeNullsZero(data), 0.0));
    System.out.println(min(makeNullsZero(data), 0.0));
    System.out.println(mean(makeNullsZero(data)));
    System.out.println(stddev(makeNullsZero(data)));

  }

}
