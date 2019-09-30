import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class day17 {

  public static List<String> letterCombinations(String digits) {
    HashMap<String, String> hashMap = new HashMap<>();
    hashMap.put("2","abc");
    hashMap.put("3","def");
    hashMap.put("4","ghi");
    hashMap.put("5","jkl");
    hashMap.put("6","mno");
    hashMap.put("7","pqrs");
    hashMap.put("8","tuv");
    hashMap.put("9","wxyz");

    if ("".equals(digits)){
      return new ArrayList<>();
    }

    LinkedList<String> list = new LinkedList<>();

    for (int i = 0; i < digits.length(); i++) {
      char c = digits.charAt(i);
      list.add(hashMap.get(String.valueOf(c)));
    }

    ArrayList<String> strings = new ArrayList<>();

    for (int i = 0; i < list.get(0).length(); i++) {
      for (int j = 0; j < list.get(1).length(); j++) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(list.get(0).charAt(i));
        stringBuffer.append(list.get(1).charAt(j));
        String s = stringBuffer.toString();
        strings.add(s);
      }
    }

    return strings;
  }

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }
}
