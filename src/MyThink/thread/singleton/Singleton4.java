package MyThink.thread.singleton;


/**
 * 线程安全的饿汉模式(不可用)  效率太低了  每次只能有一个线程创建实体
 */
public class Singleton4 {
  private static Singleton4 instance;

  private Singleton4() {
  }


  public static synchronized Singleton4 getInstance() {
    if (instance == null){
      instance = new Singleton4();
    }
    return instance;
  }

}
