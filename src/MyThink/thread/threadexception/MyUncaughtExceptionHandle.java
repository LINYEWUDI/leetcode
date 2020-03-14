package MyThink.thread.threadexception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyUncaughtExceptionHandle  implements Thread.UncaughtExceptionHandler{

  @Override
  public void uncaughtException(Thread t, Throwable e) {
    Logger logger = Logger.getAnonymousLogger();
    logger.log(Level.WARNING,"线程异常拉！！！！"+t.getName());
  }

}
