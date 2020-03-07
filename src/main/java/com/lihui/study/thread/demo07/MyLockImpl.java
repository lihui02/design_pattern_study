package com.lihui.study.thread.demo07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 自己实现一个显示锁
 */
public class MyLockImpl implements MyLock {

    private boolean flag=false;
    List<Thread> threadList=new ArrayList<>();
    @Override
    public synchronized void lock() {
        while (flag){
            try {
                threadList.add(Thread.currentThread());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag=true;
    }

    @Override
    public synchronized void unlock() {
         flag=false;
         this.notifyAll();
    }

    @Override
    public List<Thread> getLockList() {
        return Collections.unmodifiableList(threadList);
    }


}
