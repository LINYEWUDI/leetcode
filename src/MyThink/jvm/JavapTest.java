package MyThink.jvm;

/**
 * 实验javap反编译和常量池中代码
 * 发现"a"一开始就是在字节码文件的常量池中，自然通过类加载器会加载进入运行时常量池
 *
 * todo：可以对字节码进行理解
 */
public class JavapTest {
    public static void main(String[] args) {
        String str = "a";
        String str1 = "b";
        String str3 = "a"+"b";
        String str4 = str+str1;
    }
}
