package com.lihui.study.thread.demo07;

public class Test {
    MyLock  lock = new MyLockImpl();

    public static void main(String[] args) {
        Test test=new Test();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(test::m1);
            t1.start();
        }
        System.out.println(test.lock.getLockList().size());
    }

     private void m1() {
        lock.lock();
        System.out.println(Thread.currentThread().getName());
        lock.unlock();
    }
}
