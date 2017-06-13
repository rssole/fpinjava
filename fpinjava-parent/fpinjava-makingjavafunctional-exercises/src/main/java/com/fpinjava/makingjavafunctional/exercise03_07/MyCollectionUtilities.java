package com.fpinjava.makingjavafunctional.exercise03_07;


import java.util.List;
import com.fpinjava.common.Function;

public class MyCollectionUtilities {
    public static <T, R> R foldRight(List<T> target, R init, Function<T, Function<R, R>> acc) {
        R result = init;

        for (int i = target.size() - 1; i >= 0; i--) {
            result = acc.apply(target.get(i)).apply(result);
        }
        return result;
    }
}
