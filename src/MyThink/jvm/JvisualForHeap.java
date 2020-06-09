package MyThink.jvm;

import java.util.ArrayList;

/**
 * 比jconsole更高级的jdk工具，可以直接拿到堆的快照（dump）信息，也可以查看堆中占用内存多的类
 *
 * jconsole和jvisualvm都是直接敲命令不需要写对应的进程id，因为可以在界面选择
 */
public class JvisualForHeap {
    public static void main(String[] args) throws InterruptedException {
        final ArrayList<Student> list = new ArrayList<>();
        System.out.println(1);
        Thread.sleep(15000);

        System.out.println(2);
        for (int i = 0; i < 20; i++) {
            final Student student = new Student();
            list.add(student);
        }

        Thread.sleep(2000000l);

    }
}

class Student{

    byte[] bytes = new byte[1024*1024*10];


}
