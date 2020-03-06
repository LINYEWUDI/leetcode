package MyThink.thread.mysynchronized.testsynchroized;

public class TestReinSynchronized {

  public synchronized void show() {
    System.out.println("我是父类方法");
    System.out.println(this);
  }
}


class Son extends TestReinSynchronized{

  public synchronized void show() {
    System.out.println("我是子类类方法");
    super.show();
    System.out.println(this);
  }

  public static void main(String[] args) {
    Son son = new Son();
    son.show();
  }



}
