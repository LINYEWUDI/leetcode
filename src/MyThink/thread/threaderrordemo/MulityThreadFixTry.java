package MyThink.thread.threaderrordemo;

public class MulityThreadFixTry {

  ObserveF observeF;


  public static void main(String[] args) {
    SubjectF subjectF = new SubjectF();
    
    new Thread(() -> {
//      try {
//        Thread.sleep(1000);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      subjectF.setCount(100);
    }).start();

    MulityThreadFixTry mulityThreadFixTry = getInstance(subjectF);
  }


  private MulityThreadFixTry(SubjectF subjectF) {

    observeF = new ObserveF(subjectF) {
      @Override
      public void update() {
        System.out.println("66666666666"+subjectF.getCount());
      }
    };


    try {
      Thread.sleep(300);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    observeF = new ObserveF(subjectF) {
      @Override
      public void update() {
        System.out.println("888888888888："+subjectF.getCount());
      }
    };
  }

  public static MulityThreadFixTry getInstance(SubjectF subjectF) {
    MulityThreadFixTry mulityThreadFixTry = new MulityThreadFixTry(subjectF);
    subjectF.setObserveF(mulityThreadFixTry.observeF);

    return mulityThreadFixTry;
  }

}


abstract class ObserveF{
  protected SubjectF SubjectF;
  public abstract void update();

  public ObserveF(SubjectF SubjectF) {
    this.SubjectF = SubjectF;
  }
}


class SubjectF{

  private ObserveF ObserveF;
  private int count;

  public void setObserveF(ObserveF ObserveF) {
    this.ObserveF = ObserveF;
  }

  public void useObserveF() {
    ObserveF.update();
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
    ObserveF.update();
  }
}
