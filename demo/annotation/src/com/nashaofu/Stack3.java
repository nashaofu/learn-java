package com.nashaofu;

import java.util.*;

public class Stack3 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      list.add(i);
    }
    // 洗牌前:
    System.out.println(list);
    Collections.shuffle(list);
    // 洗牌后:
    System.out.println(list);
  }
}
