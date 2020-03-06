package MyThink.thread.mysynchronized.testsynchroized;

/**
 * 两个线程同时访问两个同步方法 判断是并行还是串行
 */
public class TestSynchroized implements Runnable{

  static TestSynchroized r = new TestSynchroized();
  static TestSynchroized r1 = new TestSynchroized();

  @Override
  public void run() {
    if ("Thread-0".equals(Thread.currentThread().getName())){
      method();
    }else {
      method1();
    }
  }

  public static synchronized void method1(){
    System.out.println("method1"+Thread.currentThread().getName()+"开始执行");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    throw new RuntimeException("有异常了玩济公玩");
//    System.out.println("method1"+Thread.currentThread().getName()+"完成执行");
  }


  public synchronized void method(){
    System.out.println("method"+Thread.currentThread().getName()+"开始执行");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("method"+Thread.currentThread().getName()+"完成执行");
  }


  public static void main(String[] args) {
    Thread thread = new Thread(r);
    Thread thread1 = new Thread(r);

    thread.start();
    thread1.start();

  }
}
