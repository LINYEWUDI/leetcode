package MyThink.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockDemo2 {

  static ReentrantLock lock = new ReentrantLock();

  public static void main(String[] args) {
    accessResource();
  }

  public static void accessResource(){
    try {
      lock.lock();
      if (lock.getHoldCount() < 5){
        System.out.println(lock.getHoldCount());
        accessResource();
        System.out.println(lock.getHoldCount());
      }
    }finally {
      lock.unlock();
    }
  }
}
