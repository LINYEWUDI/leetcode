package MyThink.thread.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 1000; i++) {
      Future<?> submit = executorService.submit(new Task());
      try {
        System.out.println(submit.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //会将现有的任务执行完在关闭，但是不能再提交新的任务
    executorService.shutdown();
    executorService.submit(new Task());
  }
}

class Task implements Runnable{

  @Override
  public void run() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName()+"被中断了");
    }
    System.out.println(Thread.currentThread()+"正在执行。。");
  }

}
