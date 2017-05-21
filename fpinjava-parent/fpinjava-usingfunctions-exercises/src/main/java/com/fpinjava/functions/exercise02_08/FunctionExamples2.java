package com.fpinjava.functions.exercise02_08;


public class FunctionExamples2 {
    public static <A, B, C> Function<A, C> partialB(B b, Function<A, Function<B, C>> targetFunction) {
        return a -> targetFunction.apply(a).apply(b);
    }
}
