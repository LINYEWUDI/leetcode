package MyThink.thread.myinterrupt;

public class RightInterruptWhithSleep implements Runnable{

  static RightInterruptWhithSleep r = new RightInterruptWhithSleep();

  @Override
  public void run() {
    int i = 0;
    while (i < 300){
      if (i % 10 == 0){
        System.out.println(i);
      }
      i++;
    }
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(r);
    thread.start();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.interrupt();
  }
}
