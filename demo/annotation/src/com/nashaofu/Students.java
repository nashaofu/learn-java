package com.nashaofu;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

public class Students {
  public static void main(String[] args) {
    List<Student2> list = List.of(
      new Student2("Bob", 78),
      new Student2("Alice", 85),
      new Student2("Brush", 66),
      new Student2("Newton", 99)
    );

    StudentsList holder = new StudentsList(list);
    System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
    System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
    System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");


    EnumMap<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
    map.put(DayOfWeek.MONDAY, "星期一");
    map.put(DayOfWeek.TUESDAY, "星期二");
    map.put(DayOfWeek.WEDNESDAY, "星期三");
    map.put(DayOfWeek.THURSDAY, "星期四");
    map.put(DayOfWeek.FRIDAY, "星期五");
    map.put(DayOfWeek.SATURDAY, "星期六");
    map.put(DayOfWeek.SUNDAY, "星期日");
    System.out.println(map);
    System.out.println(map.get(DayOfWeek.MONDAY));
    System.out.println(DayOfWeek.TUESDAY);
  }
}

class Student2 {
  public String name;
  public int score;

  Student2(String name, int score) {
    this.name = name;
    this.score = score;
  }
}


class StudentsList {
  List<Student2> list;
  HashMap<String, Integer> cache;

  StudentsList(List<Student2> list) {
    this.list = list;
    this.cache = new HashMap<>();
  }

  /**
   * 根据name查找score，找到返回score，未找到返回-1
   */
  int getScore(String name) {
    // 先在Map中查找:
    Integer score = this.cache.get(name);
    if (score == null) {
      score = this.findInList(name);
      if (score != null) {
        this.cache.put(name, score);
      }
    }
    return score == null ? -1 : score.intValue();
  }

  Integer findInList(String name) {
    for (var ss : this.list) {
      if (ss.name.equals(name)) {
        return ss.score;
      }
    }
    return null;
  }
}
