package MyThink.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo2 {

  static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

  static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
  static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();



  public static void main(String[] args) {
    new Thread(() -> {write();}).start();
    new Thread(() -> {read();}).start();
    new Thread(() -> {read();}).start();
    new Thread(() -> {write();}).start();
    new Thread(() -> {read();}).start();


    for (int i = 0; i < 10000; i++) {
      new Thread(()->{
        read();
      },"子线程创建的子线程"+i).start();
    }
  }

  public static void read(){
    System.out.println(Thread.currentThread().getName()+"想要获取读锁");
    readLock.lock();
    try {
      System.out.println(Thread.currentThread().getName()+"获取到了read锁");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }finally {
      System.out.println(Thread.currentThread().getName()+"释放读锁");
      readLock.unlock();
    }
  }

  public static void write(){
    System.out.println(Thread.currentThread().getName()+"想要获取写锁");
    writeLock.lock();
    try {
      System.out.println(Thread.currentThread().getName()+"获取到了write锁");
      try {
        Thread.sleep(40);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }finally {
      System.out.println(Thread.currentThread().getName()+"释放写锁");
      writeLock.unlock();
    }
  }
}
