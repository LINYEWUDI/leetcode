package MyThink.thread.mythreadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 循环创建多个线程来跑
 */
public class MyThreadLocal01 {

  public static void main(String[] args) {

    for (int i = 0; i < 10; i++) {
      final int finI = i;
      new Thread(() -> {
        String s = formatDate(finI);
        System.out.println(s);
      }).start();
    }

  }

  //转换日期方法
  public static String formatDate(int seconds) {
    Date date = new Date(1000 * seconds);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String format = sdf.format(date);
    return format;
  }
}
