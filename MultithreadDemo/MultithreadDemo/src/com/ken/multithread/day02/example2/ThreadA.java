package com.ken.multithread.day02.example2;

public class ThreadA extends Thread{
    private HasSelfPrivateNum numRef;
    public ThreadA(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }
    public void run(){
        super.run();;
        numRef.addI("a");
    }
}
