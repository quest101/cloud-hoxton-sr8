package com.ken.multithread.day02.example5;

/**
 * 访问同一个对象的非synchronized方法 测试
 */
public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("TheadA");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("TheadB");
        threadA.start();
        threadB.start();
    }
}
