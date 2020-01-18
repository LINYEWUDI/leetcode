/**
 * 给定一个包含非负整数的 m x n 网格,
 * 请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小.
 * 说明：每次只能向下或者向右移动一步.
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class day64 {

  public static void main(String[] args) {
    int [][] arr = new int[][]{
            {1,3,1},
            {1,5,1},
            {4,2,1}
    };

    int i = minPathSum(arr);
    System.out.println(i);
  }

  public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    //确定状态  f(x,y) = 在x,y这个位置总和最小
    int [][] arr = new int[m][n];

    //初始化---两个坐标轴上的点的数量为固定值
    int sum = 0;
    for (int i = 0; i < m; i++) {
      sum += grid[i][0];
      arr[i][0] = sum;
    }
    sum = 0;
    for (int i = 0; i < n; i++) {
      sum += grid[0][i];
      arr[0][i] = sum;
    }


    //状态转移  f(x,y) = min{f(x-1,y) , f(x,y-1)} + s(x,y)
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        arr[i][j] = Math.min(arr[i-1][j] , arr[i][j-1]) + grid[i][j];
      }
    }
    return arr[m-1][n-1];

  }
}
