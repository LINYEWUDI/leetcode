package MyThink.thread.future;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo01 {

  public static void main(String[] args) {
    CallableTask callableTask = new CallableTask();
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<Integer> future = executorService.submit(callableTask);
    System.out.println(future);
    try {
      System.out.println(future.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

    executorService.shutdown();

  }

  static class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
      Thread.sleep(2000);
      return new Random().nextInt();

    }
  }
}
