package com.ken.multithread.day02.example4;

public class MyObject {

     synchronized public void methodA(){
        try {
            System.out.println("begin methodA threadName=" +
                    Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+" end");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
