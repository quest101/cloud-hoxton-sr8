package com.ken.multithread.day02.example10;

public class MyThread1 extends Thread {
    private Task task;
    public MyThread1(Task task){
        super();
        this.task = task;
    }
    public void run(){
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}
