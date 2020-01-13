/**
 *  给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */

public class day121 {
  public static void main(String[] args) {
    int [] arr = new int[]{7,6,4,3,1};
    System.out.println(maxProfit(arr));

  }

  public static int maxProfit(int[] prices) {
    return force(prices);
  }

  /**
   * DP fixme:难度过大，无法用动态规划
   */
//  public static int DP(int[] prices) {
//    //开二维数组确定初始状态  f[x][y] = g[y] - g[x]
//    int [][] arr = new int[prices.length][prices.length];
//
//    //初始化状态
//    for (int i = 0; i < prices.length; i++) {
//      arr[i][i] = 0;
//    }
//
//    //状态转移方程
//
//
//
//  }

  /**
   * 暴力
   */
  public static int force(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < i; j++) {
        int cur = prices[i]-prices[j];
        if (cur > max){
          max = cur;
        }
      }
    }

    return max;
  }

}
