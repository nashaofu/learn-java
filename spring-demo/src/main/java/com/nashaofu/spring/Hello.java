package com.nashaofu.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customerBean = (Customer) context.getBean("customerBean");
        customerBean.displayInfo();

        ((ClassPathXmlApplicationContext) context).close();
    }
}