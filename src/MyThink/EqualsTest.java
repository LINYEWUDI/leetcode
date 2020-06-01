package MyThink;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class EqualsTest {

    public static void main(String[] args) {
        final HashMap hashMap = new HashMap<Person,Integer>();
        final TreeMap<Person, Integer> treeMap = new TreeMap<>();

        final Person person = new Person(1);
        final Person person1 = new Person(2);
        final Person person2 = new Person(3);


        hashMap.put(person,1);
        hashMap.put(person1,2);
        hashMap.put(person2,3);

        treeMap.put(person,1);
        treeMap.put(person1,2);
        treeMap.put(person2,3);

        hashMap.forEach((o, o2) -> System.out.println(o+"=========="+o2));
        System.out.println("====================");
        treeMap.forEach((o, o2) -> System.out.println(o+"=========="+o2));


    }

    static class Person implements Comparable{
        int age;

        public int getName(){
            return age;
        }

        public Person(int age) {
            this.age = age;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int compareTo(Object o) {
            Person person = (Person)o;
            return person.age-this.age;
        }
    }
}
