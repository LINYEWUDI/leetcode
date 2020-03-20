package MyThink.thread.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 指令重排序  这里会出现指令的重排序问题  一般分为两种，一个是CPU的指令重排，一个是JVM的指令重排
 *
 * 下面代码的顺序可能会被重排
 * a=1   =====》  x=a
 * x=a   =====》  a=1
 *
 */
public class OutofOrderDemo01 {
  static int a,b,x,y;

  public static void main(String[] args) throws InterruptedException {

    int i = 0;
    for(;;){
      a = 0;
      b = 0;
      x = 0;
      y = 0;
      i++;
      CountDownLatch countDownLatch = new CountDownLatch(1);

      Thread thread1 = new Thread(() -> {
        try {
          countDownLatch.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        a = 1;
        x = b;
      });

      Thread thread = new Thread(() -> {
        try {
          countDownLatch.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        b = 1;
        y = a;
      });

      thread1.start();
      thread.start();
      countDownLatch.countDown();
      thread.join();
      thread1.join();

      System.out.println("第"+i+"次,"+"x:"+x+",y:"+y);
      if (x == 0 && y == 0){
        break;
      }
    }

  }
}
