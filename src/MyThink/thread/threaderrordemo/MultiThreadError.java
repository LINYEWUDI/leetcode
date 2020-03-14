package MyThink.thread.threaderrordemo;

/**
 *
 */
public class MultiThreadError {
  static Person person;

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        Person person = new Person(1, 1);
      }
    };

    new Thread(runnable).start();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(person);
  }
}

class Person{

  int name;
  int age;

  public Person(int name, int age) {
    this.name = name;
    MultiThreadError.person = this;
    try {
      Thread.sleep(200);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
            "name=" + name +
            ", age=" + age +
            '}';
  }
}
