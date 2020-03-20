package MyThink.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolHooDIY extends ThreadPoolExecutor {

  //标记
  boolean flag;

  Lock lock = new ReentrantLock();
  Condition condition;

  public ThreadPoolHooDIY(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    condition = lock.newCondition();
  }

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    super.beforeExecute(t,r);
    lock.lock();
    try {
      if (flag){
        try {
          condition.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }finally {
      lock.unlock();
    }
  }

  public void pause(){
    try {
      lock.lock();
      flag = true;
    }finally {
      lock.unlock();
    }
  }

  public void unpause(){
    try {
      lock.lock();
      flag = false;
      condition.signalAll();
    }finally {
      lock.unlock();
    }
  }


  public static void main(String[] args) throws InterruptedException {
    ThreadPoolHooDIY threadPoolHooDIY = new ThreadPoolHooDIY(10, 10, 0, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "正在执行。。");
      }
    };

    for (int i = 0; i < 10000; i++) {
      threadPoolHooDIY.execute(runnable);
    }

    Thread.sleep(1500);
    threadPoolHooDIY.pause();
    System.out.println("======================给我停！");
    Thread.sleep(20000);
    threadPoolHooDIY.unpause();
    System.out.println("======================给我走！");
  }
}
