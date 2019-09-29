import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day16 {

  public static void main(String[] args) {
    int [] arr = {1,2,4,8,16,32,64,128};
    System.out.println(threeSumClosest1(arr,82));
  }

  /**
   * 双指针
   */

  public static int threeSumClosest1(int[] nums, int target) {
    //排序
    Arrays.sort(nums);

    int len = nums.length;

    int closeSum = nums[0] + nums[1] + nums[2];

    if (len < 3 && nums == null){
      return 0;
    }

    for (int i = 0; i < len; i++) {
      int L = i+1;
      int R = len-1;

      if (i>0 && nums[i] == nums[i-1]){
        continue;
      }

      while (L < R){
        int sum = nums[i] + nums[L] + nums[R];

        if (Math.abs(sum-target) < Math.abs(closeSum-target)){
          closeSum = sum;
        }

        if (sum > target){
          R--;
        }else if (sum < target){
          L++;
        }else {
          return sum;
        }

      }
    }
    return closeSum;
  }

  /**
   * 暴力方法
   */
  public static int threeSumClosest(int[] nums, int target) {
    int len = nums.length;
    ArrayList<List<Integer>> list = new ArrayList<>();
    //初始化和
    int sum = 0;
    //初始化第一个和减去目标值的差
    int min = (nums[0] + nums[1] + nums[2]) - target;

    for (int i = 0; i < len - 2; i++) {
      for (int j = i+1; j < len - 1; j++) {
        for (int k = j+1; k < len; k++) {
          sum = (nums[i] + nums[j] + nums[k]);
          if (Math.abs(sum - target) < Math.abs(min)){
              min = sum - target;
          }
        }
      }
    }
  return min+target;
  }
}
