package MyThink.thread.threaderrordemo;

/**
 * 学习下观察者模式
 */
public class MulityThreadErrorTry {
  public static void main(String[] args) {
    Subject subject = new Subject();
    
    new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        subject.setCount(100);
      }
    }).start();

    MulityThreadErrorTry mulityThreadErrorTry = new MulityThreadErrorTry(subject);
  }


  public MulityThreadErrorTry(Subject subject) {

    subject.setObserve(new Observe(subject) {
      @Override
      public void update() {
        System.out.println("现在num：0");
      }
    });

    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    subject.setObserve(new Observe(subject) {
      @Override
      public void update() {
        System.out.println("现在num：1111");
      }
    });

  }
}


abstract class Observe{
  protected Subject subject;
  public abstract void update();

  public Observe(Subject subject) {
    this.subject = subject;
  }
}


class Subject{

  private Observe observe;
  private int count;

  public void setObserve(Observe observe) {
    this.observe = observe;
  }

  public void useObserve() {
    observe.update();
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
    observe.update();
  }
}
