package com.ken.multithread.day02.example3;

public class ThreadB extends Thread {
    private HasSelfPrivateNum numRef;
    public ThreadB(HasSelfPrivateNum numRef){
        super();
        this.numRef = numRef;
    }
    public void run(){
        super.run();;
        numRef.addI("b");
    }
}
