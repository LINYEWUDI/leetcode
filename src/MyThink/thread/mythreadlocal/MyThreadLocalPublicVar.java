package MyThink.thread.mythreadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * 往threadlocal里装一个变量，整个线程扭转过程中都可以使用这个变量
 */
public class MyThreadLocalPublicVar {


  public static void main(String[] args) {
    Service service = new Service();
    service.useUser();

  }
}

class Service{
  public void useUser(){
    User user  = new User("豆豆");
    //非单例
    ThreadLocal<User> userThreadLocal = TheadLocalHandler.newUserTheadLocal();
    //单例
    List<ThreadLocal> list = TheadLocalHandler.newUserTheadLocalList();
    userThreadLocal.set(user);
    list.add(userThreadLocal);
    new Service1().useUser();
  }
}

class Service1{
  public void useUser(){
    ThreadLocal<User> userThreadLocal = TheadLocalHandler.newUserTheadLocal();
    userThreadLocal.set(new User("阿土"));
    List<ThreadLocal> list = TheadLocalHandler.newUserTheadLocalList();
    list.add(userThreadLocal);
    new Service2().useUser();
  }
}
class Service2{
  public void useUser(){
    List<ThreadLocal> threadLocals = TheadLocalHandler.newUserTheadLocalList();
    threadLocals.forEach(threadLocal -> {
      System.out.println(threadLocal.get());
    });
  }
}
class User{
  String name;

  public User(String name) {
    this.name = name;
  }

  public void show(){
    System.out.println(name);
  }

  @Override
  public String toString() {
    return "User{" +
            "name='" + name + '\'' +
            '}';
  }
}

class TheadLocalHandler{
  //非单例
  static ThreadLocal<User> newUserTheadLocal(){
    ThreadLocal<User> userThreadLocal = new ThreadLocal<>();
    return userThreadLocal;
  }

  //单例的threadlocal集合
  static ArrayList<ThreadLocal> list = new ArrayList<>();
  static List<ThreadLocal> newUserTheadLocalList(){
    return list;

  }

}
