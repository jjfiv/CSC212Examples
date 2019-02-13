package edu.smith.cs.csc212.arrays;

public class Stats {
  public static double mean(double[] input) {
    // def mean(input):
    //   total = 0
    //   for x in input:
    //      total += x;
    //   return total / len(input)
    double total = 0.0;
    for (double x : input) {
      total += x;
    }
    return total / input.length;
  }
  public static double meanHarder(double[] input) {
    double total = 0.0;
    for (int i=0; i<input.length; i++) {
      total += input[i];
    }
    return total / input.length;
  }
  /**
   * Summarize what it does.
   * @param input Eplain each variable
   * @return what does it give you
   */
  public static double max(double[] input) {
    double biggestSoFar = 0;
    return biggestSoFar;
  }
  
  public static double min(double[] input) {
    // homework? Challenge on your own.
    return 0.0;
  }
  
  public static double standardDeviation(double[] input) {
    // I will start with this on Thursday (probably).
    // The notes have the Wikipedia formula and hints.
    return 0.0;
  }
  
  public static void main(String[] args) {
    double[] data = new double[] {1.0, 2.0, 3.0};
    System.out.println(mean(data));
    System.out.println(meanHarder(data));
  }
}
