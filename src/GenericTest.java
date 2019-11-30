import java.util.ArrayList;

/**
 * 思想：? extends T 可以取出来，因为至少可以拿T去接。就算不知道？到底是什么类，但是肯定是T的子类。但是不能往里加，
 * 因为不知道？到底是什么类，只是知道是T的子类，往里加时无法确定用什么去接，会造成类不一致的问题，不符合java规则
 *
 *      ? super T 可以往里存，因为此时的？一定是T的父类，那么往里存的对象必须是T的子类，因为如果不是T的子类，那么就不知道存进去的对象用什么类去接受，
 *  但是不能取出来，因为
 */
public class GenericTest {
    public static void main(String[] args) {
        Person p1 = new Person();

        Son s1 = new Son();

        ArrayList<? extends Person> list = new ArrayList<>();

        ArrayList<? super Son> list1 = new ArrayList<>();

        ArrayList<? super Person> list2 = new ArrayList<>();

        ArrayList<? extends Son> list3 = new ArrayList<>();

        Person person = list.get(0);
        Object object = list1.get(0);
        Son son = list3.get(0);

//        list.add(p1);
//        list.add(s2)
        list1.add(s1);
        list1.add(p1);
        list2.add(s1);
        list2.add(p1);


    }

}


class Person{

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}

class Son extends Person{

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
