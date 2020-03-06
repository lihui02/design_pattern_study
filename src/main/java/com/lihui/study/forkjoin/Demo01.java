package com.lihui.study.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-17  11:45
 */

public class Demo01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask task=new ForkJoinTask() {
            @Override
            public Object getRawResult() {
                System.out.println(111);
                return 1;
            }

            @Override
            protected void setRawResult(Object value) {

            }

            @Override
            protected boolean exec() {
                System.out.println(222);
                return true;
            }
        };
        forkJoinPool.submit(task);
        //System.out.println(task.get());
    }
}
