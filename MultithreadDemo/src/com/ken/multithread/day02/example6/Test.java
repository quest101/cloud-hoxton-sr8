package com.ken.multithread.day02.example6;

/**
 * 脏读 测试
 */
public class Test {
    public static void main(String[] args) {
        try{
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e){
            e.printStackTrace();;
        }
    }
}
