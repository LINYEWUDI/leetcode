package MyThink.thread.myvolatile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducterConsumerVolatileFixed {
  public static void main(String[] args) {
    BlockingQueue b = new ArrayBlockingQueue(10);
    Thread pro = new Thread(new Producer1(b));
    Thread con = new Thread(new Consumer1(b,pro));

    pro.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    con.start();

  }
}

class Producer1 implements Runnable {

  private BlockingQueue blockingQueue;

  static boolean flag = false;

  public Producer1(BlockingQueue blockingQueue) {
    this.blockingQueue = blockingQueue;
  }

  int i = 0;

  @Override
  public void run() {
      try {
        while (!Thread.currentThread().isInterrupted()) {
          blockingQueue.put(i);
          System.out.println("生产者正在生产第" + i + "个产品========目前队列里有:" + blockingQueue.size());
        }
        i++;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    System.out.println("生产者完成工作！！！");
  }

}


/**
 * 消费者达到一定条件时停止消费(具体看业务)
 */
class Consumer1 implements Runnable {

  private BlockingQueue blockingQueue;

  private Thread thread;

  public Consumer1(BlockingQueue blockingQueue,Thread thread) {
    this.blockingQueue = blockingQueue;
    this.thread = thread;
  }

  @Override
  public void run() {

    while (true){

      try {
        Object take = blockingQueue.take();
        System.out.println("生产者正在消费第"+take+"个产品========目前队列里有:"+blockingQueue.size());
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }


      //达到什么条件时就停止消费
      if (Math.random() > 0.95){
        break;
      }
    }

//    Producer1.flag = true;
    thread.interrupt();
    System.out.println("消费者消费完毕");
  }


}

