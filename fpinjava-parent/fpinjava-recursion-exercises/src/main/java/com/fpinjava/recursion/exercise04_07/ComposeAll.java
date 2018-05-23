package com.fpinjava.recursion.exercise04_07;

import com.fpinjava.common.Function;
import com.fpinjava.common.TailCall;

import java.util.List;

import static com.fpinjava.common.CollectionUtilities.*;
import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;

public class ComposeAll {

    public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
//         below is as per my complete misunderstanding of the exercise
//         I thought composition itself should be made tail recursive and not composition application
//        return composeAll_(list, Function.identity()).eval();
        return arg -> {
            T x = arg;
            for (Function<T, T> ttFunction : list) {
                x = ttFunction.apply(x);
            }
            return x;
        };

    }

    private static <T> TailCall<Function<T, T>> composeAll_(List<Function<T, T>> list, Function<T, T> acc) {
        if (list.isEmpty()) {
            return ret(acc);
        } else {
            return sus(() -> composeAll_(tail(list), acc.compose(head(list))));
        }
    }

    public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
        return x -> foldLeft(list, x, a -> b -> b.apply(a));
    }

    public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
        return x -> foldRight(list, x, b -> b);
    }
}
