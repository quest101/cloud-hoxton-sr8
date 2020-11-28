package com.ken.multithread.day02.example10;

public class Task {
    private String getData1;
    private String getData2;
    public void doLongTimeTask(){
        try{
            System.out.println("begin task");
            Thread.sleep(3000);
            String privteGetData1 = "长时间处理任务后从远程返回的值1 threadName="
                    +Thread.currentThread().getName();
            String privteGetData2 = "长时间处理任务后从远程返回的值2 threadName="
                    +Thread.currentThread().getName();
            synchronized(this){
                getData1 = privteGetData1;
                getData2 = privteGetData2;
            }
            System.out.println(getData2);
            System.out.println(getData2);
            System.out.println("end task");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
