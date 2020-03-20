package MyThink.thread.singleton;


/**
 * ***********双重锁饿汉模式(可用)  面试装逼必备
 *
 * 这里什么属性中需要加valatile？
 * volatile有两点作用，都在这里起到了作用分别是  提供可见性和禁止指令重排
 * 1.  可见性   假设有两个线程，当A线程已经创建之后，这里的instance实际上就不是null，但是如果不加volatile就没有可见性
 * 那么B线程就不知道A线程实际上已经初始化了，就会再创建一个，这是可见性在这里的提现
 *
 * 2.   禁止指令重排
 * 创建对象实际上并不是一个原子的操作。创建对象 分为三步 1.创建一个空对象 2.调用构造器进行初始化 3.赋值给变量
 * 但是由于可能出现CPU指令重排问题(指令重排分为CPU指令重排和JVM指令重排)
 * 那么就有可能是 1.创建对象 2.赋值给变量 3.用构造器初始化  这是如果A线程进行到2步，此时的instance已经不是null，
 * 但是还没进行第三部，只是个空对象
 * B线程进行判断对象是否为空时，就会直接返回这个空的对象，也就是里面属性没有值的对象
 *
 */
public class Singleton5DoubleCheck {
  private static volatile Singleton5DoubleCheck instance;

  private Singleton5DoubleCheck() {
  }


  public static Singleton5DoubleCheck getInstance() {
    if (instance == null){
      synchronized (Singleton5DoubleCheck.class){
        //此处还需要再次检查，如果不在这里的检查，那么当两个线程同时走进这个判断时，
        // 虽然不能同进创建对象，但是还是会分开创建对象，这是线程不安全的
        if (instance == null){
          instance = new Singleton5DoubleCheck();
        }
      }
    }
    return instance;
  }

}
