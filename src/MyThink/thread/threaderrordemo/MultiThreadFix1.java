package MyThink.thread.threaderrordemo;

/**
 * 观察者模式验证线程安全问题
 *
 * 针对error1类出现的问题进行解决
 */

public class MultiThreadFix1 {

  private EventListener eventListener;

  int count  = 0;

  public static void main(String[] args) throws InterruptedException {

    Resource resource = new Resource();

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        resource.useEventListener(new Event() {
        });
      }
    });

    Thread thread1 = new Thread(() -> {
      MultiThreadFix1 multiThreadFix1 = newInstance(resource);
    });

    thread1.start();
    thread1.join();
    thread.start();

  }

  public static MultiThreadFix1 newInstance(Resource resource){

    //构造函数中已经完成初始化
    MultiThreadFix1 multiThreadFix1 = new MultiThreadFix1();

    //注册到资源类中
    resource.register(multiThreadFix1.eventListener);

    return multiThreadFix1;

  }

  public MultiThreadFix1() {

    eventListener = event -> {
      System.out.println(count);


    };
    count = 100;
  }


  //资源类,利用这个类使用事件
  static class Resource{
    int i = 0;

    EventListener eventListener;

    public void register(EventListener eventListener) {
      this.eventListener = eventListener;
    }

    void useEventListener(Event event){
      if (eventListener != null){
        eventListener.helloEvent(event);
      }else {
        System.out.println("eventListener is null");
      }
    }

  }

  //事件的监听器
  interface EventListener{
    void helloEvent(Event event);
  }

  //时间类
  interface Event{
  }
}


