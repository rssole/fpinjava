package com.fpinjava.functions.exercise02_05;

public interface Function<T, U> {

    U apply(T arg);

    default <V> Function<V, U> compose(Function<V, T> f) {
        return x -> apply(f.apply(x));
    }

    default <V> Function<T, V> andThen(Function<U, V> f) {
        return x -> f.apply(apply(x));
    }

    static <T, U, V> Function<Function<U, V>, Function<Function<T, U>, Function<T, V>>> higherCompose() {
        return f -> g -> x -> f.apply(g.apply(x));
    }

    static <T, U, V> Function<Function<V, T>, Function<Function<U, V>, Function<U, T>>> higherCompose2() {
        return f -> g -> x -> f.apply(g.apply(x));
    }

    // as one above was blind guessing... and after introducing non-ambiguous test ...
    // I needed to alter places of T U V as below, yielding actually order as in
    // correct solution in the book :)
    static <T, V, U> Function<Function<V, T>, Function<Function<U, V>, Function<U, T>>> higherCompose3() {
        return f -> g -> x -> f.apply(g.apply(x));
    }
}
