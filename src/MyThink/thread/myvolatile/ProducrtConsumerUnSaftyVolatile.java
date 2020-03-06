package MyThink.thread.myvolatile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 这个类实际上是有问题的
 * 问题出现在,如果消费者消费的速度比较慢，而生产者生产的速度比较快的情况下，生产者的队列满了，那么put操作会阻塞。
 * 如果阻塞了，那么while循环条件里面的标记变量就失去了意义，因为不会再进行循环，已经卡住了
 */
public class ProducrtConsumerUnSaftyVolatile {

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue queue = new ArrayBlockingQueue(10);
    Consumer consumer = new Consumer(queue);
    Producer producer = new Producer(queue);

    new Thread(producer).start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    new Thread(consumer).start();


  }

}




class Consumer implements Runnable{

  BlockingQueue blockingQueue;

  public Consumer(BlockingQueue blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  public boolean show() {
    if (Math.random() < 0.95){
      return true;
    }

    return false;
  }


  @Override
  public void run() {
    while (show()){
      try {
        System.out.println("消费了"+blockingQueue.take());
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("消费者不需要数据了");
    Producer.flag = false;
  }
}
/**
 * 往阻塞队列里添加元素
 */
class Producer implements Runnable{
  //停止生产的标记
  public static volatile boolean flag = true;


  //阻塞队列
  BlockingQueue blockingQueue;


  public Producer(BlockingQueue blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run() {

    int i = 0;
    try {
      while (i < 10000 && flag) {
        if (i % 100 == 0) {
          //放入阻塞队列中
          Thread.sleep(10);
          blockingQueue.put(i);
          System.out.println("往队列里放入了"+i+"=========="+"当前队列数量："+blockingQueue.size());
        }
        i++;
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }finally {
      System.out.println("生产者停止运行");
    }
  }
}
