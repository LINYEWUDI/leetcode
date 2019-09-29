import java.util.ArrayList;
import java.util.Collections;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class day14 {

  public static String longestCommonPrefix(String[] strs) {
    //数组长度为0时,则直接返回空串
    if (strs.length == 0) return "";
    ArrayList<Character> list = new ArrayList<>();

    int flag = 0;
    //获取字符串数组中最短长度
    int minLen = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (minLen > strs[i].length()){
        minLen = strs[i].length();
      }
    }
    //外层循环控制数组中最短字符串的长度,顺次遍历每一个字母
    for (int i = 0; i < minLen; i++) {
      char c = strs[0].charAt(i);
      //内层控制数组中每一个字符串
      for (int j = 0; j < strs.length; j++) {
        //判断数组中每一个字符串的每一个字母是否相同,相同则将标记变量置为1
        if (strs[j].charAt(i) != c){
          flag = 1;
        }
      }
      //相同的字母放入集合中
      if (flag == 0){
        list.add(c);
      }
    }
    //拼接成字符串后返回
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
      stringBuffer.append(list.get(i));
    }

    String s = String.valueOf(stringBuffer);

    return s;

  }

  public static void main(String[] args) {
    String arr[] = {"flower","flow","flight"};
    System.out.println(longestCommonPrefix(arr));
  }


}
