import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;

/**
 * fib
 */
public class day135 {

  public static void main(String[] args) {
    int fib = dp(1);
    System.out.println(fib);
  }

  /**
   * dp解法
   */
  public static int dp(int N) {
    //定义状态 f(x) = 第x个的斐波那契数是多少
    int [] arr = new int[N+1];

    if (N == 0) return 0;
    if (N == 1) return 1;

    //初始化状态
    arr[0] = 0;
    arr[1] = 1;


    //状态转移方程 f(x) = f(x-1) + f(x-2)
    for (int i = 2; i <= N; i++) {
      arr[i] = arr[i-1] + arr[i-2];
    }

    return arr[N];


  }



  /**
   * 散列表解法
   */
  static Map<Integer,Integer> map = new HashMap<>();
  public static int fibMember(int N) {
    boolean b = map.containsKey(N);
    if (b){
      return map.get(N);
    }

    int result = 0;
    if (N > 1){
      result = fibMember(N-1)+fibMember(N-2);
    }else {
      result = N;
    }

    map.put(N,result);

    return result;
  }



  /**
   * 普通递归解法
   */
  public static int fib(int N) {
      if (N == 0){
        return 0;
      }

      if (N == 1){
        return 1;
      }

        return fib(N-1)+fib(N-2);

    }
}
