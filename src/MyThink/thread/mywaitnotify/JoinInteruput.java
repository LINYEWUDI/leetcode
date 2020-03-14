package MyThink.thread.mywaitnotify;

public class JoinInteruput {

  public static void main(String[] args) {
    Thread mainThread = Thread.currentThread();

    Runnable runnable = () -> {
      try {
        mainThread.interrupt();
        Thread.sleep(5000);
        System.out.println("子线程运行完成 ");
      } catch (InterruptedException e) {
        System.out.println("子线程中断");
        e.printStackTrace();
      }
    };

    Thread thread = new Thread(runnable);

    thread.start();
    System.out.println("等待子线程运行");
    try {
      thread.join();
    } catch (InterruptedException e) {
      System.out.println(Thread.currentThread().getName()+"线程被打断");
      thread.interrupt();
      e.printStackTrace();
    }

    System.out.println("主线程运行完成");

  }


}
