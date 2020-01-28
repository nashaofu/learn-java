package com.nashaofu;

import java.util.*;

public class PriorityQueueDemo {
  public static void main(String[] args) {
    Queue<User> q = new PriorityQueue<>(new UserComparator());
    // 添加3个元素到队列:
    q.offer(new User("Bob", "A1"));
    q.offer(new User("Alice", "A2"));
    q.offer(new User("Boss", "V1"));
    System.out.println(q.poll()); // Boss/V1
    System.out.println(q.poll()); // Bob/A1
    System.out.println(q.poll()); // Alice/A2
    System.out.println(q.poll()); // null,因为队列为空
    Stack2.run();
  }
}

class UserComparator implements Comparator<User> {
  public int compare(User u1, User u2) {
    if (u1.number.charAt(0) == u2.number.charAt(0)) {
      // 如果两人的号都是A开头或者都是V开头,比较号的大小:
      return u1.number.compareTo(u2.number);
    }
    if (u1.number.charAt(0) == 'V') {
      // u1的号码是V开头,优先级高:
      return -1;
    } else {
      return 1;
    }
  }
}

class User {
  public final String name;
  public final String number;

  public User(String name, String number) {
    this.name = name;
    this.number = number;
  }

  public String toString() {
    return name + "/" + number;
  }
}


class Stack2 {
  public static void run() {
    String hex = toHex(12500);
    if (hex.equalsIgnoreCase("30D4")) {
      System.out.println("测试通过");
    } else {
      System.out.println("测试失败");
    }
  }

  static String toHex(int n) {
    Deque<Integer> st = new LinkedList<>();
    String[] hexs = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    String s = "";
    int val = n;
    while (val > 0) {
      st.push(val % 16);
      val /= 16;
    }
    System.out.println(st);
    while (st.size() > 0) {
      s += hexs[st.pop()];
    }
    System.out.println(s);
    return s;
  }
}
