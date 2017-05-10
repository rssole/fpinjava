package com.fpinjava.functions.exercise02_06;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFunctionTest {
    @Test
    public void testHigherAndThen() {

        Function<Double, Integer> f = a -> (int) (a * 3);
        Function<Integer, Double> g = a -> a + 2.0;

        assertEquals(Integer.valueOf(9), g.andThen(f).apply(1));
        assertEquals(Integer.valueOf(9), Function.<Integer, Double, Integer>higherAndThen().apply(g).apply(f).apply(1));
    }
}
