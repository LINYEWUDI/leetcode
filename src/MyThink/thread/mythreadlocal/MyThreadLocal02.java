package MyThink.thread.mythreadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池来跑 有并发问题  将SimpleDateFormat变成静态变量时会出现并发问题
 */
public class MyThreadLocal02 {

  static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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
    Date date = new Date(1000 * seconds);
    String format = sdf.format(date);
    return format;
  }
}
