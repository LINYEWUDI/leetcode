package MyThink.thread.share;

/**
 * 同步方法几种形式
 */
public class Demo2 implements Runnable{

    static int count = 0;

    static Demo2 demo1 = new Demo2();
    static Demo2 demo2 = new Demo2();

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {


        final Thread thread1 = new Thread(demo1);
        final Thread thread2 = new Thread(demo2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }

    //对象锁
    private static void add() {
        synchronized (obj){
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        }
    }

    //类锁
    private static synchronized void add1() {
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
    }

    //对象锁
    private synchronized void add2() {
        synchronized (this){
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        }
    }

    //类锁
    private synchronized void add3() {
        synchronized (Demo2.class){
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        }
    }

    @Override
    public void run() {
        add3();
    }
}
