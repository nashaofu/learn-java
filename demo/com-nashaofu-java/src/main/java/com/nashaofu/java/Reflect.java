package com.nashaofu.java;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Reflect {
  public void reflect() {
    MyLogger logger = new MyLogger("com.nashaofu2");
    Class cls = logger.getClass();
    logger.info(Boolean.toString(MyLogger.class == cls));
    logger.info(Boolean.toString(logger instanceof Object));
    System.out.println(Arrays.toString(cls.getDeclaredFields()));
    try {
      Field f = String.class.getDeclaredField("value");
      System.out.println(Modifier.isFinal(f.getModifiers()));
      System.out.println(Modifier.isPublic(f.getModifiers()));
    } catch (NoSuchFieldException e) {
      e.printStackTrace();
    }
    Invoke invoke = new Invoke();
    try {
      invoke.invoke();
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}

class Invoke {
  public void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    // String对象:
    String s = "Hello world";
    // 获取String substring(int)方法，参数为int:
    Method m = String.class.getMethod("replace", CharSequence.class, CharSequence.class);
    // 在s对象上调用该方法并获取结果:
    String r = (String) m.invoke(s, "Hello", "***");
    // 打印调用结果:
    System.out.println("输出结果："+r);
  }
}
