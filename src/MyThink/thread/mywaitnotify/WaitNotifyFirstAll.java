package MyThink.thread.mywaitnotify;

public class WaitNotifyFirstAll {

  public int i = 1;

  static Object object = new Object();

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        synchronized (object) {
          try {
            System.out.println(Thread.currentThread().getName() + "准备wait");
            object.wait();
            System.out.println(Thread.currentThread().getName() + "完成");
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        System.out.println(Thread.currentThread().getName() + "执行结束");
      }
    };
    Thread thread = new Thread(runnable);
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);

    Thread threadNotify = new Thread(() -> {
      synchronized (object) {
        System.out.println(Thread.currentThread().getName() + "唤醒objtect");
        object.notifyAll();
        System.out.println(Thread.currentThread().getName() + "完成");
      }
    });


    thread.start();
    thread1.start();
    thread2.start();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    threadNotify.start();


  }

  private void methid() {
    System.out.println(this);
  }


}
