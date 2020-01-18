public class day62 {

  public static void main(String[] args) {

    System.out.println(uniquePaths(3,2));
  }

  public static int uniquePaths(int m, int n) {
    //确定状态 f(x,y) = 走到x,y有n条路径
    int [][] arr = new int[m+1][n+1];

    for (int i = 0; i < n; i++) arr[0][i] = 1;
    for (int i = 0; i < m; i++) arr[i][0] = 1;


    //转移方程 f(x,y) = f(x-1,y) + f(x,y-1) + 1
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        arr[i][j] = arr[i-1][j] + arr[i][j-1];
      }
    }

    return arr[m-1][n-1];
  }
}
