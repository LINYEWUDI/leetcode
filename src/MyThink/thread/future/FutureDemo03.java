package MyThink.thread.future;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo03 {

  public static void main(String[] args) {
    //实现Callable接口有返回值
    Callable<Integer> callable = ()-> {
      Thread.sleep(2000);
      return new Random().nextInt();
    };

    //线程池的容量为2
    ExecutorService executorService = Executors.newFixedThreadPool(2);
    ArrayList<Future<Integer>> list = new ArrayList<>();

    for (int i = 0; i < 20; i++) {
      Future<Integer> future = executorService.submit(callable);
      list.add(future);
    }

    for (int i = 0; i < 20; i++) {
      try {
        System.out.println(list.get(i).get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
    executorService.shutdown();

  }

}
