import java.util.*;

public class day17 {

  /**
   *  思想：
   *  1.初始化九宫格数字对应的字母在数组中
   *  2.依次遍历输入的数字，将第一个数字对应的字母放入队列中
   *  当遍历到第二个数字时，出队列的都是每一个数字对应的字母  再和第二个数字对应的字母匹配后入队列
   *  3.遍历到第三个数字时，出队列的都是第一个数字和第二个数字匹配上的字母，再和第三个字母匹配
   *  4.按此规律向下走
   */
  public static List<String> letterCombinations(String digits) {
    //初始化队列
    LinkedList<String> list = new LinkedList<>();

    //判断字符串为空的情况
    if (digits.isEmpty()) return list;

    list.add("");

    //初始化九宫格
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    for (int i = 0; i < digits.length(); i++) {
      //初始化输入的数字
      Integer integer = new Integer(String.valueOf(digits.charAt(i)));
      while (list.peek().length() == i){
        String remove = list.remove();
        for (char c : mapping[integer].toCharArray()){
          list.add(remove+c);
        }
      }
    }
    return list;
  }


  public static void main(String[] args) {
    System.out.println(letterCombinations("236"));
    System.out.println(letterCombinations("236").size());
  }
}
