public class day70 {

  public static void main(String[] args) {
    System.out.println(climbStairs(4));
  }

  public static int climbStairs(int n) {
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
