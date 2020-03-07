package com.lihui.study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程的生产者与一个线程的消费者
 * 利用  ReentrantLock和 Condition来控制唤醒的具体线程
 */
public class Demo05Verison2 {
    ReentrantLock lock = new ReentrantLock();
    Condition produceCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    private volatile int i;
    private volatile boolean isProduce = false;

    public static void main(String[] args) {
        Demo05Verison2 demo05 = new Demo05Verison2();
        Thread t1 = new Thread(() -> {
            while (true) {
                demo05.produce();
            }
        }, "生产者1");
        Thread t2 = new Thread(() -> {
            while (true) {
                demo05.produce();
            }
        }, "生产者2");
        Thread t3 = new Thread(() -> {
            while (true) {
                demo05.consumer();
            }
        }, "消费者1");
        Thread t4 = new Thread(() -> {
            while (true) {
                demo05.consumer();
            }
        }, "消费者2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    private void produce() {
        lock.lock();
        while (isProduce) {
            try {
                produceCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "P-->>" + (++i));
        isProduce = true;
        consumerCondition.signal();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void consumer() {
        lock.lock();
        while (!isProduce) {
            try {
                consumerCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "C-->>" + i);
        isProduce = false;
        produceCondition.signal();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}


