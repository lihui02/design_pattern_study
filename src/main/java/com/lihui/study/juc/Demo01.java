package com.lihui.study.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-18  17:49
 */


public class Demo01 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,4,5, TimeUnit.SECONDS,new ArrayBlockingQueue<>(20));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.submit(new Task("111"));
        System.out.println(threadPoolExecutor.getPoolSize());

        threadPoolExecutor.submit(new Task("222"));
        System.out.println(threadPoolExecutor.getPoolSize());

        threadPoolExecutor.submit(new Task("333"));
        System.out.println(threadPoolExecutor.getPoolSize());
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadPoolExecutor.getPoolSize());
        threadPoolExecutor.shutdown();


    }

}
class Task implements Runnable{
    private String st;
    @Override
    public void run() {
        System.out.println(st);
      /*  try {
            Thread.sleep(1000*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    public Task(String st) {
        this.st=st;
    }
}
