package com.lihui.study.design.pattern.multi.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: Demo02
 * @Description: 门栓CountDownLatch的使用
 * @author: ex_lihui4
 * @date: 2019-11-18  12:02
 */

public class Demo02 {
    CountDownLatch latch =new CountDownLatch(1);
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(1);
       Demo02 d=new Demo02();
        Thread t1=new Thread(d::m1);
        Thread t2=new Thread(d::m2);
        t1.start();
        t2.start();
    }

    public void m1(){
            System.out.println("m1开始");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m1结束");
    }
    public void m2(){
        System.out.println("m2开始");
        latch.countDown();
    }

}
