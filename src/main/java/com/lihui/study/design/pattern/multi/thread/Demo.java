package com.lihui.study.design.pattern.multi.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: Demo
 * @Description: 实现线程的三种方式
 * @author: ex_lihui4
 * @date: 2019-11-16  14:50
 */

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 1.继承Thread
         */
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("子线程1");
            }
        };
        t1.start();
        /**
         * 实现Runnable,传入Thread
         */
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("子线程2");
            }
        });
        t2.start();
        /**
         * 实现Callable,包装成Future
         */
        FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
            public Integer call(){
                System.out.println("子线程3");
                return 1;
            }
        });
        Thread t3 = new Thread(task);
        t3.start();
        System.out.println(task.get());

    }
}
