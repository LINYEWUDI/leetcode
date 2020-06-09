package MyThink.jvm;

import java.util.ArrayList;

/**
 * 本类用来测试子线程的内存溢出，主线程会不会收到影响，以及子线程OOM后，堆内存会不会释放
 */
public class ThreadHeapTest {

    private static final int _8M = 8 * 1024 * 1024;


    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            final ArrayList<byte[]> list = new ArrayList<>();

            byte[] bytes = new byte[_8M];

            list.add(bytes);
            list.add(bytes);
            list.add(bytes);
            list.add(bytes);
        }).start();
        Thread.sleep(1000);


        System.out.println(111);
    }

}
