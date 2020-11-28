package com.ken.multithread.day02.example7;

public class MyThread extends Thread {
    public void run(){
        Service service = new Service();
        service.service1();
    }
}
