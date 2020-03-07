package com.lihui.study.thread;

/**
 * 一个线程的生产者与一个线程的消费者（多线程有问题，你notify的时候，生产者和消费者都唤醒了
 * 消费者1消费完了唤醒了消费者2（实际上需要唤醒生产者），由于没有生产者生产，消费者2也wait了，
 * 这样所有的生产者和消费者2都wait了，没有其他线程去唤醒他们了
 *
 */
public class Demo05 {
    private volatile int i;
    private volatile boolean isProduce = false;
    public static void main(String[] args) {
        Demo05 demo05=new Demo05();
        Thread t1=new Thread(()->{
            while (true){
                demo05.produce();
            }
        });
        Thread t2=new Thread(()->{
            while (true){
                demo05.consumer();
            }
        });
        t1.start();
        t2.start();
    }
    private void produce(){
        synchronized (this){
            if (!isProduce){
                System.out.println("P-->>"+(++i));
                isProduce=true;
                this.notify();
            }else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void consumer(){
        synchronized (this){
            if (isProduce){
                System.out.println("C-->>"+i);
                isProduce=false;
                this.notify();
            }else {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}


