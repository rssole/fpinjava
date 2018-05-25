package com.fpinjava.recursion.exercise04_06;

import com.fpinjava.common.Function;

import java.util.List;

import static com.fpinjava.common.CollectionUtilities.foldLeft;


public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return foldLeft(list, Function.identity(), f -> f::compose);
  }
}
