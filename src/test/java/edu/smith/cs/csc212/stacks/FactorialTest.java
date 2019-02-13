package edu.smith.cs.csc212.stacks;

import org.junit.Test;
import org.junit.Assert;

public class FactorialTest {

  @Test
  public void testStack() {
    Assert.assertEquals(1, Factorial.withExplicitStack(1));
    Assert.assertEquals(2, Factorial.withExplicitStack(2));
    Assert.assertEquals(6, Factorial.withExplicitStack(3));
    Assert.assertEquals(24, Factorial.withExplicitStack(4));
  }
}
