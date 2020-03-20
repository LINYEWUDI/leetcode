package MyThink.thread.singleton;


/**
 * 同步代码块懒汉模式(可用)
 */
public class Singleton2 {
  private static Singleton2 instance;

  static {
    instance = new Singleton2();
  }

  private Singleton2() {
  }


  public static Singleton2 getInstance() {
    return instance;
  }

}
