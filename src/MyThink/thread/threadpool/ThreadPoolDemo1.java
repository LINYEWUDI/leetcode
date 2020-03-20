package MyThink.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * isShutdown只能判断是否线程池是否结束(执行了shutdown，此时会把没执行完的和队列的任务都执行完，但是不能提交新的）
 * 就算还有没有执行完的任务 也会返回true
 *
 * isTerminated 则是只有线程池中的线程都执行完了才会返回true
 */
public class ThreadPoolDemo1 {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      executorService.submit(new Task());
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //会将现有的任务执行完在关闭，但是不能再提交新的任务
    System.out.println(executorService.isShutdown());
    executorService.shutdown();
    System.out.println(executorService.isShutdown());
    System.out.println(executorService.isTerminated());

    Thread.sleep(20000);

    System.out.println(executorService.isTerminated());


  }
}


