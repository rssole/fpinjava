package com.fpinjava.functions.exercise02_10;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FunctionExamplesTest {

  private Function<Tuple<Integer, Double>, Double> f;

  @Before
  public void setUp() throws Exception {
    f = x -> x._1 * (1 + x._2 / 100);
  }

  @Test
  public void testCurry() {
    Function<Integer, Function<Double, Double>> g = FunctionExamples.curry(f);

    assertCurryApplication(g);
  }

  @Test
  public void testCurryMine() {
    Function<Integer, Function<Double, Double>> g = FunctionExamples2.curryTuple(f);

    assertCurryApplication(g);
  }

  private void assertCurryApplication(Function<Integer, Function<Double, Double>> g) {
    assertEquals(f.apply(new Tuple<>(89, 7.0)), g.apply(89).apply(7.0));
    assertEquals(f.apply(new Tuple<>(27, 0.0)), g.apply(27).apply(0.0));
    assertEquals(f.apply(new Tuple<>(1623, 16.65)), g.apply(1623).apply(16.65));
  }
}
