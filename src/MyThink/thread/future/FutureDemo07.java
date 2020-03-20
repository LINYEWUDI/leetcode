package MyThink.thread.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * 使用FutureTask启动Callable方法
 */
public class FutureDemo07 {


  public static void main(String[] args) {
    CallableTask callableTask = new CallableTask();
    FutureTask<String> futureTask = new FutureTask<>(callableTask);
    ExecutorService executorService = Executors.newCachedThreadPool();
    Future<?> future = executorService.submit(futureTask);
    try {
      System.out.println(futureTask.get());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    executorService.shutdown();
  }


  static class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
      return "Hello Future!";
    }
  }
}
