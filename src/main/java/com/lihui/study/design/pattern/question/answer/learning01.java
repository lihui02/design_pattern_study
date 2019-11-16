package com.lihui.study.design.pattern.question.answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: learning01
 * @Description: 试题
 * @author: ex_lihui4
 * @date: 2019-11-16  16:29
 */

public class learning01 {
    public static void main(String[] args) {
        /**
         *         面试题：实现一个容器，提供两个方法add，size，
         *         线程1添加10个元素到容器，线程2监控元素的个数，当个数为5时，线程2提示并结束
         *
         *     ===下面这种方式t2线程的死循环浪费性能，建议采用synchronized、wait、notify的方式来让
         *     线程1主动唤醒线程2执行。
         */
        final MyContainer<Integer> myContainer=new MyContainer<Integer>();
        Thread t1=new Thread(new Runnable() {
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println("线程1添加元素"+i);
                    myContainer.add(i);
                }
                System.out.println("线程1结束");
            }
        });
        Thread t2=new Thread(new Runnable() {
            public void run() {
                while (true){
                    if (myContainer.size()>=5){
                        break;
                    }
                }
                System.out.println("线程2结束");

            }
        });
        t1.start();
        t2.start();
    }
}
class MyContainer<T>{
private volatile List<T> list=new ArrayList<T>();
    public void add(T t){
        list.add(t);
    }

    public int size(){
        return list.size();
    }
}