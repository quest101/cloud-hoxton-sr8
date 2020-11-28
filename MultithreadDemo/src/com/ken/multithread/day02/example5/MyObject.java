package com.ken.multithread.day02.example5;

public class MyObject {

     synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName=" +
                    Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("methodA "+Thread.currentThread().getName()+" end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized public void methodB(){
        try {
            System.out.println("begin methodB threadName=" +
                    Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println("methodB"+Thread.currentThread().getName()+" end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
