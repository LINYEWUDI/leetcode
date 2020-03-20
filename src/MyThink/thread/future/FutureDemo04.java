package MyThink.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo04 {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(20);

    CallableTask callableTask = new CallableTask();

    Future<Integer> future = executorService.submit(callableTask);
    //仅仅判断线程中的任务是否完成，而不管是否发生异常
    System.out.println(future.isDone());
    try {
      Thread.sleep(2000);
      System.out.println(future.isDone());

      System.out.println(future.get());
    } catch (InterruptedException e) {
      System.out.println("InterruptedException=========异常");
    } catch (ExecutionException e) {
      System.out.println("ExecutionException=========异常");
    }

    executorService.shutdown();

  }

  static class CallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
       Thread.sleep(100);
       throw new RuntimeException("Callable发生异常啦！！！");
    }
  }
}
