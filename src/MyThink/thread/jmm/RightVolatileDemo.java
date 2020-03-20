package MyThink.thread.jmm;

/**
 * volatile关键字实际上只具有两个功能  1.可见性  2.禁止指令重排
 * 不具有原子性
 */
public class RightVolatileDemo implements Runnable {
  volatile boolean flage = true;

  public static void main(String[] args) throws InterruptedException {

    while (true){

      RightVolatileDemo rightVolatileDemo = new RightVolatileDemo();

      Thread thread = new Thread(rightVolatileDemo);
      Thread thread1 = new Thread(rightVolatileDemo);

      thread.start();
      thread1.start();

      thread.join();
      thread1.join();

      System.out.println(rightVolatileDemo.flage);
    }



  }

  @Override
  public void run() {

    for (int i = 0; i < 1000; i++) {
      flage = !flage;
    }
  }
}
