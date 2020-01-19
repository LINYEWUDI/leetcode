public class day50 {

  public static void main(String[] args) {
    System.out.println(dp(0.00001 ,2147483647));
  }


  public static double dp(double x, int n) {
    //确定状态  f(n) = 第n次方时的值
    double [] arr = new double[Math.abs(n)+1];

    //初始化状态
    arr[0] = 1;

    //状态转移方程 f(n) = f(n-1)*x
    for (int i = 1; i < arr.length; i++) {
        arr[i] = arr[i-1] * x;
    }

    if(n > 0) return arr[Math.abs(n)];
    else return 1/arr[Math.abs(n)];


  }



  /**
   * 又超出了时间
   */
  public static double digui(double x, int n) {
    double sum = 1;

    if (n == 0) return 1;

    sum = digui(x,Math.abs(n)-1);

    sum *= x;

    return n<0? 1/sum:sum;
  }

  /**
   * 超出时间
   */
  public static double force(double x, int n) {
    double sum = 1;

    if(n > 0){
      for(int i = 0; i < n; i++){
        sum *= x;
      }
    }else{
      for(int i = 0; i < Math.abs(n); i++){
        sum *= x;
      }

      sum = 1/sum;
    }


    return sum;
  }
}
