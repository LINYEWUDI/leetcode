package MyThink.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockDemo1 {
  static Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    TaskDemo taskDemo = new TaskDemo();
    Thread thread = new Thread(taskDemo);
    Thread thread1 = new Thread(taskDemo);

    thread.start();
    thread1.start();
  }

  static class TaskDemo implements Runnable{

    @Override
    public void run() {
      try {
        lock.lock();
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"获取到了锁");

      }finally {
        lock.unlock();
      }
    }
  }
}
