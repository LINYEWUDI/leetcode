import java.util.HashMap;
import java.util.Map;

public class day70 {

  public static void main(String[] args) {
    System.out.println(digui(2));
  }



  static Map<Integer,Integer> map = new HashMap<>();
  public static int digui(int n) {
    int result = 0;

    //确定出口
    if (n == 0){
      result = 0;
    }

    if (n == 1){
      result = 1;
    }

    if (n == 2){
      result = 2;
    }

    if (map.containsKey(n)){
      return map.get(n);
    }

    if (n > 2) result = digui(n-1)+digui(n-2);

    map.put(n,result);

    return result;

  }


  /**
   * dp
   */
  public static int dp(int n) {
    //确定状态
    int [] arr = new int[n+1];

    //初始化
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 2;

    //转移方程：  f(n) = f(n-1) || f(n-2)  +   1
    for (int i = 3; i <= n; i++) {
      arr[i] = arr[i-1]+arr[i-2];
    }

    return arr[n];


  }
}
