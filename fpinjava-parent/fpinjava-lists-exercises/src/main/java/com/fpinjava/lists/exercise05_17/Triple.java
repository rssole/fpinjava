package com.fpinjava.lists.exercise05_17;

import com.fpinjava.lists.exercise05_16.List;

import static com.fpinjava.lists.exercise05_16.List.foldRight;
import static com.fpinjava.lists.exercise05_16.List.list;

public class Triple {

  public static List<Integer> triple(List<Integer> list) {
    return foldRight(list, list(), x -> acc -> acc.cons(x * 3));
  }
}
