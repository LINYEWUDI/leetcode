package MyThink.jvm;

import java.util.ArrayList;

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
