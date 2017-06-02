package com.fpinjava.makingjavafunctional.exercise03_05;

import com.fpinjava.common.Function;

import java.util.List;

import static com.fpinjava.makingjavafunctional.exercise03_04.CollectionUtilities.head;
import static com.fpinjava.makingjavafunctional.exercise03_04.CollectionUtilities.tail;

public class Fold {

    public static Integer fold(List<Integer> is, Integer identity,
                               Function<Integer, Function<Integer, Integer>> f) {
        if (is.isEmpty()) {
            return identity;
        } else {
            return f.apply(head(is)).apply(fold(tail(is), identity, f));
        }
    }
}
