package MyThink.thread.singleton;


/**
 * 饿汉模式(不可用)  线程不安全
 */
public class Singleton3 {
  private static Singleton3 instance;

  private Singleton3() {
  }


  public static Singleton3 getInstance() {
    if (instance == null){
      instance = new Singleton3();
    }
    return instance;
  }

}
