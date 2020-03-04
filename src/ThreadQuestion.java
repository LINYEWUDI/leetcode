/**
 * 线程分别打印出奇偶数
 */
public class ThreadQuestion implements Runnable {

    static int i = 1;
    static Object obj = new Object();

    public static void main(String[] args) {
        new Thread(new ThreadQuestion()).start();
        new Thread(new ThreadQuestion()).start();
    }
    @Override
    public void run() {
        while (i < 100){
            synchronized (obj){
                System.out.println(Thread.currentThread().getName() + "===" + ++i);
                    obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                if (i == 100){
                    obj.notify();
                }
            }
        }

    }
}
