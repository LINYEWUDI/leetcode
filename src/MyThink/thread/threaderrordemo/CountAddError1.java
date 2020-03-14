package MyThink.thread.threaderrordemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * count++的问题
 */
public class CountAddError1 {

  static int count = 0;
  static AtomicInteger atomicInteger = new AtomicInteger();
  static AtomicInteger errorInteger = new AtomicInteger();
  //初始化boolean数组，判断是否发生过冲突
  static boolean[] arr = new boolean[100000000];

  static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
  static CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);

  static Object obj = new Object();

  public static void main(String[] args) throws InterruptedException {
//    arr[0] = true;

    Runnable runnable = () -> {

      for (int i = 0; i < 10000; i++) {
        try {
          cyclicBarrier1.reset();
          //这里的栅栏是为了防止某一个线程跑的过快:举个例子：
          // 当A线程已经完成了一次循环，而 B线程正在进行  if (arr[count]){}此时，A线程已经又把count++了，
          // 这里是B线程的判断就会出现问题
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }

        atomicInteger.incrementAndGet();
        count++;
        cyclicBarrier.reset();
        try {
          //这里的等待是防止A线程正在进行判断时，B线程搞了个count++
          cyclicBarrier1.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        } catch (BrokenBarrierException e) {
          e.printStackTrace();
        }
        synchronized (obj){
          if (arr[count] && arr[count-1]){
            System.out.println(count+"发生错误");
            errorInteger.incrementAndGet();
          }
          arr[count] = true;
        }
      }
    };

    Thread thread1 = new Thread(runnable);
    Thread thread = new Thread(runnable);

    thread.start();
    thread1.start();

    thread.join();
    thread1.join();

    System.out.println("表面上累加之后：" + count);
    System.out.println("发生错误的次数" + errorInteger);
    System.out.println("真实的数据：" + atomicInteger);

  }

}
