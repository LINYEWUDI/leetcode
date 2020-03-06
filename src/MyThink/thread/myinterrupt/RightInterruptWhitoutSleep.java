package MyThink.thread.myinterrupt;

public class RightInterruptWhitoutSleep implements Runnable{

  static RightInterruptWhitoutSleep r = new RightInterruptWhitoutSleep();

  @Override
  public void run() {
    int i = 0;
    while (i < Integer.MAX_VALUE && !Thread.currentThread().isInterrupted()){
      if (i % 10000 == 0){
        System.out.println(i);
      }
      i++;
    }
  }

  public static void main(String[] args) {
    Thread thread = new Thread(r);
    thread.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread.interrupt();
  }
}
