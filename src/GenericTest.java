import java.util.ArrayList;

/**
 * 思想：? extends T 可以取出来，因为至少可以拿T去接。就算不知道？到底是什么类，但是肯定是T的子类。但是不能往里add，
 * 因为不知道？到底是什么类，只是知道是T的子类，往里加时无法确定用什么去接，会造成类不一致的问题，不符合java规则
 *
 *      ? super T 可以往里add，因为此时的？一定是T或者T的父类，那么往里存的对象必须是T的子类，因为如果不是T的子类，那么就不知道存进去的对象用什么类去接受，
 *  不能具体到某一个类去接收，所以只能用T去接收，比如万一add进去的是T的父类，但是集合的泛型是T，那么就会报错，也就限制了add的元素必须是T或者T的子类。
 *  此时可能会产生疑惑，那么为什么取出来的时候只能是Object呢，因为除了add之外，赋值引用也是一个问题，例如 List<? super Person> list = new ArrayList<Object>();
 *  这里因为? super Person代表着父类，所以可以直接将集合直接赋值。此时可能会产生另外一个疑惑，那为什么不能add T的父类但是可以直接赋值T父类引用的集合呢，因为直接赋值引用的集合是已经确定的类，
 *  但是add的类可能是T的各种父类，这是不符合java规则。
 *
 *  综上，思考泛型时，需要考虑泛型是否可以确定的推断为唯一标准
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

        ArrayList<Person> people = new ArrayList<>();
        list1 = people;


//        list.add(p1);
//        list.add(s2)
        list1.add(s1);
//        list1.add(p1);
        list2.add(s1);
        list2.add(p1);


        ArrayList<Person> personArrayList = new ArrayList<>();
        ArrayList<Son> sonArrayList = new ArrayList<>();

        list = personArrayList;
        list1 = sonArrayList;


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
