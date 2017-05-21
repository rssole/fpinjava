package com.fpinjava.functions.exercise02_10;


public class FunctionExamples2 {
    public static <A, B, C> Function<A, Function<B, C>> curryTuple(Function<Tuple<A, B>, C> f) {
        return a -> b -> f.apply(new Tuple<>(a, b));
    }
}
