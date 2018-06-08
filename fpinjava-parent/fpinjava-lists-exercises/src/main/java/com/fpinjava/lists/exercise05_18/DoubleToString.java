package com.fpinjava.lists.exercise05_18;

import com.fpinjava.lists.exercise05_16.List;

import static com.fpinjava.lists.exercise05_16.List.list;

public class DoubleToString {

  public static List<String> doubleToString(List<Double> list) {
    return List.foldRight(list, list(), x -> acc -> acc.cons(String.valueOf(x)));
  }
}
