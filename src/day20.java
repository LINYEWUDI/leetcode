import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 输入: "()"
 * 输出: true
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 输入: "(]"
 * 输出: false
 *
 * 输入: "([)]"
 * 输出: false
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class day20 {

  /**
   *  思想：该题目判断括号是否合理,故每一个左括号一定对应一个右括号且顺序一致
   *  如遇到左括号则放入栈中,每遇到一个右括号则 弹栈,弹栈出来的元素与该右括号对应,若未对应上
   *  则认为本次括号匹配是失败的
   *  因为栈顶的括号一定是需要匹配最近的右括号, 否则就是未按照疏浚的括号
   */
  public static void main(String[] args) {
    System.out.println(isValid("()"));
  }

  public static boolean isValid(String s) {
    HashMap<Character, Character> hashMap = new HashMap<>();
    hashMap.put('{','}');
    hashMap.put('[',']');
    hashMap.put('(',')');

    LinkedList<Character> list = new LinkedList<>();


    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (hashMap.containsKey(c)){
        //入栈
        list.add(c);
      }else {
        if (list.size() == 0){
          return false;
        }
        Character character = list.removeLast();
        if (c != hashMap.get(character)){
          return false;
        }
      }
    }

    if (list.size()>0) return false;
    return true;
  }

}
