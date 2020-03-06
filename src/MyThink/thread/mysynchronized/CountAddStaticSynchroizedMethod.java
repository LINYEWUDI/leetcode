package MyThink.thread.mysynchronized;

/**
 * 方法加锁(类锁) 此时方法上的是把类锁,类锁的本质 .class 对象,只要是这个类创建出来的对象，不管是不是同一个对象，都会被锁住
 */
public class CountAddStaticSynchroizedMethod implements Runnable {

  static int count = 0;

  static CountAddStaticSynchroizedMethod countAddSynchroizedBlock = new CountAddStaticSynchroizedMethod();
  static CountAddStaticSynchroizedMethod countAddSynchroizedBlock1 = new CountAddStaticSynchroizedMethod();

  @Override
  public void run() {
    show();
  }

  public static synchronized void show() {
    System.out.println("当前线程"+Thread.currentThread().getName()+"持有的锁对象:");

    for (int i = 0; i < 10000; i++) {
      count++;
    }
    try {
      System.out.println("开始执行业务代码一秒钟");
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("当前线程"+Thread.currentThread().getName()+"持有的锁对象:");
  }

  public static void main(String[] args) throws InterruptedException {


    Thread thread = new Thread(countAddSynchroizedBlock);
    Thread thread1 = new Thread(countAddSynchroizedBlock1);

    thread.start();
    thread1.start();

    thread.join();
    thread1.join();

    System.out.println(count);

  }

}
