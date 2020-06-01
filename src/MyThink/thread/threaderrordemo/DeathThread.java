package MyThink.thread.threaderrordemo;

public class DeathThread {

  static Object d1 = new Object();
  static Object d2 = new Object();

  public static void main(String[] args) {
    Runnable runnable1 = () -> {
      synchronized (d1) {
        System.out.println(Thread.currentThread().getName() + "我在d1");
        synchronized (d2) {
          System.out.println(Thread.currentThread().getName() + "我在d2");
        }
      }
    };

    Runnable runnable2 = () -> {
      synchronized (d2) {
        System.out.println(Thread.currentThread().getName() + "我在d2");
        synchronized (d1) {
          System.out.println(Thread.currentThread().getName() + "我在d1");
        }
      }
    };

    new Thread(runnable2).start();
    new Thread(runnable1).start();
  }
}
