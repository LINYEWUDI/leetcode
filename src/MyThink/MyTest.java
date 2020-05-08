package MyThink;


class Paper{
  public void printPaper(){
    System.out.println("This is content of the paper！");
  }
}

class Decorator extends Paper{
  protected Paper paper;


  public Decorator(Paper paper) {
    this.paper = paper;
  }

  public void printPaper(){
    if (paper != null){
      super.printPaper();//todo
      paper.printPaper();
    }
  }
}

class AbstractDecorator extends Decorator{

  public AbstractDecorator(Paper t) {
    super(t);
  }

  public void printPaper(){
    System.out.println("This is Abstract of the paper！");
    super.printPaper();
  }
}

class AckonwledgementDecorator extends Decorator{

  public AckonwledgementDecorator(Paper t) {
    super(t);
  }

  public void printPaper(){
    if (paper != null){
      new AbstractDecorator(null).printPaper();
    }
    System.out.println("This is Ackonwledgement of the paper！");
  }
}

public class MyTest {
  public static void main(String[] args) {
    Paper t = new Paper();
    Paper paper;

    paper = new AbstractDecorator(new AckonwledgementDecorator(null));//todo

    paper.printPaper();
    System.out.println("=============");
    paper = new AckonwledgementDecorator(paper);
    paper.printPaper();
  }
}
