package com.lihui.study.mybatis;



import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Demo01
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2019-12-19  16:29
 */

public class Demo01 {
    public static void main(String[] args) {

        ThreadPoolExecutor executor=new ThreadPoolExecutor(10, 15, 1000,
                TimeUnit.SECONDS,new LinkedBlockingDeque<>());
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(11111);
            }
        });

        executor.shutdown();
    }
}
