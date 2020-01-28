package com.nashaofu;

import java.util.HashMap;

public class MapDemo {
  public static void main(String[] args) {
    Student s = new Student("Xiao Ming", 99);
    HashMap<String, Student> map = new HashMap<>();
    map.put("Xiao Ming", s); // 将"Xiao Ming"和Student实例映射并关联
    map.put("Xiao", new Student("Xiao", 99));
    Student target = map.get("Xiao Ming"); // 通过key查找并返回映射的Student实例
    System.out.println(target == s); // true，同一个实例
    System.out.println(target.score); // 99
    Student another = map.get("Bob"); // 通过另一个key查找
    System.out.println(another); // 未找到返回null

    for (String key : map.keySet()) {
      Student value = map.get(key);
      System.out.println(key + " = " + value);
    }

    for (HashMap.Entry<String, Student> entry : map.entrySet()) {
      String key = entry.getKey();
      Student value = entry.getValue();
      System.out.println(key + " = " + value);
    }
  }
}


class Student {
  public String name;
  public int score;

  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }
}
