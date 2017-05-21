package com.fpinjava.functions.exercise02_12;


public class FunctionExamples2 {
    public static Function<Integer, Integer> factorialMine = new Function<Integer, Integer>() {
        @Override
        public Integer apply(Integer arg) {
            return arg == 0 ? 1 : arg * apply(--arg);
        }
    };
}
