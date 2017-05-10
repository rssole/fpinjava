package com.fpinjava.functions.exercise02_05;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyFunctionTest {
    @Test
    public void testHigherCompose() {

        Function<Double, Integer> f = a -> (int) (a * 3);
        Function<Integer, Double> g = a -> a + 2.0;

        assertEquals(Integer.valueOf(9), f.compose(g).apply(1));
        assertEquals(Integer.valueOf(9), Function.<Integer, Double, Integer>higherCompose3().apply(f).apply(g).apply(1));
    }
}
