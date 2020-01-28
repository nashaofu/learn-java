package com.nashaofu;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public class Main {
  public static void main(String[] args) {
    System.out.println("main");
    Demo demo = new Demo("Tom", "Dasdasdasdasdas");
    demo.say("sdasd");
    try {
      Demo.check(demo);
    } catch (IllegalArgumentException | ReflectiveOperationException e) {
      e.printStackTrace();
    }
    System.out.println(Demo.class.getAnnotation(Range.class));
  }
}

class Demo {
  @Range(min=1, max=20)
  public String name;

  @Range(max=10)
  public String city;
  public Demo(String name, String city) {
    this.name=name;
    this.city=city;
  }

  public void say(String msg) {
    System.out.println(msg);
  }

  /**
   * 检测字段是否符合条件
   * @param person
   * @throws IllegalArgumentException
   * @throws ReflectiveOperationException
   */
  public static void check(Demo person) throws IllegalArgumentException, ReflectiveOperationException {
    // 遍历所有Field:
    for (Field field : person.getClass().getFields()) {
      // 获取Field定义的@Range:
      Range range = field.getAnnotation(Range.class);
      // 如果@Range存在:
      if (range != null) {
        // 获取Field的值:
        Object value = field.get(person);
        // 如果值是String:
        if (value instanceof String) {
          String s = (String) value;
          // 判断值是否满足@Range的min/max:
          if (s.length() < range.min() || s.length() > range.max()) {
            throw new IllegalArgumentException("Invalid field: " + field.getName());
          }
        }
      }
    }
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
  int min() default 0;
  int max() default 255;
}

