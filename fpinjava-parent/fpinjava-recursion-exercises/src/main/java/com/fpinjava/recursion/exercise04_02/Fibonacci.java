package com.fpinjava.recursion.exercise04_02;

import com.fpinjava.recursion.listing04_03.TailCall;

import java.math.BigInteger;

import static com.fpinjava.recursion.listing04_03.TailCall.ret;
import static com.fpinjava.recursion.listing04_03.TailCall.sus;


public class Fibonacci {

  public static BigInteger fib(int x) {
    return fib_(x, BigInteger.ZERO, BigInteger.ONE).eval();
  }

  private static TailCall<BigInteger> fib_(int x, BigInteger prev, BigInteger curr) {
    if (x == 0) {
      return ret(BigInteger.ZERO);
    } else if (x == 1) {
      return ret(curr);
    } else {
      return sus(() -> fib_(x -1, curr, prev.add(curr)));
    }
  }
}
