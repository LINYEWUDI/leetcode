package MyThink.thread.myvolatile;


/**
 * 貌似正确的volatile
 */
public class FistVolatile implements Runnable {


  static FistVolatile f = new FistVolatile();

  static boolean flag = true;

  @Override
  public void run() {

    int i = 0;

    try {
      while (i < 10000 && flag) {
        if (i % 100 == 0) {
          System.out.println(i);
        }
        Thread.sleep(1);
        i++;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static void main(String[] args) {
    Thread thread = new Thread(f);
    thread.start();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    flag = false;
  }

}
