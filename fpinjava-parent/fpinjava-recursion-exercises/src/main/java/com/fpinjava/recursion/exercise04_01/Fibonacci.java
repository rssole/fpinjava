package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib(int x) {
        return fib_(x, BigInteger.ZERO, BigInteger.ONE);
    }

    private static BigInteger fib_(int x, BigInteger prev, BigInteger curr) {
        if (x == 0) {
            return BigInteger.ZERO;
        } else if (x == 1) {
            return curr;
        } else {
            return fib_(x - 1, curr, prev.add(curr));
        }
    }
}
