package MyThink.thread.threaderrordemo;

public class DeathThread {

  static DeathThread d1 = new DeathThread();
  static DeathThread d2 = new DeathThread();

  public static void main(String[] args) {
    Runnable runnable1 = () -> {
      synchronized (d1) {
        System.out.println(Thread.currentThread().getName() + "我在d1");
        synchronized (d2) {
          System.out.println(Thread.currentThread().getName() + "我在d2");
        }
      }
    };

    Runnable runnable = () -> {
      synchronized (d2) {
        System.out.println(Thread.currentThread().getName() + "我在d2");
        synchronized (d1) {
          System.out.println(Thread.currentThread().getName() + "我在d1");
        }
      }
    };

    new Thread(runnable).start();
    new Thread(runnable1).start();
  }
}
