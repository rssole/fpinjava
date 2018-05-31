package com.fpinjava.recursion.exercise04_09;

import com.fpinjava.common.TailCall;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.fpinjava.common.CollectionUtilities.head;
import static com.fpinjava.common.CollectionUtilities.tail;
import static com.fpinjava.common.TailCall.ret;
import static com.fpinjava.common.TailCall.sus;


public class Memoization {

    // My solution does not work for 0!
    public static String fibo(int number) {
        return makeString(fib_(number, BigInteger.ZERO, BigInteger.ONE, new ArrayList<>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE))).eval(), ", ");
    }

    private static TailCall<List<BigInteger>> fib_(int x, BigInteger prev, BigInteger curr, List<BigInteger> acc) {
        if (x == 0) {
            return ret(Collections.singletonList(BigInteger.ZERO));
        } else if (x == 1) {
            return ret(acc);
        } else {
            return sus(() -> {
                final BigInteger next = prev.add(curr);
                acc.add(next);
                return fib_(x - 1, curr, next, acc);
            });
        }
    }

    public static <T> String makeString(List<T> list, String separator) {
        return _makeString(list, separator, new StringBuilder()).eval();
    }

    private static <T> TailCall<String> _makeString(List<T> list, String separator, StringBuilder acc) {
        if (list.isEmpty()) {
            return ret(acc.delete(acc.length() - 2, acc.length()).toString());
        } else {
            return sus(() -> _makeString(tail(list), separator, acc.append(head(list)).append(separator)));
        }
    }
}
