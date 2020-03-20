package MyThink;

public class ConstructorTest {

  public static void main(String[] args) {
    ConFather c = new ConSon();
    System.out.println( c.i);

    System.out.println(((ConSon) c).i);
//    System.out.println(c.b);
  }
}


class ConFather{

  int i = 1;
  public ConFather() {
    show();
  }

  private void show(){
    System.out.println("上面的");
  }
}

class ConSon extends ConFather{
  int i = 2;
  int b = 9;
  public ConSon() {
    show();
  }


  private void show(){
    System.out.println("下面的");
  }
}
