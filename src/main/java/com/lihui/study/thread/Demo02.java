package com.lihui.study.thread;

/**
 * 1、利用守护线程:当ThreadSerice线程打断、结束时，实际执行任务的runner线程也就强制被结束了；
 * 2、那么为什么不直接在ThreadSerice线程执行任何，进行打断和强制结束呢？
 * 因为有时候，任务会自己block阻塞，我们没有办法进行标志判断或者说是打断的判断，也就没办法进行强制打断了。
 *
 */
public class Demo02 {
    public static void main(String[] args) throws InterruptedException {
        ThreadSerice threadSerice = new ThreadSerice();
        threadSerice.excute(new Runnable() {
            @Override
            public void run() {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    Thread.sleep(15000);
                    System.out.println(System.currentTimeMillis()-currentTimeMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(10000);
        threadSerice.shutdown(100L);
    }
}

class ThreadSerice {
    private Thread t1;
    private boolean flag=false;

    public void excute(Runnable task) {
        t1 = new Thread() {
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    runner.join();
                    flag=true;
                } catch (InterruptedException e) {
                    System.out.println("t1中断了");
                }
            }
        };
        t1.start();
    }

    public void shutdown(Long time) {
        long currentTimeMillis = System.currentTimeMillis();
        //flag=false，说明守护线程还没执行完，需要判断是否需要停止
        while (!flag){
            if (System.currentTimeMillis()-currentTimeMillis>=time){
                t1.interrupt();
                break;
            }
        }
        //守护线程执行完了，执行线程肯定也停止了
        System.out.println("在时间范围内已经执行完了");
    }
}
