import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MaxNONString {

  /**
   * 深信服题目
   * 给出一个字符串数组,找出数组中第n长的字符串
   */

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入第几个：");
    int i = scanner.nextInt();

    List<String> list = new ArrayList<>();
    list.add("abc");
    list.add("ab");
    list.add("a");
    list.add("adfeeeffff");

    Collections.sort(list, new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        if (str1 == null || "".equals(str1)) {
          return 1;
        }
        if (str2 == null || "".equals(str2)) {
          return 1;
        }

        int len1 = str1.length();
        int len2 = str2.length();
        return len2 - len1;
      }
    });


    for (int j = 0; j < list.size(); j++) {
      System.out.println(list.get(j));
    }
    System.out.println("第"+i+"个是"+list.get(i));


  }


}
