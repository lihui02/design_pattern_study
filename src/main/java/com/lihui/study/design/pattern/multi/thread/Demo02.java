package com.lihui.study.design.pattern.multi.thread;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class Demo02 {
    public static void main(String[] args) {
        ReentrantLock lock=new ReentrantLock();
        Thread t1=new Thread(()->{
            try {
                System.out.println("线程1开始");
                lock.lockInterruptibly();

                sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                System.out.println("打断");
            }finally {
                lock.unlock();
            }
        });
        Thread t2=new Thread(()->{
          lock.lock();
            System.out.println("线程2开始");
          lock.unlock();
        });
        t1.start();
        t2.start();
        //t1.interrupt();
    }

}
