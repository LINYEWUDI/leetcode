package MyThink.thread.threaderrordemo;

/**
 * 观察者模式验证线程安全问题
 *
 * 此时会出现问题：先看构造器里面的初始化方法,会打印出count的值,但是最后输出的count前后是不一致的
 */

public class MultiThreadError1 {



  public static void main(String[] args) {


    //初始化静态内部类,此时内部类中的linstener为null,并没有初始化
    Resource resource = new Resource();

    //启动子线程进行监听器事件的访问
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {

        System.out.println("子线程开始执行....");
        try {
          System.out.println("主线程开始执行....");
          Thread.sleep(50);
          System.out.println("主线程完成....");
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        //这里会使用事件推送
        resource.useListener(new Event() {
        });
        System.out.println("子线程结束....");
      }
    });

    thread.start();
    //将上面的对象传入之后,本类构造器会对上面的对象进行初始化,包括注册监听器和执行
    MultiThreadError1 multiThreadError1 = new MultiThreadError1(resource);

  }


  int count = 0;

  //初始化该类的构造器,入参为静态内部类,在构造器中进行初始化
  private MultiThreadError1(Resource resource){

    resource.registerListener((event) -> {
      //查看当前的count值是多少,初始化到这一步时为0
      System.out.println("1让我看看现在的count是多少"+count);

    });

    for (int i = 0; i < 10000; i++) {
      System.out.print(i);
    }
    count = 100;
  }



  static class Resource{

    private EventListener listener;

    //注册监听器
    void registerListener(EventListener listener){
      this.listener = listener;
    }

    //使用该监听器
    void useListener(Event event){
      if (listener != null){
        listener.onEvent(event);
      }else {
        System.out.println("listener为空,未初始化完成。。。");
      }
    }

  }


  //事件监听器
  interface EventListener{
    void onEvent(Event event);
  }

  //事件 该事件类为时间监听器的入参
  interface Event{

  }

}


