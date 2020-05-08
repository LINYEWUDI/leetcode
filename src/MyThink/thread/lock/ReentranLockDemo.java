package MyThink.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo {

  static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    accessResource();
  }

  public static void accessResource(){
    try {
      lock.lock();
      System.out.println(lock.getHoldCount());
      lock.lock();
      System.out.println(lock.getHoldCount());
      lock.unlock();
      System.out.println(lock.getHoldCount());
    }finally {
      lock.unlock();
      System.out.println(lock.getHoldCount());
    }
  }
}
