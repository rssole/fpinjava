package com.fpinjava.functions.exercise02_11;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionExamplesTest {

  private Function<Integer, Function<Double, Double>> f;

  @Before
  public void setUp() throws Exception {
    f = a -> b -> a * (1 + b / 100);
  }

  @Test
  public void testReverseArgs() {
    Function<Double, Function<Integer, Double>> g = FunctionExamples.reverseArgs(f);
    assertArgumentSwapping(g);
  }

  @Test
  public void testReverseArgsMine() { // well, I chose different name :)
    Function<Double, Function<Integer, Double>> g = FunctionExamples2.swap(f);
    assertArgumentSwapping(g);
  }

  private void assertArgumentSwapping(Function<Double, Function<Integer, Double>> g) {
    assertEquals(f.apply(89).apply(7.0), g.apply(7.0).apply(89));
    assertEquals(f.apply(27).apply(0.0), g.apply(0.0).apply(27));
    assertEquals(f.apply(1623).apply(16.65), g.apply(16.65).apply(1623));
  }
}
