package MyThink.thread.jmm;

public class CanseeDemo01 {

  int a = 1;
  volatile int b = 2;

  public static void main(String[] args) {
    while (true){

      try {
        Thread.sleep(1);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      CanseeDemo01 outOfOrderDemo02 = new CanseeDemo01();
      Runnable runnable = () -> {

        outOfOrderDemo02.change();
      };

      Runnable runnable1 = () -> {
        outOfOrderDemo02.print();
      };

      new Thread(runnable).start();
      new Thread(runnable1).start();

    }
  }

  private void print() {
    System.out.println("a:"+a+",b:"+b);
  }

  private void change() {
    a = 3;
    b = a;
  }
}
