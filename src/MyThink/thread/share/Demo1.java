package MyThink.thread.share;

/**
 * Java创建线程  count自增
 */
public class Demo1 {

    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            for (int i = 0; i < 1000000; i++) {
                count++;
            }
        };

        final Thread thread1 = new Thread(run);
        final Thread thread2 = new Thread(run);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(count);
    }
}
