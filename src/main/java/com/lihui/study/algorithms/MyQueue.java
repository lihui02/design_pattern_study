package com.lihui.study.algorithms;

import java.util.ArrayList;

/**
 * @ClassName: MyStack
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-3-6  9:27
 */

public class MyQueue<E> {
    private Object[] a;
    private int front=0;
    private int back=-1;
    private int currentSize=0;
    public MyQueue(int iniitialCapaticy) {
    a=new Object[iniitialCapaticy];
    }
    public void enqueue(E e) throws RuntimeException {
        if (currentSize>a.length) throw new RuntimeException("队列已满");
        if (back==a.length-1){
            back=0;
            a[back]=e;
            currentSize++;
        }else {
            a[++back]=e;
            currentSize++;
        }
    }
    public E dequeue() throws RuntimeException {
        if (currentSize==0)throw new RuntimeException("队列已空");
        E e;
        if (front==a.length-1){
            currentSize--;
            front=0;
             e=(E)a[a.length-1];
            a[a.length-1]=null;
        }else {
            currentSize--;
            e= (E)a[front];
            a[front]=null;
            front++;
        }
        return e;
    }
    public int size(){
        return back-front+1;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue=new MyQueue<>(4);
        queue.enqueue(0);
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());

        System.out.println(queue.dequeue());


    }
}
