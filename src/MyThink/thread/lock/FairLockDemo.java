package MyThink.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockDemo {

  public static void main(String[] args) {
    PrintDemo printDemo = new PrintDemo();

    Thread[] threads = new Thread[10];
    for (int i = 0; i < 10; i++) {
      threads[i] = new Thread(new Job(printDemo));
    }

    for (int i = 0; i < 10; i++) {
      threads[i].start();
    }
  }



  static class Job implements Runnable{

    PrintDemo printDemo;

    public Job(PrintDemo printDemo) {
      this.printDemo = printDemo;
    }

    @Override
    public void run() {
      printDemo.print();
    }
  }

  static class PrintDemo{
    private Lock lock = new ReentrantLock();


    public void print(){
      lock.lock();
      try {
        System.out.println(Thread.currentThread().getName()+"开始打印卷子1");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"打印完毕1");
      }finally {
        lock.unlock();
      }


      lock.lock();
      try {
        System.out.println(Thread.currentThread().getName()+"开始打印卷子2");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"打印完毕2");
      }finally {
        lock.unlock();
      }


    }
  }
}
