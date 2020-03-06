package MyThink.thread.mysynchronized;

/**
 * 同步代码块形式 此时代码块中的锁是一个类的Class对象,那么只要是这个类创建出来的对象，都会被锁住
 */
public class CountAddStaticSynchroizedBlock implements Runnable {

  static int count = 0;

  static CountAddStaticSynchroizedBlock countAddSynchroizedBlock = new CountAddStaticSynchroizedBlock();
  static CountAddStaticSynchroizedBlock countAddSynchroizedBlock1 = new CountAddStaticSynchroizedBlock();

  @Override
  public void run() {
      synchronized (CountAddStaticSynchroizedBlock.class) {
//      synchronized (this) {
        System.out.println("当前线程"+Thread.currentThread().getName()+"持有的锁对象:"+this);

        for (int i = 0; i < 10000; i++) {
          count++;
        }
    }
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
