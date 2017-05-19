package com.fpinjava.functions.exercise02_07;


public class FunctionExamples2 {
    static <A, B, C> Function<B, C> partialA(A a, Function<A, Function<B, C>> targetFunction) {
        return targetFunction.apply(a);
    }
}
