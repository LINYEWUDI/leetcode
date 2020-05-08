package MyThink.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo implements Runnable {

  int flag;

  static Lock lock1 = new ReentrantLock();
  static Lock lock2 = new ReentrantLock();

  public static void main(String[] args) {
    TryLockDemo tryLockDemo = new TryLockDemo();
    TryLockDemo tryLockDemo1 = new TryLockDemo();

    tryLockDemo.flag = 1;
    tryLockDemo1.flag = 0;
    
    Thread thread = new Thread(tryLockDemo);
    Thread thread1 = new Thread(tryLockDemo);

    thread.start();
    thread1.start();
  }

  @Override
  public void run() {
    //如果争抢失败则进行重试
    for (int i = 0; i < 100; i++) {
      if (flag == 1) {
        try {
          if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
            try {
              System.out.println(Thread.currentThread().getName() + "获取到了lock1");

              Thread.sleep(2000);

              if (lock2.tryLock()) {
                try {
                  System.out.println(Thread.currentThread().getName() + "获取了lock2");
                  System.out.println(Thread.currentThread().getName()+"获取了两把锁");
                  Thread.sleep(2000);
                  break;
                } finally {
                  lock2.unlock();
                }
              } else {
                System.out.println(Thread.currentThread().getName() + "未获取到锁2");
              }
            } finally {
              lock1.unlock();
            }
          } else {
            System.out.println(Thread.currentThread().getName() + "未获取到锁1");

          }


        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      if (flag == 0) {
        try {
          if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
            try {
              System.out.println(Thread.currentThread().getName() + "获取到了lock2");

              Thread.sleep(2000);

              if (lock1.tryLock()) {
                try {
                  System.out.println(Thread.currentThread().getName() + "获取了lock1");
                  System.out.println(Thread.currentThread().getName()+"获取了两把锁");
                  Thread.sleep(2000);
                  break;
                } finally {
                  lock1.unlock();
                }
              } else {
                System.out.println(Thread.currentThread().getName() + "未获取到锁2");
              }
            } finally {
              lock2.unlock();
            }
          } else {
            System.out.println(Thread.currentThread().getName() + "未获取到锁1");

          }


        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }
  }
}