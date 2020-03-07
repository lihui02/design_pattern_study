package com.lihui.study.thread;

/**
 * interrupt的使用
 */
public class Demo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("执行的欢乐");
                }
                System.out.println("惨了，被打断了");
            }
        });
        t1.start();
        System.out.println(t1.isInterrupted());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
        System.out.println(t1.isInterrupted());
        System.out.println("main end");
    }
}
