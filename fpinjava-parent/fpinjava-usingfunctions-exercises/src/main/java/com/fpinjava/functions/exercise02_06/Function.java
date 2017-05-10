package com.fpinjava.functions.exercise02_06;


public interface Function<T, U> {

  U apply(T arg);

  default <V> Function<T, V> andThen(Function<U, V> f) {
    return x -> f.apply(apply(x));
  }

  static <T, U, V> Function<Function<T, U>, Function<Function<U, V>, Function<T, V>>> higherAndThen() {
    return f -> g -> x -> g.apply(f.apply(x));
  }
}
