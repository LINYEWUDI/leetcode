/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class day53 {

  public static void main(String[] args) {
    int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(arr));

  }

  public static int maxSubArray(int[] nums) {
    return DP(nums);
  }


  public static int DP(int[] nums) {
    final int length = nums.length;

    //确定状态  f(x) = 到数据第x个元素的最大值

    //初始化表格
    int [] arr = new int[length];
    arr[0] = nums[0];

//    状态转移方程
//    arr[i] = arr[i-1] + nums[i]  arr[i-1]>=0
//    arr[i] = nums[i]             arr[i-1]<0

    for (int i = 1; i < nums.length; i++) {
      if (arr[i-1]>0){
        arr[i] = arr[i-1] + nums[i];
      }else {
        arr[i] = nums[i];
      }
    }

    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max,arr[i]);
    }
    return max;


  }


  /**
   * 暴力法
   */
  public static int force(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int sum = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      int cur = 0;
      for (int j = i; j < nums.length; j++) {
        cur += nums[j];
        if (cur > sum) {
          sum = cur;
        }
      }

    }

    return sum;
  }
}
