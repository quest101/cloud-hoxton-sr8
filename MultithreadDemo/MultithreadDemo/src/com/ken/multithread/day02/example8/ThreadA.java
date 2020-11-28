package com.ken.multithread.day02.example8;

public class ThreadA extends Thread{
    private ObjectService service;
    public ThreadA(ObjectService service){
        super();
        this.service = service;
    }
    public void run(){
        super.run();;
        service.serviceMethod();
    }
}
