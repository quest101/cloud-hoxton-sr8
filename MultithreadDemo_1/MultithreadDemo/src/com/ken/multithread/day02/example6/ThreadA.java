package com.ken.multithread.day02.example6;

public class ThreadA extends Thread{
    private PublicVar publicVar;
    public ThreadA(PublicVar publicVar){
        super();
        this.publicVar = publicVar;
    }
    public void run(){
        super.run();;
        publicVar.setValue("B","BB");
    }
}
