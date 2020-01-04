package com.lihui.study.design.pattern.multi.thread;

public class demo01 implements Runnable
{
    private static int a=10;

    public static void main(String[] args) throws InterruptedException {
      for (int i = 0;i<5;i++){
          new Thread(new demo01(),Integer.toString(i)).start();
      }

    }
    public void run() {
        for (int i =0;i<10;i++){
            synchronized (this){
                a--;
                System.out.println(Thread.currentThread().getName()+":"+a);
            }

        }
    }
}
