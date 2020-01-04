package com.lihui.study.design.pattern.multi.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Demo03 {
    public static void main(String[] args) {
        MyContainer<String> myContainer=new MyContainer<>();
        for (int i= 0;i<2;i++){
            new Thread("p"+i){
                @Override
                public void run() {
                    for (int i=0;i<15;i++){
                        myContainer.put(Thread.currentThread().getName()+i);
                    }
                }
            }.start();
        }
        for (int i=0;i<2;i++){
            new Thread("c"+i){
                @Override
                public void run() {
                    for (int i=0;i<30;i++){

                        System.out.println(myContainer.get()+"目前容器数量"+myContainer.getCount());
                    }
                }
            }.start();
        }


    }
}

class MyContainer<T>{
    private volatile LinkedList<T> list=new LinkedList<>();
    private final int max=10;  //生产者的最大数量
    ReentrantLock lock=new ReentrantLock();
    public synchronized void put(T t){
        while (list.size()==max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        list.addFirst(t);
    }
    public synchronized T get(){
        while (list.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T last = list.removeLast();
        this.notifyAll();
        return last;
    }

    public int getCount(){
        return list.size();
    }
}