package com.nashaofu;

import java.util.*;

public class SetMap {
  public static void main(String[] args) {
    List<Message> received = List.of(
      new Message(1, "Hello!"),
      new Message(2, "发工资了吗？"),
      new Message(2, "发工资了吗？"),
      new Message(3, "去哪吃饭？"),
      new Message(3, "去哪吃饭？"),
      new Message(4, "Bye")
    );
    List<Message> displayMessages = process(received);
    for (Message message : displayMessages) {
      System.out.println(message.text);
    }
  }

  static List<Message> process(List<Message> received) {
    // TODO: 按sequence去除重复消息
    Set<Integer> set = new HashSet<>();
    List<Message> m = new ArrayList<>();

    for (Message message : received) {
      if (!set.contains(message.sequence)) {
        m.add(message);
      }
      set.add(message.sequence);
    }
    return m;
  }
}

class Message {
  public final int sequence;
  public final String text;

  public Message(int sequence, String text) {
    this.sequence = sequence;
    this.text = text;
  }

  public boolean equals(Message m) {
    return this.text.equals(m) && this.sequence == m.sequence;
  }

  public int hashCode() {
    return Objects.hash(this.sequence, this.text);
  }
}
