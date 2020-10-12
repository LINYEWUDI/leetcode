package MyThink.thread.share;

/**
 * Java创建线程  count自增
 */
public class Demo3 implements Runnable {

    static int count = 0;

    @Override
    public void run() {
        if ("Thread-0".equals(Thread.currentThread().getName())){
            method1();
        }else {
            method2();
        }

    }

    public synchronized static void method1() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    public synchronized void method2() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final Demo3 demo3 = new Demo3();
        final Thread t1 = new Thread(demo3);
        final Thread t2 = new Thread(demo3);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count);
    }
}
