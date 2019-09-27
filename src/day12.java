import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class day12 {

  public static String intToRoman(int num) {
    //分别初始化两个数组
    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    StringBuffer stringBuffer = new StringBuffer();

    for (int i = 0; i < nums.length; ) {

      while (num >= nums[i]) {
        num -= nums[i];
        stringBuffer.append(romans[i]);
      }

      i++;
    }
    return stringBuffer.toString();
  }

  public static void main(String[] args) {
    System.out.println(intToRoman(9));
  }

}
