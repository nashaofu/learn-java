package com.nashaofu.spring;

public class Customer {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello: " + name);
    }

    public void init() {
        System.out.println("初始化...");
    }

    public void close() {
        System.out.println("销毁...");
    }
}