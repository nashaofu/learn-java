package com.nashaofu.java;

import java.lang.reflect.InvocationHandler;

public class Pro implements Hello {
    InvocationHandler handler;
    public void HelloDynamicProxy(InvocationHandler handler) {
      this.handler = handler;
    }
    public void morning(String name) {
      try {
        handler.invoke(
          this,
          Hello.class.getMethod("morning", String.class),
          new Object[]{name});
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (Throwable e) {
        e.printStackTrace();
      }
    }
}

interface Hello {
  void morning(String name);
}
