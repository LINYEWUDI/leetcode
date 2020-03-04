package MyThink;

public class StaticThreadLockTest {

    public static void main(String[] args) {
        final FatherSon fatherSon = new FatherSon();

        new Thread(fatherSon::method).start();
        new Thread(fatherSon::method).start();
    }
}

class Father{
    public synchronized void method(){
        System.out.println("我是父类的方法");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父类方法结束");
    }
}

class FatherSon extends Father{
    public synchronized void method(){
        System.out.println("我是子类的方法");
        super.method();
        System.out.println("子类方法结束");
    }
}
