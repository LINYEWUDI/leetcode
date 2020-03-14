package MyThink.thread.threadstate;

/**
 * 线程休眠的状态，synchronized时的状态，定时休眠的状态
 */
public class ThreadStateTest1 implements Runnable {

  public static void main(String[] args) throws InterruptedException {
    ThreadStateTest1 threadStateTest1 = new ThreadStateTest1();

    Thread thread = new Thread(threadStateTest1);
    thread.start();

    Thread thread1 = new Thread(threadStateTest1);
    thread1.start();

    System.out.println(thread.getState());
    System.out.println(thread1.getState());


    Thread.sleep(1300);


    System.out.println(thread.getState());
    System.out.println(thread1.getState());



    Thread.sleep(1300);
    System.out.println(thread.getState());
    System.out.println(thread1.getState());
  }

  private void method() {
    synchronized (this){
      try {
        Thread.sleep(1000);
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }


  @Override
  public void run() {
    method();
  }
}
