package MyThink.jvm;

/**
 * jstack可以发现该进程中的死锁问题
 */
public class JstackDeadThreadDemo {

    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {

        new Thread(()->{
            synchronized (object1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println(888);
                }
            }
        }).start();


        new Thread(()->{
            synchronized (object2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println(888);
                }
            }
        }).start();
    }
}
