package MyThink.jvm;

/**
 * 使用jmap查看堆中内存占用，下面的代码意义：
 * 在初始化byte数组之前查看堆中内存大小，初始化完成之后
 * 再使用jmap查看增加的大小，gc后再查看堆中的大小
 *
 * 也可以使用jconsole，界面工具进行查看，也非常直观
 */
public class JMapForHeap {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);
        Thread.sleep(20000);//此处使用jmap -heap 进程id

        byte[] bytes = new byte[1024*1024*10];
        System.out.println(2);
        Thread.sleep(20000);//此处使用jmap -heap 进程id
        System.out.println("..........");

        bytes = null;
        System.gc();
        System.out.println(3);
        Thread.sleep(10000);//此处使用jmap -heap 进程id
        System.out.println(0);

    }

}
