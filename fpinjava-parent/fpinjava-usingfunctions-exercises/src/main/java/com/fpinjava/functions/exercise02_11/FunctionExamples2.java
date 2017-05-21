package com.fpinjava.functions.exercise02_11;


public class FunctionExamples2 {
    public static <A, B, C> Function<B, Function<A, C>> swap(Function<A, Function<B, C>> f) {
        return b -> a -> f.apply(a).apply(b);
    }
}
