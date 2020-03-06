package MyThink.thread.myinterrupt;

/**
 * 在写基础模块时，线程中断一定要将异常抛出，不然会被吞掉。或者将异常标记重新打上
 */
public class RightInterupBest implements Runnable {

  static RightInterupBest r = new RightInterupBest();

  @Override
  public void run() {
    int i = 0;
    while (!Thread.currentThread().isInterrupted()){
        System.out.println(i++);
      try {
        show();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      }
    }
  }

  public void show() throws InterruptedException {
      Thread.sleep(100);

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
