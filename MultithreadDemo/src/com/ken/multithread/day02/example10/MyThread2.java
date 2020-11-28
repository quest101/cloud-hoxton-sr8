package com.ken.multithread.day02.example10;

public class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task){
        super();
        this.task = task;
    }
    public void run(){
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}
