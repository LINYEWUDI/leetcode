public class ThreadTest {


    public static void main(String[] args) {
        /**
         * 思想：这里的interrupt实际上只是打上了一个中断的标记，打上标记之后，在另外一个线程中进行判断。
         * 如果使用interrupted,则为判断是否有中断标记，如有中断标记则进入if逻辑，且清除该标记，如果使用isInterrupted,则不清除标记
         * 如果打上标记时的线程正在sleep，则会抛出异常，并且清除标记，也意味着会继续执行下去。
         * 下面代码会出现两种不同的情况：综合上面进行解释：
         * 如果打上标记时正在sleep，则会抛出异常，并且清除标记，if中的判断是否有中断标记也无效。如果不在sleep，则会进入if的判断中，break出去，线程一也就不再执行打印
         */
        show();
    }

    public static void show(){
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()){
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + "" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+""+i);
                if (i == 5){
                    t1.interrupt();
                }
            }
        });
        t1.start();
        t2.start();
    }

}

