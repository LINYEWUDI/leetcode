import java.util.ArrayList;
import java.util.Collections;

public class day14 {

  public static String longestCommonPrefix(String[] strs) {

    if (strs.length == 0) return "";
    ArrayList<Character> list = new ArrayList<>();

    int flag = 0;
    int minLen = strs[0].length();
    for (int i = 1; i < strs.length; i++) {
      if (minLen > strs[i].length()){
        minLen = strs[i].length();
      }
    }

    for (int i = 0; i < minLen; i++) {
      char c = strs[0].charAt(i);
      for (int j = 0; j < strs.length; j++) {

        if (strs[j].charAt(i) != c){
          flag = 1;
        }
      }

      if (flag == 0){
        list.add(c);
      }
    }

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
