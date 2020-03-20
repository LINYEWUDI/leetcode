package MyThink.thread.threadpool;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolShutNow {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 1000; i++) {
      executorService.submit(new Task());
    }

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    //会立即关闭，阻塞中的线程被中断，阻塞队列的线程被返回
    List<Runnable> runnables = executorService.shutdownNow();
    executorService.submit(new Task());
  }
}


