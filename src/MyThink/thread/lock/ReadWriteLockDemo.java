package MyThink.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

  public static void main(String[] args) {
    ReadWriteInner readWriteInner = new ReadWriteInner();
    new Thread(readWriteInner::write).start();
    new Thread(readWriteInner::write).start();
    new Thread(readWriteInner::read).start();
    new Thread(readWriteInner::read).start();

  }

  static class ReadWriteInner{
    //创建读写锁
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //创建读锁
    ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    //创建写锁
    ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    public void read(){
      readLock.lock();
      try {
        System.out.println(Thread.currentThread().getName()+"获取了read锁");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }finally {
        System.out.println(Thread.currentThread().getName()+"释放了read锁");
        readLock.unlock();
      }
    }

    public void write(){
      writeLock.lock();
      try {
        System.out.println(Thread.currentThread().getName()+"获取了write锁");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }finally {
        System.out.println(Thread.currentThread().getName()+"释放了write锁");
        writeLock.unlock();
      }
    }



  }

}
