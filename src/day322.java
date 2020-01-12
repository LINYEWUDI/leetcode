/**
 *给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 输出: -1
 */
public class day322 {

    public int coinChange(int[] coins, int amount) {
        //初始化状态  f(x) = 拼成总金额的硬币数
        int [] arr = new int[amount];

        arr[0] = 0;



        //状态转移方程  f(x) = min{f(x-1),f(x-2),f(x-5)} + 1
        for (int i = 0; i < amount; i++) {
            arr[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                //拼凑的钱 > 币值
                if (i > coins[j] && arr[i-coins[j]] != Integer.MAX_VALUE){
                    arr[i] = Math.min(arr[i],arr[i-coins[j]]+1);
                }
            }
        }

        if (arr[amount] == Integer.MAX_VALUE){
            arr[amount]=-1;
        }

        return arr[amount];

    }

}
