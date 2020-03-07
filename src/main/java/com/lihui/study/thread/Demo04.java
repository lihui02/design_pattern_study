package com.lihui.study.thread;

/**
 * 写一个死锁的程序，以及怎么让查看程序是不是死锁了的命令
 * 在cmd命令行  用'jps'命令获取进程号   再用'jstack'查看有没有死锁
 */
public class Demo04 {
    public static void main(String[] args) {
        Task1 task1=new Task1();
        Thread t1=new Thread(()->task1.m1());
        Thread t2=new Thread(()->task1.m2());
        t1.start();
        t2.start();
    }

}
class Task1{
    private final Object LOCK1=new Object();
    private final Object LOCK2=new Object();
    void m1(){
        synchronized (LOCK1){
            System.out.println(Thread.currentThread().getName()+"获取LOCK1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK2){
                System.out.println(Thread.currentThread().getName()+"获取LOCK2");
            }
        }
    }

    void m2(){
        synchronized (LOCK2){
            System.out.println(Thread.currentThread().getName()+"获取LOCK2");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (LOCK1){
                System.out.println(Thread.currentThread().getName()+"获取LOCK1");

            }
        }
    }
}
