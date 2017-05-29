package com.fpinjava.makingjavafunctional.exercise03_02.mine;


import com.fpinjava.common.Tuple;
import com.fpinjava.makingjavafunctional.exercise03_01.Result;

import java.util.Arrays;
import java.util.function.Supplier;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>> {

    private Case(Supplier<Boolean> condition, Supplier<Result<T>> result) {
        super(condition, result);
    }

    static <T> Case<T> mcase(Supplier<Boolean> condition,
                             Supplier<Result<T>> value) {
        return new Case<>(condition, value);
    }
    static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
        return new DefaultCase<>(value);
    }

    @SafeVarargs
    static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
        return Arrays.stream(matchers)
                .filter(m -> m._1.get())
                .findFirst()
                .map(m -> m._2.get())
                .orElse(defaultCase._2.get());
    }

    static class DefaultCase<T> extends Case<T> {
        DefaultCase(Supplier<Result<T>> value) {
            super(() -> true, value);
        }
    }
}
