package MyThink.jvm;

/**
 * 利用jstack工具，排查问题
 */
public class JStckCPUDemo {

    public static void main(String[] args) {

        new Thread(()->{
            while (true);
        }).start();

        new Thread(System.out::println).start();;
    }
}
