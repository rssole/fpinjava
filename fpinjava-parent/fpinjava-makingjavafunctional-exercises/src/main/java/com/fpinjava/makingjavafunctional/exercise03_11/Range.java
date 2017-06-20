package com.fpinjava.makingjavafunctional.exercise03_11;

import java.util.List;

import static com.fpinjava.makingjavafunctional.exercise03_10.CollectionUtilities.append;
import static com.fpinjava.makingjavafunctional.exercise03_10.CollectionUtilities.list;


public class Range {

    public static List<Integer> range(int start, int end) {
        int current = start;
        List<Integer> result = list();
        while (current < end) {
            result = append(result, current);
            current = current + 1;
        }
        return result;
    }
}
