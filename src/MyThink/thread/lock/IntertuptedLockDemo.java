package MyThink.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntertuptedLockDemo {
  static Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    TaskDemo taskDemo = new TaskDemo();
    Thread thread = new Thread(taskDemo);
    Thread thread1 = new Thread(taskDemo);

    thread.start();
    thread1.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt();
  }

  static class TaskDemo implements Runnable {

    @Override
    public void run() {
      try {
        lock.lockInterruptibly();
        try {
          System.out.println(Thread.currentThread().getName() + "获取到了锁");
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          System.out.println(Thread.currentThread().getName() + "在睡眠过程中被打断");
        } finally {
          lock.unlock();
          System.out.println(Thread.currentThread().getName() + "执行完成");
        }
      } catch (InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + "在获取的过程中被中断");
      }
    }
  }
}
