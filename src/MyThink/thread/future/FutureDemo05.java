package MyThink.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * cancel方法中，如果参数为false，则不会强行打断已经运行的的线程，但是如果是没有运行的任务不会在运行，或者是不知道执行的任务是否
 * 可以捕捉中断异常等等
 */
public class FutureDemo05 {

  private static Advertisement advertisement = new Advertisement("我是默认的广告");

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    showAd();
  }

  public static void showAd() throws ExecutionException, InterruptedException {
    CallableTask callableTask = new CallableTask();
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Future<Advertisement> future = executorService.submit(callableTask);

    Advertisement advertisement;

    try {
      //如果等待的时间内都没有返回的话，就直接走进超市异常
      advertisement = future.get(4, TimeUnit.SECONDS);

    } catch (TimeoutException e) {
      advertisement = new Advertisement("超时时候的广告");
      //如已经超时，则中断任务
      boolean cancel = future.cancel(true);


      System.out.println("cancel:"+cancel);
    } catch (InterruptedException e) {
      advertisement = new Advertisement("InterruptedException时候的广告");
    } catch (ExecutionException e) {
      advertisement = new Advertisement("ExecutionException时候的广告");
    }

    System.out.println(advertisement);
    executorService.shutdown();
  }

  static class Advertisement{
    String name;

    public Advertisement(String name) {
      this.name = name;
    }

    @Override
    public String toString() {
      return "Advertisement{" +
              "name='" + name + '\'' +
              '}';
    }
  }

  private static class CallableTask implements Callable<Advertisement> {

    @Override
    public Advertisement call() throws Exception {
      try {
        Thread.sleep(4000);
      }catch (InterruptedException e){
        System.out.println("请求网络的过程中被打断了....");
        return new Advertisement("被中断的默认广告");
      }
      return new Advertisement("华硕的广告....");
    }
  }
}
