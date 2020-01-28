package com.nashaofu;

import java.util.*;

public class Collection {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("apple"); // size=1
    list.add("pear"); // size=2
    list.add("apple"); // 允许重复添加元素，size=3
    System.out.println(list.size());

    List<Integer> list8 = List.of(1, 2, 5);
    System.out.println(list8);
    for (int i = 0; i < list8.size(); i++) {
      Integer s = list8.get(i);
      System.out.println(s);
    }
    iterator();
    create();
    Sort.run();
    Sort.run2();
  }

  private static void iterator() {
    List<String> list = List.of("apple", "pear", "banana");
    for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
      String s = it.next();
      System.out.println(s);
    }

    for (String s : list) {
      System.out.println(s);
    }

    String[] arr = list.toArray(new String[3]);
    String[] array = list.toArray(String[]::new);
    System.out.println(Arrays.toString(arr));
    System.out.println("*********");
    System.out.println(Arrays.toString(array));
  }

  private static void create() {
    Integer[] array = {1, 2, 3};
    List<Integer> list = List.of(array);
    System.out.println(list);
  }
}


class Sort {
  public static void run() {
    // 构造从start到end的序列：
    final int start = 10;
    final int end = 20;
    List<Integer> list = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    // 随机删除List中的一个元素:
    int removed = list.remove(10);
    int found = findMissingNumber(start, end, list);
    System.out.println(list.toString());
    System.out.println("missing number: " + found);
    System.out.println(removed == found ? "测试成功" : "测试失败");
  }

  public static int findMissingNumber(int start, int end, List<Integer> list) {
    Iterator<Integer> iterator = list.iterator();
    for (int i = start; i <= end; i++) {
      if (iterator.hasNext()) {
        int val = iterator.next();
        if (val != i) {
          return i;
        }
      } else {
        return i;
      }
    }
    return 0;
  }

  public static void run2() {
    // 构造从start到end的序列：
    final int start = 10;
    final int end = 20;
    List<Integer> list = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      list.add(i);
    }
    // 洗牌算法suffle可以随机交换List中的元素位置:
    Collections.shuffle(list);
    // 随机删除List中的一个元素:
    int removed = list.remove((int) (Math.random() * list.size()));
    int found = findMissingNumber2(start, end, list);
    System.out.println(list.toString());
    System.out.println("missing number: " + found);
    System.out.println(removed == found ? "测试成功" : "测试失败");
  }

  public static int findMissingNumber2(int start, int end, List<Integer> list) {
    System.out.println("________");
    for (int i = start; i <= end; i++) {
      if (!list.contains(i)) {
        return i;
      }
    }
    return 0;
  }

}
