package com.ken.multithread.day02.example11;

/**
 * 一半异步 一半同步 测试
 */
public class Run {
    public static void main(String[] args) throws InterruptedException{
        Task task = new Task();
        MyThread1 thread1 = new MyThread1(task);
        MyThread2 thread2 = new MyThread2(task);
        thread1.start();
        thread2.start();
    }
}
