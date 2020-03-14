package MyThink.thread.threadexception;

/**
 * 子线程处理异常分为两种方式，一个是在run方法中直接捕捉异常，不推荐，另一个另外写一个全局异常处理器
 */
public class ThreadExceptionDemo1 {

  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandle());

    Runnable runnable = new Runnable() {
      @Override
      public void run() {
          throw new RuntimeException(Thread.currentThread().getName()+"出现异常了！！！");
      }
    };

    Thread thread = new Thread(runnable);
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    Thread thread3 = new Thread(runnable);

    thread.start();
    thread1.start();
    thread2.start();
    thread3.start();


  }
}
