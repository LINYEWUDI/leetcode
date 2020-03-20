package MyThink.thread.singleton;


/**
 * 静态内部类内部类的懒汉模式(可用)
 */
public class Singleton6 {

  private Singleton6() {
  }

  private static class StaticInnerClss{
    private static final Singleton6 instance = new Singleton6();
  }

  public static Singleton6 getInstance() {
    return StaticInnerClss.instance;
  }

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        Singleton6 instance = Singleton6.getInstance();
        System.out.println(instance);
      }
    };

    Thread thread = new Thread(runnable);
    Thread thread1 = new Thread(runnable);

    thread.start();
    thread1.start();

  }

}
