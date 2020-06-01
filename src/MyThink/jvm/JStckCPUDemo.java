package MyThink.jvm;

/**
 * 利用jstack工具，排查问题
 *
 * 首先使用top查询出占用cpu多的进程，
 * 再使用ps H -eo tid，%cpu | grep 进程id 查询进程中每个线程对应的cpu的占用
 * 再使用jstack 进程id查看该java进程相关信息  把高占用的线程id和信息中的线程对应上，查看是哪个线程出现的问题
 */
public class JStckCPUDemo {

    public static void main(String[] args) {

        new Thread(()->{
            while (true);
        }).start();

        new Thread(System.out::println).start();;
    }
}
