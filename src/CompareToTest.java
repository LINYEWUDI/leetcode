import java.util.HashMap;

public class CompareToTest {

    public static void main(String[] args) {

        HashMap<Object, Object> hashMap = new HashMap<>();
        Student p1 = new Student("aa", "1");
        hashMap.put(p1,"doudou");
        String o = (String)hashMap.get(p1);
        String o1 = (String)hashMap.get(new Student("aa", "1"));
        System.out.println("o："+o);
        System.out.println("o1:"+o1);
    }

}

class Student{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student Student = (Student) o;
        return name.equals(Student.getName()) &&
                age.equals(Student.getAge()) ;
    }

//    @Override
//    public int hashCode() {
//        return 1;
//    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
