public class day779 {

  public static void main(String[] args) {
    System.out.println(kthGrammar(4, 7));



  }

  public static int kthGrammar(int N, int K) {

    return digui(N, K, 0);
  }


  public static int digui(int N, int K,int flag) {
    //出口

    if (K == 1) {
      if (flag % 2 != 0) {
        return 1;
      } else {
        return 0;
      }
    }

    if (K == 2){

      if (flag % 2 != 0) {
        return 0;
      } else {
        return 1;

      }
    }


    //本次操作
    for (int i = N-2; i >= 1; i--) {
      double pow = Math.pow(2, i);
      if (K > pow){
        ++flag;
        K -= pow;
      }
    }

    return digui(N-1,K,flag);
  }



  /**
   * 暴力法
   */
  public static int force(int N, int K) {
          int num = 0;


        for (int i = N-2; i >= 1; i--) {
          double pow = Math.pow(2, i);
          if (K > pow){
            num++;
            K -= pow;
          }
        }


          int result = K % 2;

          if (result == 1) {
            if (num % 2 != 0) {
              return 1;
            } else {
              return 0;
            }
          } else {

            if (num % 2 != 0) {
              return 0;
            } else {
              return 1;

            }
          }
  }
}
