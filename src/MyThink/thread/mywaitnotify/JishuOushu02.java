package MyThink.thread.mywaitnotify;

/**
 * 这种办法比较好，因为一个线程之完毕后会wait，并且唤醒之前wait的线程，交替进行
 */
public class JishuOushu02 {

  static int count = 0;

  static Object object = new Object();

  public static void main(String[] args) {

    Runnable runnable = () -> {
      while (count < 100) {
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + "正在打印"+ count);
            count++;
            object.notify();

            if (count < 100){
              try {
                object.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
          }
        }
      };



    Thread thread = new Thread(runnable);
    Thread thread1 = new Thread(runnable);


    thread.start();
    thread1.start();

    try {
      thread.join();
      thread1.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
