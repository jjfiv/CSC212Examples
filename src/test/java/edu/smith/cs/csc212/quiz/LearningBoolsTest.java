package edu.smith.cs.csc212.quiz;

import org.junit.Test;

public class LearningBoolsTest {

  @Test
  public void test1() {
    boolean a = true;
    boolean b = false;

    if (a && !b) {
      System.out.println("1");
    } else {
      System.out.println("2");
    }
  }

  @Test
  public void test2() {
    boolean a = true;
    boolean b = false;

    if (a) {
      if (!b) {
        System.out.println("3");
        return;
      }
    }
    System.out.println("4");
  }

  @Test
  public void test3() {
    boolean a = true;
    boolean b = false;

    if (a || b) {
      System.out.println("5");
    } else {
      System.out.println("6");
    }
  }

  public void test3(int a) {
    if (a > 7) {
      if (a < 5) {
        System.out.println("The value is: " + a);
      }
    }
  }
  
  public void test4A(int[] items) {
    for (int k : items) {
      if (items.length > 3 && k > 50) {
        System.out.println(k);
      }
    }
  }
  
  
  public void test4B(int[] items) {
    for (int i = 3; i<items.length; i++) {
      if (items[i] > 50) {
        System.out.println(items[i]);
      }
    }
  }
  
  @Test
  public void runTest4() {
    test4A(new int[] {51,2,3,4});
    test4A(new int[] {51,2,3,4,55});
    test4B(new int[] {71,2,3,4});
    test4B(new int[] {71,2,3,4,75});
  }

}
