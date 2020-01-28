package com.nashaofu;

import java.util.List;
import java.util.Objects;

public class Equals {
  public static void main(String[] args) {
    List<Person> list = List.of(
      new Person("Xiao Ming"),
      new Person("Xiao Hong"),
      new Person("Bob")
    );
    System.out.println(list.contains(new Person("Bob"))); // false
    System.out.println(list.indexOf(new Person("Bob"))); // false
  }
}


class Person {
  String name;
  public int age;

  public Person(String name) {
    this.name = name;
  }

  public boolean equals(Object o) {
    if (o instanceof Person) {
      Person p = (Person) o;
      return Objects.equals(this.name, p.name) && this.age == p.age;
    }
    return false;
  }
}
