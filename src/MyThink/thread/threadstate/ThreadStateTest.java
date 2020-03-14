package MyThink.thread.threadstate;

/**
 * 测试线程运行前的状态,start之后的状态,正在运行时的状态,结束的状态
 */
public class ThreadStateTest {

  public static void main(String[] args) throws InterruptedException {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 1000; i++) {
          System.out.println(i);
        }
      }
    };

    Thread thread = new Thread(runnable);

    System.out.println(thread.getState());
    thread.start();
    System.out.println(thread.getState());
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(thread.getState());
    thread.join();
    System.out.println(thread.getState());



  }
}
