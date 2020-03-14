package MyThink.thread.mywaitnotify;

public class WaitNotifyFirst {

  public int i = 1;

  static Object object = new Object();
  public static void main(String[] args) {

    Thread thread = new Thread(new Runnable() {
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

        System.out.println(Thread.currentThread().getName()+"执行结束");
      }
    });

    Thread thread1 = new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (object){
          System.out.println(Thread.currentThread().getName()+"唤醒objtect");
          object.notify();

          System.out.println(Thread.currentThread().getName()+"完成");

        }
      }
    });


    thread.start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    thread1.start();


  }

  private void methid() {
    System.out.println(this);
  }


}
