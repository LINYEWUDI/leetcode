package MyThink.jvm;
/**
 * 每个栈内包括很多个栈帧，每个方法对应一个栈帧。main方法对应的栈帧首先压栈，main方法中调用的show1接着入栈，依次内推。
 * 当最后一个调用的方法(栈帧)出栈后，依次出栈
 */
public class FramesDemo {
    public static void main(String[] args) {
        show1(1);
    }

    public static void show1(int a) {
        show2(a,1);
    }

    public static void show2(int a,int b) {
        System.out.println(a+b);
    }
}
