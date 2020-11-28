package com.ken.multithread.day02.example4;

/**
 * synchronized 锁对象测试
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
