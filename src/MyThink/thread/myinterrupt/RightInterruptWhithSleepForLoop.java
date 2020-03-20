package MyThink.thread.myinterrupt;

public class RightInterruptWhithSleepForLoop implements Runnable {

  static RightInterruptWhithSleepForLoop r = new RightInterruptWhithSleepForLoop();

  @Override
  public void run() {
    int i = 0;
    while (i < 30001 && !Thread.currentThread().isInterrupted()) {
      if (i % 10 == 0) {
        System.out.println(i);
      }
      i++;

      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }

    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(r);
    thread.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.interrupt();
  }
}
