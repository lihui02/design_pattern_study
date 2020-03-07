package com.lihui.study.thread.demo07;

import java.util.List;

public interface MyLock {
    void lock();
    void unlock();
    List<Thread> getLockList();
}
