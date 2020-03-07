package com.lihui.study.thread.demo08;

public class Demo08 {
    public static void main(String[] args) {

        Thread t1=new Thread(){
            @Override
            public void run() {
                    int a=10/0;
            }
        };
        t1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+"=="+e.getLocalizedMessage());
            }
        });
        t1.start();

    }
}
