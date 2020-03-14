package MyThink.thread.mywaitnotify;

public class WaitNotifyOwnLock {

  public int i = 1;

  static Object objectA = new Object();
  static Object objectB = new Object();

  public static void main(String[] args) {

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (objectA) {
          System.out.println(Thread.currentThread().getName() + "进入objectA");
          try {
            synchronized (objectB) {
              System.out.println(Thread.currentThread().getName() + "进入objectB");
              System.out.println(Thread.currentThread().getName() + "准备wait====objectB");
              objectB.wait();
              System.out.println(Thread.currentThread().getName() + "完成");
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        System.out.println(Thread.currentThread().getName() + "执行结束");
      }
    });

    Thread thread1 = new Thread(() -> {
      synchronized (objectB) {
        System.out.println(Thread.currentThread().getName() + "进入objectB");
        synchronized (objectA) {
          System.out.println(Thread.currentThread().getName() + "进入objectA");
          System.out.println(Thread.currentThread().getName() + "完成");
        }
      }
      System.out.println(Thread.currentThread().getName() + "执行结束");
    });


    thread.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread1.start();



  }
}
