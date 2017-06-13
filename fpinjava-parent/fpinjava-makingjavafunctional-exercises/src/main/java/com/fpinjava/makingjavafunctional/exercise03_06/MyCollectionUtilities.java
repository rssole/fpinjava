package com.fpinjava.makingjavafunctional.exercise03_06;


import java.util.List;
import com.fpinjava.common.Function;

public class MyCollectionUtilities {

    public static <T, R> R foldLeft(List<T> target, R init, Function<R, Function<T, R>>  accu) {
        R result = init;
        for (T t : target) {
            result = accu.apply(result).apply(t);
        }
        return result;
    }
}
