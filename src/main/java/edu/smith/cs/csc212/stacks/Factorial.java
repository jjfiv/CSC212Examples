package edu.smith.cs.csc212.stacks;

import java.util.LinkedList;

public class Factorial {
  public static int withExplicitStack(int n) {
    LinkedList<Integer> values = new LinkedList<>();
    values.push(1);
    while(n > 1) {
      values.push(n--);
    }
    int result = values.pop();
    while(!values.isEmpty()) {
      result *= values.pop();
    }
    return result;
  }
}
