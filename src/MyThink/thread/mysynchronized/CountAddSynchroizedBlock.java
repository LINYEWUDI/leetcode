package MyThink.thread.mysynchronized;

/**
 * 同步代码块形式 此时代码块中的锁如果是this,则传入的实现runnable接口的对象必须是一样的，不然就是两把锁
 */
public class CountAddSynchroizedBlock implements Runnable {

  static int count = 0;

  static CountAddSynchroizedBlock countAddSynchroizedBlock = new CountAddSynchroizedBlock();
  static CountAddSynchroizedBlock countAddSynchroizedBlock1 = new CountAddSynchroizedBlock();

  @Override
  public void run() {
      synchronized (this) {
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
