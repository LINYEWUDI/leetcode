package MyThink.thread.mywaitnotify;

/**
 * 两个线程交替打印奇偶数
 * 实际上此时有很多的不需要的比较 因为是两个线程同时在运行,并不确定哪个线程会抢到锁,有可能出现某一个线程一直占用的情况,
 * 虽然进不去循环中打印，但是实际上有很多不需要的比较
 */
public class JishuOushu01 {

  static int count = 0;

  static Object object = new Object();

  public static void main(String[] args) {

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        while (count < 100) {
          synchronized (object) {
            if ((count & 1) == 0) {
              System.out.println(Thread.currentThread().getName() + "正在打印偶数" + count);
              count++;
            }
          }
        }
      }
    };


    Runnable runnable1 = new Runnable() {
      @Override
      public void run() {
        while (count < 100) {
          synchronized (object) {
            if ((count & 1) == 1) {
              System.out.println(Thread.currentThread().getName() + "正在打印奇数" + count);
              count++;
            }
          }
        }
      }
    };


    Thread thread = new Thread(runnable);
    Thread thread1 = new Thread(runnable1);

    thread.start();
    thread1.start();

    try {
      thread1.join();
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
