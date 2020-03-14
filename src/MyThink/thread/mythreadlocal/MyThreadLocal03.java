package MyThink.thread.mythreadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static MyThink.thread.mythreadlocal.MyThreadLocal02.sdf;

/**
 * 对ThreadLocal进行实验
 * 使用ThreadLocal可以通过api往每个线程里面配置一个对象，那么这个线程里面就只用这个对象，不会出现多个线程用一个线程不安全的对象的情况
 */
public class MyThreadLocal03 {


  public static void main(String[] args) {

    ExecutorService es = Executors.newFixedThreadPool(10);

    for (int i = 0; i < 3000; i++) {
      final int finI = i;
      Runnable runnable = () -> {
        String s = formatDate(finI);
        System.out.println(Thread.currentThread().getName()+"========"+s);
      };

      es.submit(runnable);
    }

    es.shutdown();

  }

  //转换日期方法
  public static String formatDate(int seconds) {

    ThreadLocal theadLocal = MyThreadLocal03.getTheadLocal();
    SimpleDateFormat sdf = (SimpleDateFormat)theadLocal.get();
    Date date = new Date(1000 * seconds);
    String format = sdf.format(date);
    return format;
  }

  public static ThreadLocal<SimpleDateFormat> getTheadLocal(){
    ThreadLocal<SimpleDateFormat> theadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

    theadLocal = new ThreadLocal<SimpleDateFormat>() {
      @Override
      protected SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      }
    };

    return theadLocal;
  }
}
