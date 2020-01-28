package com.nashaofu.java;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("hello world!");
    MyLogger logger = new MyLogger("com.nashaofu");
    logger.info("is my info");
    logger.warning("warning!");
    Reflect r = new Reflect();
    r.reflect();
    String[] st = new String[]{"1","2"};
    Ref.main(st);
    Pro pro = new Pro();
    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method);
        if (method.getName().equals("morning")) {
          System.out.println("Good morning, " + args[0]);
        }
        return null;
      }
    };
    pro.HelloDynamicProxy(handler);
    pro.morning("morning");
  }
}
