package com.ken.multithread.day02.example7;

/**
 * 锁重入测试
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
