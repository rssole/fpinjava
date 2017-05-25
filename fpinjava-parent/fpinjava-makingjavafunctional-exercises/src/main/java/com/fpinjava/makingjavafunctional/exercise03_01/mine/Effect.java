package com.fpinjava.makingjavafunctional.exercise03_01.mine;

@FunctionalInterface
public interface Effect<T> {
    void invoke(T argument);
}
