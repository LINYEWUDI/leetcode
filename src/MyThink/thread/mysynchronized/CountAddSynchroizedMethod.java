package MyThink.thread.mysynchronized;

/**
 * 方法上加锁形式
 */
public class CountAddSynchroizedMethod implements Runnable {

  static int count = 0;

  static CountAddSynchroizedMethod countAddSynchroizedBlock = new CountAddSynchroizedMethod();
  static CountAddSynchroizedMethod countAddSynchroizedBlock1 = new CountAddSynchroizedMethod();

  @Override
  public void run() {
    show();
  }

  public synchronized void show() {
    System.out.println("当前线程"+Thread.currentThread().getName()+"持有的锁对象:"+this);

    for (int i = 0; i < 10000; i++) {
      count++;
    }
    try {
      System.out.println("开始执行业务代码一秒钟");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("当前线程"+Thread.currentThread().getName()+"持有的锁对象:"+this);
  }

  public static void main(String[] args) throws InterruptedException {


    Thread thread = new Thread(countAddSynchroizedBlock);
    Thread thread1 = new Thread(countAddSynchroizedBlock);

    thread.start();
    thread1.start();

    thread.join();
    thread1.join();

    System.out.println(count);

  }

}
