package MyThink.thread.future;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * 使用FutureTask启动Callable方法
 */
public class FutureDemo06 {


  public static void main(String[] args) {
    CallableTask callableTask = new CallableTask();
    FutureTask<String> futureTask = new FutureTask(callableTask);
    Thread thread = new Thread(futureTask);
    thread.start();
    try {
      String s = futureTask.get();
      System.out.println(s);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }

  }


  static class CallableTask implements Callable<String>{

    @Override
    public String call() throws Exception {
      return "Hello Future！";
    }
  }
}
