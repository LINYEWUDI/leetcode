package MyThink.thread.mythreadlocal;

import java.util.ArrayList;
import java.util.List;

/**
 * 往threadlocal里装一个变量，整个线程扭转过程中都可以使用这个变量
 */
public class MyThreadLocalPublicVar2 {


  public static void main(String[] args) {
    Serviced service = new Serviced();
    service.useUser();

  }
}

class Serviced{
  public void useUser(){
    Userd user  = new Userd("豆豆");
    ThreadLocal<Userd> userThreadLocal = TheadLocalHandlerd.returnSameUserTheadLocal();
    userThreadLocal.set(user);

    Userd user1  = new Userd("豆豆11111");
    userThreadLocal.set(user1);
    new Serviced1().useUser();
  }
}

class Serviced1{
  public void useUser(){
    ThreadLocal<Userd> userThreadLocal = TheadLocalHandlerd.returnSameUserTheadLocal();
    Userd user = userThreadLocal.get();
    System.out.println("1=========="+user);
    new Serviced2().useUser();
  }
}

class Serviced2{
  public void useUser(){
    ThreadLocal<Userd> userThreadLocal = TheadLocalHandlerd.returnSameUserTheadLocal();
    Userd user = userThreadLocal.get();
    System.out.println("2=========="+user);
  }
}

class Userd{
  String name;

  public Userd(String name) {
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

class TheadLocalHandlerd{
  static ThreadLocal<Userd> userThreadLocal = new ThreadLocal<>();
  //单例
  static ThreadLocal<Userd> returnSameUserTheadLocal(){
    return userThreadLocal;
  }

}
