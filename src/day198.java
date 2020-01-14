import java.util.Arrays;
import java.util.LinkedList;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 */
public class day198 {
  public static int rob(int[] nums) {
    //确定状态 f(x) = 偷到第i号房屋的金钱
    int [] dp = new int[nums.length+1];

    if(nums.length == 0){
      return 0;
    }

    if(nums.length == 1){
      return nums[0];
    }

    //初始化状态
    dp[0] = 0;
    dp[1] = nums[0];

    //转移方程 f(x) = max{f(x-2)+nums[x],f(x-1)}
    for (int i = 2; i <= nums.length; i++) {
      //对于nums来说 i-1实际上就是第i个,因为从第0个开始计算
      dp[i] = Math.max(dp[i - 2] + nums[i-1], dp[i - 1]);

    }

    int max = dp[nums.length];
    return max;

  }


  public static void main(String[] args) {
    final int[] ints = {2,1,1,2};
    System.out.println(rob(ints));
  }

}
