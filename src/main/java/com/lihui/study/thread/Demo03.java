package com.lihui.study.thread;

import org.springframework.aop.ThrowsAdvice;

/**
 * sleep不会释放锁
 */
public class Demo03 {
    public static void main(String[] args) {
        Task task=new Task();
        Thread t1=new Thread(()->{
            try {
                task.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
            try {
                task.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }

}
class Task{
    synchronized void   m1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
    }
    synchronized void m2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName());
    }
}
