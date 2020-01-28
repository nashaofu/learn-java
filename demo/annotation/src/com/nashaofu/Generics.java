package com.nashaofu;

import java.lang.Integer;
import java.lang.Number;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Generics {
  public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Pair<Integer> pair = new Pair<Integer>(121);
    int n = Generics.get(pair);
    System.out.println(n);
    Generics.set(pair, 320);
    System.out.println(pair.getValue());


    Class<? super String> sup = String.class.getSuperclass();

    // no warning:
    Class<String> clazz2 = String.class;
    try {
      String str2 = clazz2.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }

    Class<Integer> clazz3 = Integer.class;
    Constructor<Integer> cons = clazz3.getConstructor(int.class);
    Integer i = cons.newInstance(123);

    System.out.println(Arrays.toString(createArray("1","2","3")));
  }

  private static int get(Pair<? extends Number> p) {
    Number val = p.getValue();
    int value = (int)val * 100;
    return value;
  }

  private static void set(Pair<? super Integer> p, Integer value) {
    Number i = (Number)p.getValue();
    p.setValue(value);
  }

  private static String[] createArray(String ...objs) {
    return objs;
  }
}


class Pair<T> {
  private T value;

  public Pair(T value){
    this.value = value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }
}
