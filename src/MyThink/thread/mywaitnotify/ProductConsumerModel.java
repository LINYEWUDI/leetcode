package MyThink.thread.mywaitnotify;

import java.util.Date;
import java.util.LinkedList;

/**
 * 生产者消费者实现
 */
public class ProductConsumerModel {

  public static void main(String[] args) {
    Store store = new Store(10, new LinkedList());
    Producer producer = new Producer(store);
    Consumer consumer = new Consumer(store);

    new Thread(producer).start();
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    new Thread(consumer).start();
  }

}

class Producer implements Runnable {
  final Store store;

  public Producer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      store.put();
    }

  }
}

class Consumer implements Runnable {

  final Store store;

  public Consumer(Store store) {
    this.store = store;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      store.get();
    }
  }
}

//队列
class Store {
  int maxSize;
  LinkedList<Date> list;

  public Store(int maxSize, LinkedList list) {
    this.maxSize = maxSize;
    this.list = list;
  }

  public synchronized void put() {
    if (maxSize == list.size()) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    list.add(new Date());
    System.out.println("已成功添加,现在队列中数量："+list.size());
    notify();
  }

  public synchronized Date get() {

    if (0 == list.size()){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    Date date = list.poll();
    System.out.println("消费者已经消费,现在队列中数量："+list.size());
    notify();
    return date;

  }


  public int getSize() {
    return list.size();
  }
}