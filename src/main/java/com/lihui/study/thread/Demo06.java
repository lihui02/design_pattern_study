package com.lihui.study.thread;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 采集n台机器的数据，每个子线程采集一台，但最多只能开M个线程
 */
public class Demo06 {
    public static void main(String[] args) {
        OperateService operateService=new OperateService();
        Runnable task=new Task6();
        operateService.operate(task);
        operateService.operate(task);
        operateService.operate(task);
    }
}
class OperateService {
    private Task6 task=new Task6();
    List<Thread> threadList=new ArrayList<>();

    List<Runnable> runnableList=new ArrayList<>();
    void operate(Runnable task){
        if (threadList.size()>=10){
            runnableList.add(task);
        }else {
            Thread t=new Thread(task);
            threadList.add(t);
            t.start();
        }

    }


}
class Task6 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"dodoodo");
    }
}
